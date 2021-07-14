package com.shakti.appentusapplication.service

import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.shakti.appentusapplication.model.ResponseImageItem

class ImagePaging(val api: Api): PagingSource<Int,ResponseImageItem>() {
    override fun getRefreshKey(state: PagingState<Int, ResponseImageItem>): Int? {
        return state.anchorPosition?.let { val anchorPage=state?.closestPageToPosition(it)
        anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)}
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseImageItem> {
        val page = params.key?:1
        return try {
            val response = api.getImages(page)


            LoadResult.Page(
                response,
                prevKey = if(page==1) null else page-1,
                nextKey = if (response.isEmpty()!!)null else page+1

            )
        }
        catch (e:Exception)
        {
            LoadResult.Error(e)
        }
    }
}