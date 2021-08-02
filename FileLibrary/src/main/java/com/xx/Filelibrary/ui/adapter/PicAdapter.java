package com.xx.Filelibrary.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.xx.Filelibrary.R;
import com.xx.Filelibrary.ui.adapter.viewHolder.OfficeViewHolder;
import com.xx.Filelibrary.ui.adapter.viewHolder.PicViewHolder;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class PicAdapter extends xxBaseRecycleViewAdapter<File, PicViewHolder> {


    public PicAdapter(List<File> list, Context context) {
        super(list, context);
    }

    @Override
    protected int getContentView(int viewType) {
        return R.layout.item_image;
    }

    @Override
    protected void covert(PicViewHolder holder, File data, int position) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(40));
        Glide.with(mContext).load(data.getPath()).apply(options).into(holder.iv);
    }


}
