package com.panvova.rickmorty.di

import com.panvova.rickmorty.BuildConfig
import com.panvova.rickmorty.data.RickMortyAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { createHeadersInterceptor() }
    single { createLoggingInterceptor() }
    single { createOkHttpClient(get(), get()) }
    single { createWebService<RickMortyAPI>(get()) }
}


fun createLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

fun createHeadersInterceptor(): Interceptor {
    return Interceptor { chain ->
        val requestBuilder = chain
            .request()
            .newBuilder()
        chain.proceed(requestBuilder.build())
    }
}

fun createOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    headers: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(headers)
        .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}