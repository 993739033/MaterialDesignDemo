package com.scode.materialdesigndemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.scode.materialdesigndemo.R;

/**
 * Created by 知らないのセカイ on 2017/5/24.
 */

public class MyRecViewHolder extends RecyclerView.ViewHolder {
   public TextView textView;

    public MyRecViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.recy_item_textview);

    }
}
