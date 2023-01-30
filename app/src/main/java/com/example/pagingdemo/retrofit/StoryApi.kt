package com.example.pagingdemo.retrofit

import com.example.pagingdemo.dataClass.StoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface StoryApi {

	@GET(value = "search_by_date")
	suspend fun getStories(@Query("page")page:Int,@Query("query")query:String):StoryModel

}