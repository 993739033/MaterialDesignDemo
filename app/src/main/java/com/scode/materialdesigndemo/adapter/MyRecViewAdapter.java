package com.scode.materialdesigndemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scode.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/24.
 */

public class MyRecViewAdapter extends RecyclerView.Adapter<MyRecViewHolder> {
    public List<String> lists=new ArrayList<>();
    public interface onItemClickListener{
        void onItemClick();
        void onItemLongClick();
    }

    public onItemClickListener monItemClickListener;

    public void setOnItemClickListener(onItemClickListener monItemClickListener) {
        this.monItemClickListener=monItemClickListener;
    }


    public MyRecViewAdapter() {
        for (int i='A';i<='z';i++) {
            lists.add((char)(i) + "");
        }
    }


    @Override

    public MyRecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_item, parent, false);
        return new MyRecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecViewHolder holder, int position) {
        String s = lists.get(position);
        holder.textView.setText(s);
        if (monItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monItemClickListener.onItemClick();
                }
            });
             holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                 @Override
                 public boolean onLongClick(View v) {
                     monItemClickListener.onItemLongClick();
                     return true;
                 }
             });
        }

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
