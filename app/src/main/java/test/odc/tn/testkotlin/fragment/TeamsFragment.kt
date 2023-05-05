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
import test.odc.tn.testkotlin.adapter.DataAdapterTeams
import test.odc.tn.testkotlin.model.HomeTeam
import test.odc.tn.testkotlin.model.ModelT
import test.odc.tn.testkotlin.networking.ApiClient

open class TeamsFragment : Fragment(){


    private lateinit var dataAdpterTeams: DataAdapterTeams

    var dataList = listOf<HomeTeam>()
    lateinit var recyclerView: RecyclerView
    lateinit var progressB: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_teams, container, false)!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.list_teams)
        progressB = view.findViewById(R.id.progress_bar_teams) as ProgressBar

        //setting up the adapter
        dataAdpterTeams = DataAdapterTeams(dataList, requireContext())
        recyclerView.adapter = dataAdpterTeams
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        getDataTeams()

    }


    private fun getDataTeams() {
        val call: Call<ModelT> = ApiClient.getClient.getTeams()
        call.enqueue(object : Callback<ModelT> {

            override fun onResponse(call: Call<ModelT>?, response: Response<ModelT>?) {
                Log.e("TAG", "LOG1")
                recyclerView.visibility = View.VISIBLE
                progressB.visibility = View.GONE
                dataAdpterTeams.setData(response?.body()?.dataT!!)


            }

            override fun onFailure(call: Call<ModelT>?, t: Throwable?) {

                Log.e("TAG", "LOG1", t)
            }

        })
        Log.e("TAG", "LOG2")
    }


}