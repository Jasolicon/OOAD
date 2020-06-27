package com.example.vblog.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vblog.Article
import com.example.vblog.Article_List
import com.example.vblog.BlogAdapter

class HomeViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
    var l_a = Article_List().l_a
    private val _mAdapter = MutableLiveData<MutableList<Article>>().apply {
        value = l_a
    }
    var _selected:Article?=null
    val mList=_mAdapter
}