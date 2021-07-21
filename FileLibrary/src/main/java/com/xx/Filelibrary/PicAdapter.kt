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

class PicAdapter(c: Context, l: List<File>):RecyclerView.Adapter<PicViewHolder>() {
    val context:Context=c;
    val list:List<File> = l

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicViewHolder {

        val view: View =LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);

        return PicViewHolder(view);
    }

    override fun onBindViewHolder(holder: PicViewHolder, position: Int) {

        //Glide设置图片圆角角度
        val roundedCorners = RoundedCorners(40)
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(20, 20);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(20, 20);
        val options: RequestOptions = RequestOptions.bitmapTransform(roundedCorners)
        Glide.with(context).load(list.get(position).getPath()).apply(options).into(holder.iv)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}