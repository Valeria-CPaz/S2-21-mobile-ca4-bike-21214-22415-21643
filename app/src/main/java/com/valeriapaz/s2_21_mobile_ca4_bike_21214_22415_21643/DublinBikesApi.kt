package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.jcdecaux.com/vls/v1/"

interface DublinBikesApi {

    @GET("stations?contract=dublin&apiKey=8c0421336bf19ae390c470eb7858662f82772d84")
    fun getBikes(): Call<List<BikesModels>>

    companion object {
        operator fun invoke(): DublinBikesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DublinBikesApi::class.java)
        }
    }
}

