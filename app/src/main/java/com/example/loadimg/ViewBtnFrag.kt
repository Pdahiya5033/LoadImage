package com.example.loadimg

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loadimg.viewmodel.ImageViewModel

class ViewBtnFrag(private val fragContext: Context):Fragment() {
    private lateinit var viewImgBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_btn, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewImgBtn=view.findViewById(R.id.view_img_btn)
        viewImgBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainAct_fragmentContainer,ViewImgFrag(fragContext))
                .addToBackStack("ImgFragment").commit()
        }

    }

}