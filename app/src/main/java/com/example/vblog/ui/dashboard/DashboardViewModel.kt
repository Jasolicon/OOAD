package com.example.vblog.ui.dashboard

import android.os.Build
import android.os.Build.*
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vblog.Article
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DashboardViewModel : ViewModel() {

    val writing = MutableLiveData<Article>().apply{
        value=Article()
    }

}
