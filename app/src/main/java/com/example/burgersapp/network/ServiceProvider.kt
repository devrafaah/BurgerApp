package com.example.burgersapp.network

import android.content.Context
import io.github.brunogabriel.mockpinterceptor.MockPInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ServiceProvider @Inject constructor(
    context: Context
) {
    private val urlBase = "https://burgers-hub.p.rapidapi.com/"

    private val mockInterceptor = MockPInterceptor
        .Builder(context)
        .addDelayInMillis(1_000L, 2_000L)
        .build()


    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(Interceptor { chain ->
            chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(
                            name = "x-rapidapi-key",
                            value = "1f59aa174fmsh8ac956c60b609e4p155ba0jsn30c19bccfdda"
                        )
                        .build()
                )
            }
        })
        .addInterceptor(mockInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun <API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}
