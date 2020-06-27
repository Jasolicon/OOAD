package com.example.vblog

import java.io.Serializable

class Article:Serializable {
    private var id: Long? = null
    private var title: String? = null
    private var mdContent: String? = null
    private var htmlContent: String? = null
    private var summary: String? = null
    private val cid: Long? = null
    private val uid: Long? = null
    private var publishDate: String? = null
    private var editTime: String? = null
    private val nickname: String? = null
    constructor()
    constructor(i:Long,t:String,d:String,s:String,m:String){
        id=i
        title=t
        publishDate= d
        summary=s
        mdContent=m
    }
    public fun getId():Long?{
        return id
    }
    public fun getTitle():String?{
        return title?:"未记录题目！"
    }
    public fun getSummary():String?{
        return summary ?: "未记录摘要！"
    }
    public fun getPublishDate():String?{
        return publishDate ?: "未登记日期!"
    }
    public fun getEditTime():String?{
        return editTime ?: "未登记时间!"
    }
    public fun getMdContent():String?{
        return mdContent?:"没有文章(md)"
    }
    public fun getHtmlContent():String?{
        return htmlContent?:"没有文章(html)"
    }
    fun setTitle(input:String?){
        title=input
    }
    fun setId(input:Long?){
        id=input
    }
    fun setSummary(input: String?){
        summary=input
    }
    fun setPublishDate(input: String?){
        publishDate=input
    }
    fun setEditTime(input: String?){
        editTime=input
    }
    fun setMdContent(input: String?){
        mdContent=input
    }
    fun setHtmlContent(input: String?){
        htmlContent=input
    }

}