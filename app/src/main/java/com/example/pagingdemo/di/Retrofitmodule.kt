package com.example.pagingdemo.di

import com.example.pagingdemo.retrofit.StoryApi
import com.example.pagingdemo.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Retrofitmodule {

	@Provides
	@Singleton
	fun getRetrofit(): Retrofit {
		return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
			GsonConverterFactory.create()).build()
	}

	@Provides
	@Singleton
	fun getStoryAPI(retrofit: Retrofit):StoryApi{
		return retrofit.create(StoryApi::class.java)
	}
}