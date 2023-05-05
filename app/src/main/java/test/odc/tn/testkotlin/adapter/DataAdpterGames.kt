package test.odc.tn.testkotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.odc.tn.testkotlin.R
import test.odc.tn.testkotlin.model.Game

class DataAdpterGames(private var dataList: List<Game>, private val context: Context) :
    RecyclerView.Adapter<DataAdpterGames.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_home,
                parent,
                false
            )
        )
    }

    fun setData(newList : List<Game>){
        this.dataList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        Log.e("AERZ", "COUNT ${dataList.size}")

        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataList.get(position)

        holder.time.text = model.status.substring(0,4)
        holder.date.text = model.date.substring(0,10)
        val scoreTh = model.homeTeamScore
        val scoreTv = model.visitorTeamScore
        holder.score.text = "$scoreTh - $scoreTv"
        holder.team_1.text = model.homeTeam.name
        holder.team_2.text = model.visitorTeam.name

    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var team_1: TextView = itemLayoutView.findViewById(R.id.titleTeam1)
        var team_2: TextView = itemLayoutView.findViewById(R.id.titleTeam2)
        var date: TextView = itemLayoutView.findViewById(R.id.date)
        var score: TextView = itemLayoutView.findViewById(R.id.score)
        var time: TextView = itemLayoutView.findViewById(R.id.time)
    }

}