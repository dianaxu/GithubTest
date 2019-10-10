package com.example.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidtest.adapter.DemoAdapter;
import com.example.androidtest.bean.DemoBean;
import com.example.androidtest.presenter.MainPresenter;
import com.example.androidtest.view.IMainView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, IMainView {

    private ListView mLvDemo;
    private List<DemoBean> mData;
    private DemoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        MainPresenter presenter = new MainPresenter(this, this);
        presenter.getDemoData();
    }

    private void initView() {
        mData = new ArrayList<>();
        mLvDemo = findViewById(R.id.lv_demo);
        mAdapter = new DemoAdapter(this, android.R.layout.simple_list_item_1, mData);
        mLvDemo.setAdapter(mAdapter);
        mLvDemo.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String className = getPackageName() + mData.get(position).activityPath;
        try {
            Class<?> activityClass = Class.forName(className);
            startActivity(new Intent(this, activityClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUI(List<DemoBean> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
    }
}
