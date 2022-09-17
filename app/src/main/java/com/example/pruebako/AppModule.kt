package com.example.pruebako

import com.example.pruebako.Retrofit.Apiservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(Apiservice.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiservices(retrofit: Retrofit): Apiservice =
        retrofit.create(Apiservice::class.java)
}