package com.xx.Filelibrary.ui.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.xx.Filelibrary.R;
import com.xx.Filelibrary.ui.adapter.viewHolder.OfficeViewHolder;

import java.io.File;
import java.util.List;

  public class OfficeFileAdapter extends xxBaseRecycleViewAdapter<File,OfficeViewHolder> {

      public OfficeFileAdapter(List<File> list, Context context) {
          super(list, context);
      }


      @Override
      protected int getContentView(int viewType) {
          return R.layout.item_txt;
      }

      @Override
      protected void covert(OfficeViewHolder holder, File data, int position) {
          holder.tv.setText(data.getName());
      }


  }