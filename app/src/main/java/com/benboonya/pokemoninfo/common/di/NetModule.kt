package com.benboonya.pokemoninfo.common.di

import com.benboonya.pokemoninfo.BuildConfig
import com.benboonya.pokemoninfo.common.ApiConstant
import com.benboonya.pokemoninfo.common.PokemonApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netModule = module {
    single { provideHttpLoggingInterceptor() }
    single { provideHttpClient(get()) }
    single { provideConverterFactory() }
    single { providePokemonApi(ApiConstant.BASE_URL, get(), get()) }
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return logging
}

private fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

private fun provideConverterFactory() = GsonConverterFactory.create()

private fun providePokemonApi(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
): PokemonApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
        .create(PokemonApi::class.java)