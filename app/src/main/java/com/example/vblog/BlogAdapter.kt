package com.example.vblog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.vblog.ui.home.HomeFragment

class BlogAdapter: BaseAdapter {
    private lateinit var ArticleList: MutableList<Article>
    private lateinit var mContext:Context
    private var mrow:Article?=null
    constructor(AList:MutableList<Article>, mCtext: Context) {
        ArticleList = AList
        mContext=mCtext
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var viewHolder=mViewHolder()
        var mView=convertView
        if(mView==null){
            mView = LayoutInflater.from(mContext).inflate(R.layout.layout_adaper,parent,false)
            viewHolder.ll_part=mView.findViewById(R.id.ll_part) as LinearLayout
            viewHolder.tv_title=mView.findViewById(R.id.tv_title) as TextView
            viewHolder.tv_date=mView.findViewById(R.id.tv_publishDate) as TextView
            viewHolder.tv_summary=mView.findViewById(R.id.tv_summary) as TextView
            mView.tag=viewHolder
        }else{
            viewHolder=mView.tag as mViewHolder
        }

        val mrow = ArticleList[position]
        viewHolder.tv_title.text=mrow.getTitle()
        viewHolder.tv_date.text=mrow.getPublishDate()
        viewHolder.tv_summary.text=mrow.getSummary()
//        viewHolder.tv_title.setOnClickListener {
//            var intent = Intent(this.mContext, BlogActivity::class.java).apply {
//                putExtra("selected",mrow)
//            }
//            this.mContext.startActivity(intent)
//        }

        return mView!!


    }

    override fun getItem(position: Int): Any {
        return ArticleList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return ArticleList?.size ?: 0
    }
}

public final class mViewHolder{
    public lateinit var ll_part:LinearLayout
    public lateinit var tv_title:TextView
    public lateinit var tv_date:TextView
    public lateinit var tv_summary:TextView
}