package com.example.vblog.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.vblog.BlogActivity
import com.example.vblog.BlogAdapter
import com.example.vblog.R
import com.example.vblog.ui.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        lv_menu.setOnItemClickListener { parent, view, position, id ->
//            var intent: Intent = Intent(requireActivity(), BlogActivity::class.java).apply {
//                putExtra("selected", homeViewModel.l_a[position])
//            }
//            if (intent == null) {
//                Toast.makeText(this.requireContext(), "null", Toast.LENGTH_SHORT).show()
//            } else {
//                requireActivity().startActivity(intent)
//            }
//        }
            homeViewModel.mList.observe(viewLifecycleOwner, Observer {
                lv_menu.adapter = BlogAdapter(it, this.requireContext())
                lv_menu.setOnItemClickListener { parent, view, position, id ->
                //fragment to fragment error
                homeViewModel._selected=it[position]
                try{

                var ft = activity?.supportFragmentManager?.beginTransaction()
                var df = DashboardFragment()
                    print(df.toString())
                    if(!df.isAdded) {
                        df.arguments?.apply {
                            putSerializable("selected", it[position])
                        }

                        ft?.replace(R.id.navigation_dashboard, df)
                            ?.commit()
                    }
                }catch (e:Exception){
                    print(e)
                    Toast.makeText(this.requireContext(), e.toString(),Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this.requireContext(), "clicked$position",Toast.LENGTH_SHORT).show()
            }
            })

            return root
        }
}