package com.demo.marveldemo.di

import com.demo.marveldemo.BuildConfig
import com.demo.network.retrofit.CharacterNetworkService
import com.demo.network.source.CharacterRemoteDataSource
import com.demo.network.source.CharacterRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun networkInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request()
        val originalHttpUrl = request.url()

        val currentTimestamp = Calendar.getInstance().timeInMillis

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", BuildConfig.TS)
            .addQueryParameter("apikey", BuildConfig.API_KEY)
            .addQueryParameter("hash", BuildConfig.HASH)
            .build()

        val builder = request.newBuilder()
//            .addHeader("Content-Type", "application/json")
            .url(url)
            .build()

        return@Interceptor chain.proceed(builder)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient{
       return OkHttpClient.Builder()
            .connectTimeout(BuildConfig.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(BuildConfig.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(BuildConfig.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterNetworkService(retrofit: Retrofit): CharacterNetworkService{
        return retrofit.create(CharacterNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRemoteDataSource(characterNetworkApi: CharacterNetworkService): CharacterRemoteDataSource {
        return CharacterRemoteDataSourceImpl(characterNetworkApi)
    }
}