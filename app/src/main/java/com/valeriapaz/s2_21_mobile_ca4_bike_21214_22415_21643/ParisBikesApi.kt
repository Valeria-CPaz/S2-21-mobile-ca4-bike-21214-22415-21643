package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL2 = "https://api.jcdecaux.com/vls/v1/"

interface ParisBikesApi {

    @GET("stations?contract=lyon&apiKey=8c0421336bf19ae390c470eb7858662f82772d84")
    fun getBikes(): Call<List<BikesModels>>

    companion object {
        operator fun invoke(): ParisBikesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ParisBikesApi::class.java)
        }
    }
}