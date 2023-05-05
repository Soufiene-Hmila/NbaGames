package test.odc.tn.testkotlin.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.odc.tn.testkotlin.R
import test.odc.tn.testkotlin.adapter.DataAdpterGames
import test.odc.tn.testkotlin.model.Game
import test.odc.tn.testkotlin.model.Model
import test.odc.tn.testkotlin.networking.ApiClient

open class GamesFragment : Fragment() {

    private lateinit var dataAdpterGames: DataAdpterGames
    var dataList = listOf<Game>()
    lateinit var progressB: ProgressBar
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_games, container, false)!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        progressB = view.findViewById(R.id.progress_bar_games) as ProgressBar

        recyclerView = view.findViewById(R.id.list_gamer)
        //setting up the adapter
        dataAdpterGames = DataAdpterGames(dataList, requireContext())
        recyclerView.adapter = dataAdpterGames
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false)
        getDataGames()

    }


    private fun getDataGames() {
        val call: Call<Model> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<Model> {

            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {
                dataAdpterGames.setData(response?.body()?.data!!)
                    recyclerView.visibility = View.VISIBLE
                    progressB.visibility = View.GONE

            }

            override fun onFailure(call: Call<Model>?, t: Throwable?) {

            }

        })
    }


}
