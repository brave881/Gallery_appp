package com.example.gallery1.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.gallery1.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

  //https://api.unsplash.com/search/photos?query=office&client_id=zfDB6i-fsjUVEuyUJYGe4sVaWKr29czUV1paO7Wsohw
class NetworkManager {
    companion object {
        private var retrofit: Retrofit? = null
        private var api: Api? = null
        fun getInstance(context: Context): Api {

            val client = OkHttpClient.Builder()
                .addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .collector(ChuckerCollector(context))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
                .build()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.unsplash.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                api = retrofit!!.create(Api::class.java)
            }
            return api!!
        }
    }
}