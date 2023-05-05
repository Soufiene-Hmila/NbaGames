package test.odc.tn.testkotlin.model

import com.google.gson.annotations.SerializedName

data class ModelT(

    @SerializedName("data")
    val dataT : List<HomeTeam>

)