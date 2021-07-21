package com.xx.Filelibrary

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import java.io.File

class OfficeFileAdapter(c: Context, l: List<File>):RecyclerView.Adapter<OfficeViewHolder>() {
    val context:Context=c;
    val list:List<File> = l

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {

        val view: View =LayoutInflater.from(context).inflate(R.layout.item_txt, parent, false);

        return OfficeViewHolder(view);
    }

    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {

        holder.tv.setText(list.get(position).name)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}