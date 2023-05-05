package test.odc.tn.testkotlin.model

import com.google.gson.annotations.SerializedName
import java.lang.reflect.Array

data class Model(

    @SerializedName("data")
    val data : List<Game>

)