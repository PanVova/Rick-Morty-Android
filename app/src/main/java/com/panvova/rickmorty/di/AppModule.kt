package com.panvova.rickmorty.di

import androidx.room.Room
import com.panvova.rickmorty.BuildConfig
import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.data.gatewayImpl.RickMortyGatewayImpl
import com.panvova.rickmorty.db.AppDatabase
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.usecase.GetCharactersUseCase
import com.panvova.rickmorty.domain.usecase.GetEpisodesUseCase
import com.panvova.rickmorty.domain.usecase.GetLocationsUseCase
import com.panvova.rickmorty.presentation.features.characters.CharactersPresenter
import com.panvova.rickmorty.presentation.features.episodes.EpisodePresenter
import com.panvova.rickmorty.presentation.features.locations.LocationPresenter
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val roomWeatherApp: List<Module>
  get() = listOf(rickMortyAppModule, remoteDataSourceModule, roomDataSourceModule)

// TODO provide schedulers coroutines
// TODO clean code
// TODO divide modules for koin

val rickMortyAppModule = module {
  single<RickMortyGateway> {
    RickMortyGatewayImpl(
      rickMortyAPI = get(),
      characterDao = get(),
      episodeDao = get(),
      locationDao = get()
    )
  }

  factory { CharactersPresenter(get()) }
  factory { EpisodePresenter(get()) }
  factory { LocationPresenter(get()) }

}

val remoteDataSourceModule = module {
  single { createOkHttpClient() }
  single { createWebService<RickMortyAPI>(get()) }
}

val roomDataSourceModule = module {
  // Weather Room Data Repository
  single<RickMortyGateway> {
    RickMortyGatewayImpl(
      rickMortyAPI = get(),
      characterDao = get(),
      episodeDao = get(),
      locationDao = get()
    )
  }

  single { GetCharactersUseCase(get()) }
  single { GetEpisodesUseCase(get()) }
  single { GetLocationsUseCase(get()) }

  // Room Database
  single {
    Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "local-storage")
      .build()
  }

  // Expose WeatherDAO
  single { get<AppDatabase>().characterDao() }
  single { get<AppDatabase>().episodeDao() }
  single { get<AppDatabase>().locationDao() }
}

fun createOkHttpClient(): OkHttpClient {
  // divide to functions
  val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
  }

  val headers = Interceptor { chain ->
    val requestBuilder = chain
      .request()
      .newBuilder()
    chain.proceed(requestBuilder.build())
  }

  return OkHttpClient.Builder()
    .addInterceptor(headers)
    .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(
  okHttpClient: OkHttpClient,
  //url: String
): T {
  val retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.API)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
  return retrofit.create(T::class.java)
}