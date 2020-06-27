package com.example.vblog

import android.content.res.Resources
import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.InputStream

var staticArticleList:MutableList<Article>?=Article_List().l_a
class Article_List {
    private val a=Article().apply {
        setId(0)
    }
    private val b = Article(114,"一点点Github上的学习资料","2017-12-21 22:35:20.0","缘起\\n从年初到现在，在GitHub上也积累了几个开源项目，从我个人的角度来看，我觉得这些开源项目对于","## 缘起\n从年初到现在，在GitHub上也积累了几个开源项目，从我个人的角度来看，我觉得这些开源项目对于JavaEE初学者是有很大的参考价值的，因此我将这些项目和案例分享出来，希望能够给初学者一些帮助。  \n\n## 三个完整的开源项目\n\n### CoolMeeting会议管理系统\n\n项目简介：[一个开源的会议管理系统献给给位小伙伴！](http://mp.weixin.qq.com/s/JMGuiftZcEG-0yed2jkDQA)  \n项目地址：https://github.com/lenve/CoolMeeting  \n项目二维码（长按二维码进入项目主页）：  \n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7eCyDJbibdel15VKxacxVZGwdWBibmMUI8n7H9NeX2yWmfrPpHuVHGt42w/0?wx_fmt=png)  \n\n### 个人博客系统\n\n项目简介：[一个JavaWeb搭建的开源Blog系统，整合SSM框架](http://mp.weixin.qq.com/s/m85v_EPdGnOILGJMv5Cz3g)  \n项目地址：https://github.com/lenve/JavaEETest/tree/master/MyBlog    \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8icuibRHFAaiaDr24lkBAwGOeFbYswWcJ8NOY4s23eTCk4xrBibiadWtLuQ/0?wx_fmt=png)  \n\n\n### 五子棋大比武\n\n项目简介：[一个开源的五子棋大战送给各位小伙伴!](http://mp.weixin.qq.com/s/8FjP2LgzadHeGA27HfWCHw)  \n项目地址：https://github.com/lenve/GobangGame  \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e9czbiad3AWdxblRuABabpe0nIATLe4ppLZjib2Xfbm7kBgn69yzWrcbA/0?wx_fmt=png)\n\n\n## 框架案例\n\n框架案例主要包括了Spring案例、SpringMVC案例、MyBatis案例以及Spring Boot案例。  \n项目地址：https://github.com/lenve/JavaEETest  \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8aBAeeHCTHDNe4p5hWKKXTDLa3llbJxWQibPd1zlOPoH5aDicDcUNlJg/0?wx_fmt=png)  \n\n\n这些资料和开源项目都会不定期更新，我手头上还有一个ERP项目，整理好了之后也会开源给小伙伴们学习。  \n\n关注公众号可以接收到最新通知。  \n\n希望上面这些资料能够给大家的学习带来帮助，有问题欢迎留言交流。")
    /*
    * "id" : 114,
		"title" : "一点点Github上的学习资料",
		"mdContent" : "## 缘起\n从年初到现在，在GitHub上也积累了几个开源项目，从我个人的角度来看，我觉得这些开源项目对于JavaEE初学者是有很大的参考价值的，因此我将这些项目和案例分享出来，希望能够给初学者一些帮助。  \n\n## 三个完整的开源项目\n\n### CoolMeeting会议管理系统\n\n项目简介：[一个开源的会议管理系统献给给位小伙伴！](http://mp.weixin.qq.com/s/JMGuiftZcEG-0yed2jkDQA)  \n项目地址：https://github.com/lenve/CoolMeeting  \n项目二维码（长按二维码进入项目主页）：  \n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7eCyDJbibdel15VKxacxVZGwdWBibmMUI8n7H9NeX2yWmfrPpHuVHGt42w/0?wx_fmt=png)  \n\n### 个人博客系统\n\n项目简介：[一个JavaWeb搭建的开源Blog系统，整合SSM框架](http://mp.weixin.qq.com/s/m85v_EPdGnOILGJMv5Cz3g)  \n项目地址：https://github.com/lenve/JavaEETest/tree/master/MyBlog    \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8icuibRHFAaiaDr24lkBAwGOeFbYswWcJ8NOY4s23eTCk4xrBibiadWtLuQ/0?wx_fmt=png)  \n\n\n### 五子棋大比武\n\n项目简介：[一个开源的五子棋大战送给各位小伙伴!](http://mp.weixin.qq.com/s/8FjP2LgzadHeGA27HfWCHw)  \n项目地址：https://github.com/lenve/GobangGame  \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e9czbiad3AWdxblRuABabpe0nIATLe4ppLZjib2Xfbm7kBgn69yzWrcbA/0?wx_fmt=png)\n\n\n## 框架案例\n\n框架案例主要包括了Spring案例、SpringMVC案例、MyBatis案例以及Spring Boot案例。  \n项目地址：https://github.com/lenve/JavaEETest  \n项目二维码（长按二维码进入项目主页）：  \n\n![](https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8aBAeeHCTHDNe4p5hWKKXTDLa3llbJxWQibPd1zlOPoH5aDicDcUNlJg/0?wx_fmt=png)  \n\n\n这些资料和开源项目都会不定期更新，我手头上还有一个ERP项目，整理好了之后也会开源给小伙伴们学习。  \n\n关注公众号可以接收到最新通知。  \n\n希望上面这些资料能够给大家的学习带来帮助，有问题欢迎留言交流。",
		"htmlContent" : "<h2>缘起</h2>\n<p>从年初到现在，在GitHub上也积累了几个开源项目，从我个人的角度来看，我觉得这些开源项目对于JavaEE初学者是有很大的参考价值的，因此我将这些项目和案例分享出来，希望能够给初学者一些帮助。</p>\n<h2>三个完整的开源项目</h2>\n<h3>CoolMeeting会议管理系统</h3>\n<p>项目简介：<a href=\"http://mp.weixin.qq.com/s/JMGuiftZcEG-0yed2jkDQA\" target=\"_blank\">一个开源的会议管理系统献给给位小伙伴！</a><br />\n项目地址：https://github.com/lenve/CoolMeeting<br />\n项目二维码（长按二维码进入项目主页）：<br />\n<img src=\"https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7eCyDJbibdel15VKxacxVZGwdWBibmMUI8n7H9NeX2yWmfrPpHuVHGt42w/0?wx_fmt=png\" alt=\"\" /></p>\n<h3>个人博客系统</h3>\n<p>项目简介：<a href=\"http://mp.weixin.qq.com/s/m85v_EPdGnOILGJMv5Cz3g\" target=\"_blank\">一个JavaWeb搭建的开源Blog系统，整合SSM框架</a><br />\n项目地址：https://github.com/lenve/JavaEETest/tree/master/MyBlog<br />\n项目二维码（长按二维码进入项目主页）：</p>\n<p><img src=\"https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8icuibRHFAaiaDr24lkBAwGOeFbYswWcJ8NOY4s23eTCk4xrBibiadWtLuQ/0?wx_fmt=png\" alt=\"\" /></p>\n<h3>五子棋大比武</h3>\n<p>项目简介：<a href=\"http://mp.weixin.qq.com/s/8FjP2LgzadHeGA27HfWCHw\" target=\"_blank\">一个开源的五子棋大战送给各位小伙伴!</a><br />\n项目地址：https://github.com/lenve/GobangGame<br />\n项目二维码（长按二维码进入项目主页）：</p>\n<p><img src=\"https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e9czbiad3AWdxblRuABabpe0nIATLe4ppLZjib2Xfbm7kBgn69yzWrcbA/0?wx_fmt=png\" alt=\"\" /></p>\n<h2>框架案例</h2>\n<p>框架案例主要包括了Spring案例、SpringMVC案例、MyBatis案例以及Spring Boot案例。<br />\n项目地址：https://github.com/lenve/JavaEETest<br />\n项目二维码（长按二维码进入项目主页）：</p>\n<p><img src=\"https://mmbiz.qpic.cn/mmbiz_png/GvtDGKK4uYn9lpXK5EuBzEbK8b7qCE7e8aBAeeHCTHDNe4p5hWKKXTDLa3llbJxWQibPd1zlOPoH5aDicDcUNlJg/0?wx_fmt=png\" alt=\"\" /></p>\n<p>这些资料和开源项目都会不定期更新，我手头上还有一个ERP项目，整理好了之后也会开源给小伙伴们学习。</p>\n<p>关注公众号可以接收到最新通知。</p>\n<p>希望上面这些资料能够给大家的学习带来帮助，有问题欢迎留言交流。</p>\n",
		"summary" : "缘起\n从年初到现在，在GitHub上也积累了几个开源项目，从我个人的角度来看，我觉得这些开源项目对于",
		"cid" : 61,
		"uid" : 7,
		"publishDate" : "2017-12-21 22:35:20.0",
		"editTime" : "2017-12-21 22:35:20.0",
		"state" : 1,
		"pageView" : 55*/
    var l_a = mutableListOf<Article>(a,b)

}

