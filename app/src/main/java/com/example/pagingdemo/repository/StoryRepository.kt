package com.example.pagingdemo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagingdemo.paging.StoryPagingSource
import com.example.pagingdemo.retrofit.StoryApi
import javax.inject.Inject

class StoryRepository @Inject constructor(private val storyApi: StoryApi) {

	fun getStories() = Pager(
		config = PagingConfig(20, maxSize = 300),
          pagingSourceFactory = { StoryPagingSource(storyApi) }
		).liveData
}