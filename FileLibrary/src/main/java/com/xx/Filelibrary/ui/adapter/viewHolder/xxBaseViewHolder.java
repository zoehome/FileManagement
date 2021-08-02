package com.xx.Filelibrary.ui.adapter.viewHolder;

import android.util.SparseArray;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

public abstract class xxBaseViewHolder extends RecyclerView.ViewHolder {


    private SparseArray<View> views;

    public xxBaseViewHolder(View view) {
        super(view);
        this.views = new SparseArray<>();
        ButterKnife.bind(this, itemView);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

  /*  public xxBaseViewHolder setText(int viewId, String text) {
        TextView tv = (TextView) this.getView(viewId);
        tv.setText(text);
        return this;
    }

    public xxBaseViewHolder setTextColor(Context mContext, int viewId, int color) {
        TextView tv = (TextView) this.getView(viewId);
        tv.setTextColor(mContext.getResources().getColor(color));
        return this;
    }

    public xxBaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = this.getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }*/
}
