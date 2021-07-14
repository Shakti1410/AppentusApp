package com.shakti.appentusapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn

import com.shakti.appentusapplication.model.ResponseImageItem
import com.shakti.appentusapplication.service.Api
import com.shakti.appentusapplication.service.ImagePaging
import com.shakti.appentusapplication.service.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel: ViewModel() {

    lateinit var retroservice : Api

    init {
        retroservice = RetrofitInstance.getRetrofitInstance().create(Api::class.java)
    }
    fun getListData(): Flow<PagingData<ResponseImageItem>>{
        return Pager(config = PagingConfig(pageSize =20,maxSize = 200 ),//enableplceholder
        pagingSourceFactory = {ImagePaging(retroservice)}).flow.cachedIn(viewModelScope)
    }

}