package com.scode.materialdesigndemo.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.scode.materialdesigndemo.R;
import com.scode.materialdesigndemo.myutils.MySnackBar;

/**
 * Created by 知らないのセカイ on 2017/5/24.
 */

public class MyFragment extends Fragment implements MyRecViewAdapter.onItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    View view;
    MyRecViewAdapter myRecViewAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.scroll_item,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.scroll_rv);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.scroll_sw);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorstart,R.color.colorend);
        myRecViewAdapter=new MyRecViewAdapter();
        int flag = (int) getArguments().get("flag");
        switch (flag) {
            case 0:
                manager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false);
                break;
            case 1:
                manager = new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false);
                break;
            case 2:
                manager = new GridLayoutManager(getActivity(), 2, GridLayout.VERTICAL, false);
                break;
            case 3:
                manager = new GridLayoutManager(getActivity(), 2, GridLayout.HORIZONTAL, false);
                break;
        }
        myRecViewAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myRecViewAdapter);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick() {
        MySnackBar.show(view,"be clicked");
    }

    @Override
    public void onItemLongClick() {
        MySnackBar.show(view,"be long clicked");

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                int item= (int) (Math.random()*10);
                myRecViewAdapter.lists.add(0,"new:" + item);
                myRecViewAdapter.notifyDataSetChanged();

            }
        }, 2000);
    }
}
