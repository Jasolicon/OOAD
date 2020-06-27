package com.example.vblog

var staticArticleList:MutableList<Article>?=Article_List().l_a
class Article_List {
    private val a=Article()
    private val b = Article(1,"题目","2020-6-22","摘要","内容")
    var l_a = mutableListOf<Article>(a,b)
}