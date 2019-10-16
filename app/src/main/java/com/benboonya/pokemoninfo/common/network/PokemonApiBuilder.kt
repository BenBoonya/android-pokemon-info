package com.benboonya.pokemoninfo.common.network

import com.benboonya.pokemoninfo.BuildConfig
import com.benboonya.pokemoninfo.common.ApiConstant
import com.benboonya.pokemoninfo.common.PokemonApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PokemonApiBuilder @Inject constructor() {

    fun build(): PokemonApi =
        Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(provideConverterFactory())
            .client(provideHttpClient())
            .build()
            .create(PokemonApi::class.java)


    private fun provideHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private fun provideConverterFactory() = GsonConverterFactory.create()

}