package com.example.loadimg

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loadimg.viewmodel.ImageViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class ViewImgFrag(private val fragContext: Context) : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var imgAdapter: ImgViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_img, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeImgRecView()
        fetchDataFromApi()
    }

    private fun initializeImgRecView() {
        imgAdapter = ImgViewAdapter(requireContext())
        val rvPosts: RecyclerView = requireView().findViewById(R.id.img_recView)
        rvPosts.apply {
            adapter = imgAdapter
            layoutManager = LinearLayoutManager(requireView().context)
        }

    }
    private fun fetchDataFromApi(){
        val viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        viewModel.getPics()
        viewModel.myResponseList.observe(viewLifecycleOwner, Observer {
            for(pics in it){
                Log.d(ContentValues.TAG,pics.url)
                imgAdapter.urlList.add(pics.url)
            }
        })
        imgAdapter.notifyDataSetChanged()
    }

}