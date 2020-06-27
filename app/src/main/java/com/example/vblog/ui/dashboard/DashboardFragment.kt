package com.example.vblog.ui.dashboard

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.vblog.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_adaper.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.min

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        tv_time_b.text= getDate()
//        var selected = this.requireArguments().get("selected") as Article
//        if(selected==null){
//            tv_date.text=dashboardViewModel.date
            et_title.text=null
            et_mdContent.text=null
//        }else{
//            tv_date.text=selected.getPublishDate()
//
//            tv_title.text=selected.getTitle()
//            et_mdContent.text=selected.getMdContent()
//        }

        dashboardViewModel.writing.observe(viewLifecycleOwner, Observer {
//            if (this.arguments != null) {
//
//                it.apply {
//                    setId(selected.getId())
//                    setTitle(selected.getTitle())
//                    setPublishDate(selected.getPublishDate())
//                    setEditTime(selected.getEditTime())
//                    setSummary(selected.getSummary())
//                    setMdContent(selected.getMdContent())
//                    setHtmlContent(selected.getHtmlContent())
//                }
//
//            }else{
                it.apply {
//                    setId()
                    setTitle(et_title.text.toString())
                    setPublishDate(tv_date_b.text.toString())
                    setEditTime(tv_time_b.text.toString())
                    setSummary(et_mdContent.text[min(tv_summary.text.length,100)].toString())
                    setMdContent(et_mdContent.text.toString())
                    setHtmlContent("<p>"+et_mdContent.text.toString()+"</p>")
//                }
            }
        })
//        btnConfirm.setOnClickListener {
//            staticArticleList?.add(dashboardViewModel.writing.value!!)
//            Toast.makeText(this.requireContext(),"上传",Toast.LENGTH_SHORT).show()
//            print(staticArticleList)
//        }
        return root
    }
}
@RequiresApi(Build.VERSION_CODES.O)
private fun getDate():String{
    val current = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formatted = current.format(formatter)

    return formatted.toString()
}