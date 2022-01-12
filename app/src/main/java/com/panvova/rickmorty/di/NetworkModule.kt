package com.panvova.rickmorty.di

import com.panvova.rickmorty.data.RickMortyAPI
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headers: Interceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headers)
        .build()


    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun provideHeadersInterceptor(): Interceptor =
        Interceptor { chain ->
            val requestBuilder = chain
                .request()
                .newBuilder()
            chain.proceed(requestBuilder.build())
        }

    @Provides
    fun provideRetrofit(@Named("url") baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    @Provides
    fun providePlaiAPI(retrofit: Retrofit): RickMortyAPI = retrofit.create(RickMortyAPI::class.java)
}