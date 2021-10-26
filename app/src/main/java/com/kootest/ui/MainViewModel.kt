package com.kootest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genericresponse.CommState
import com.genericresponse.NetworkResponse
import com.google.gson.Gson
import com.kootest.data.repositiories.UserFeedRepository
import com.kootest.data.response.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: UserFeedRepository


    @Inject
    lateinit var gson: Gson

    private val _userFeedFlow = MutableSharedFlow<CommState<List<Feed>>>()
    val userFeedFlow: SharedFlow<CommState<List<Feed>>> = _userFeedFlow

    private var pageNumber = 1
    private var totalPage = 0

    fun getFeed() {
        viewModelScope.launch(Dispatchers.IO) {
            if (pageNumber == totalPage) {
                _userFeedFlow.emit(CommState.Nothing("Reach End"))
                return@launch
            }
            repository.getUserFeeds(pageNumber).collectLatest { data ->
                when (data) {
                    is NetworkResponse.Init -> {
                        _userFeedFlow.emit(CommState.Loading())
                    }
                    is NetworkResponse.Success -> {
                        pageNumber = data.body.meta.pagination.page + 1
                        _userFeedFlow.emit(CommState.Success(data.body.data))
                    }
                    else -> {
                        _userFeedFlow.emit(CommState.Error())
                    }
                }
            }
        }
    }


}