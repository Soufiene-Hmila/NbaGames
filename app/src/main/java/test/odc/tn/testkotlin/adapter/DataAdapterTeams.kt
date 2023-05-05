package test.odc.tn.testkotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.odc.tn.testkotlin.R
import test.odc.tn.testkotlin.model.HomeTeam

class DataAdapterTeams(private var dataList: List<HomeTeam>, private val context: Context) :
    RecyclerView.Adapter<DataAdapterTeams.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_teams,
                parent,
                false
            )
        )
    }

    fun setData(newList : List<HomeTeam>){
        this.dataList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        Log.e("AERZ", "COUNT ${dataList.size}")
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelT = dataList[position]


        holder.fullName.text = modelT.fullName + " ("+modelT.abbreviation+")"
        holder.city.text = "city : "+modelT.city
        holder.division.text = "division : "+modelT.division
        holder.nameT.text = "name : "+modelT.name
        holder.conference.text = "conference : "+modelT.conference


    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var fullName: TextView = itemLayoutView.findViewById(R.id.title)
        var city: TextView = itemLayoutView.findViewById(R.id.city)
        var division: TextView = itemLayoutView.findViewById(R.id.division)
        var nameT: TextView = itemLayoutView.findViewById(R.id.name)
        var conference: TextView = itemLayoutView.findViewById(R.id.conference)
    }

}