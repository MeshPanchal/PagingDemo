package com.example.pagingdemo.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingdemo.dataClass.Hit
import com.example.pagingdemo.retrofit.StoryApi
import retrofit2.HttpException

class StoryPagingSource(val storyApi: StoryApi) : PagingSource<Int,Hit>(){

	//var position = -1
	override fun getRefreshKey(state: PagingState<Int, Hit>): Int? {
		return state.anchorPosition?.let {
			state.closestPageToPosition(it)?.prevKey?.plus(1)
				?: state.closestPageToPosition(it)?.nextKey?.minus(1)
		}
	}

	override suspend fun load(params: LoadParams<Int>): PagingSource.LoadResult<Int, Hit> {
		return try {

			val page = params.key ?: 1
			val response = storyApi.getStories(page,"json")
			LoadResult.Page(
				data = response.hits ,
				prevKey = if (page == 1) null else page-1 ,
				nextKey = if (page==response.nbPages) null else page+1
			)
		}catch (e:Exception){
			LoadResult.Error(e)
		}catch (e:HttpException){
			LoadResult.Error(e)
		}
	}
}