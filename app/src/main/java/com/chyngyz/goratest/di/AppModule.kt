package com.chyngyz.goratest.di

import com.chyngyz.goratest.network.GoraApi
import com.chyngyz.reader.utils.Constants.BASE_URL
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

   @Singleton
   @Provides
   fun provideBookApi(): GoraApi {
      return Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(GoraApi::class.java)
   }



}