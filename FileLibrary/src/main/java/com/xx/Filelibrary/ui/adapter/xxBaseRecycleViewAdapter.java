package com.xx.Filelibrary.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xx.Filelibrary.ui.adapter.viewHolder.xxBaseViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class xxBaseRecycleViewAdapter<T, K extends xxBaseViewHolder> extends RecyclerView.Adapter<K> {

    public Context mContext;
    public List<T> mList;
    private OnItemClickListener mOnItemClickListener;
    protected K holder;

    public int rvCount=-1;

    public xxBaseRecycleViewAdapter(List<T> list, Context context) {
        this.mContext = context;
        this.mList = list;

    }


    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      /*  xxBaseViewHolder viewHolder = null;
        try {
            View itemView = LayoutInflater.from(mContext).inflate(getContentView(viewType), parent, false);
            viewHolder = new xxBaseViewHolder(itemView);
            ButterKnife.bind(viewHolder, itemView);
        } catch (Exception e) {

        }

        return viewHolder;*/
        View itemView = LayoutInflater.from(mContext).inflate(getContentView(viewType), parent, false);
        try {
            Class<K> clazz = getKClass();
            Constructor<K> constructor = clazz.getConstructor(View.class);
            K t = constructor.newInstance(itemView);
            holder = t;
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull K holder, int position) {
        if (this.holder == null) {
            this.holder = holder;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener == null) {
                    return;
                } else {
                    mOnItemClickListener.onItemClick(position, mList.get(position));
                }
            }
        });

        covert(holder, mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        if (rvCount<0)
        {
            return mList.size();
        }else
        {
            return rvCount;
        }

    }


    protected abstract int getContentView(int viewType);

    protected abstract void covert(K holder, T data, int position);

    public void setOnItemClickListener(OnItemClickListener<T> mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public interface OnItemClickListener<T> {
        void onItemClick(int position, T bean);
    }

    protected Class<K> getKClass() {
        Class<K> entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<K>) p[1];
        }
        return entityClass;
    }

    public void setList(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();

    }

    public void addList(List<T> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }


}
