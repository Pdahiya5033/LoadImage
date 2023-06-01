package com.example.loadimg


import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImgViewAdapter(private val mainContext:Context): RecyclerView.Adapter<ImgViewAdapter.ViewHolderImg>() {
    var urlList= mutableListOf<String>()
    inner class ViewHolderImg(itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.loaded_image)
        val progressBar:ProgressBar=itemView.findViewById(R.id.progressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImg {
        return ViewHolderImg(
            LayoutInflater.from(parent.context).inflate(
                R.layout.img_recview_contents, parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolderImg, position: Int) {
        holder.progressBar.visibility=View.VISIBLE
        if(urlList.size>0){
            val tempUrl= urlList[position]
            Glide.with(mainContext).load(tempUrl).into(holder.image)
            holder.progressBar.visibility=View.INVISIBLE
        }
    }
    override fun getItemCount(): Int {
         if(urlList.size ==0){
             return 10
         }
        return urlList.size
    }
}
