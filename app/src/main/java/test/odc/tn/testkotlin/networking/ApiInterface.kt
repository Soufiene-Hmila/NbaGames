package test.odc.tn.testkotlin.networking

import retrofit2.Call
import retrofit2.http.GET
import test.odc.tn.testkotlin.model.Model
import test.odc.tn.testkotlin.model.ModelT

interface ApiInterface {

    @GET("v2/5de8d38a3100000f006b1479")
    fun getData(): Call<Model>



    @GET("v2/5de8d40d31000074006b1487")
    fun getTeams(): Call<ModelT>
}