package com.example.vblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.fragment_home.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
//        textView.text= staticArticleList?.last()?.getTitle().toString()
        lv_blogmenu.adapter = BlogAdapter(staticArticleList!!, this)
        lv_blogmenu.setOnItemClickListener { parent, view, position, id ->
//            _intent: Intent = Intent(this, BlogActivity::class.java).apply {
//                putExtra("selected", staticArticleList!![position])
//            }
            var intent: Intent = Intent(this, BlogActivity::class.java).apply {
                putExtra("selected", staticArticleList!![position])
                putExtra("position",position)
            }
            Toast.makeText(this,"list open",Toast.LENGTH_SHORT).show()

            startActivity(intent)

        }
    }
}