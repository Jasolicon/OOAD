package com.example.vblog

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_blog.*
import java.lang.Integer.max
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class BlogActivity : AppCompatActivity() {
//    private var _intent:Intent = Intent(this,ListActivity::class.java)
    var selected = Article()
    var position=-1
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)
        tv_date_b.text=getDate()
        tv_time_b.text=getDate()

//        selected = intent?.getSerializableExtra("selected") as Article
//        tv_date_b.text=selected.getPublishDate()
//
//        et_title.text=selected.getTitle() as Editable
//        et_mdContent.text=selected.getMdContent() as Editable


        btnConfirm.setOnClickListener {onClick()}
        btnList.setOnClickListener {onClickOpenListActivity()}
}

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        setIntent(intent)

        selected = intent!!.getSerializableExtra("selected") as Article
        Toast.makeText(this,selected.getTitle(), Toast.LENGTH_SHORT).show()
        tv_date_b.text=selected.getPublishDate()
        tv_time_b.text=selected.getEditTime()
        et_title.setText(selected.getTitle())
        et_mdContent.setText(selected.getMdContent())
        position=intent!!.getIntExtra("position",-1)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onClick(){
//        var currentArticle = Article()
        selected.apply{
            setTitle(et_title.text.toString())
            setPublishDate(tv_date_b.text.toString())
            setMdContent(et_mdContent.text.toString())
            setEditTime(getDate().toString())
            setHtmlContent("<p>"+et_mdContent.text.toString()+"</p>")
//            setSummary(et_mdContent.text.toString().substring(0,max(et_mdContent.text.toString().length,20)))
        }.let { if(position==-1){staticArticleList?.add(it)}else{
            staticArticleList?.set(position, it)
        }

        }
//        TODO("sql")
//        staticArticleList?.add(currentArticle)
        Toast.makeText(this,"已上传",Toast.LENGTH_SHORT).show()
    }
    private fun onClickOpenListActivity(){
        var intent:Intent = Intent(this,ListActivity::class.java)
        startActivity(intent)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDate():String{
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = current.format(formatter)

        return formatted.toString()
    }
    @SuppressLint("WrongConstant")
    fun isIntentAvailable(context: Context, intent: Intent?): Boolean {
        val packageManager: PackageManager = context.getPackageManager()
        val list = packageManager.queryIntentActivities(
            intent,
            PackageManager.GET_ACTIVITIES
        )
        return list.size > 0
    }
}