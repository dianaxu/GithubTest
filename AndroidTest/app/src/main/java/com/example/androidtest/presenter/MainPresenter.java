package com.example.androidtest.presenter;


import android.content.Context;

import com.example.androidtest.bean.DemoBean;
import com.example.androidtest.view.IMainView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainPresenter {


    private List<DemoBean> mData;
    private IMainView mIMainView;
    private Context mContext;

    public MainPresenter(Context context, IMainView iMainView) {
        this.mContext = context;
        this.mIMainView = iMainView;

    }


    public void getDemoData() {
        String demos = getFromAssets("demo.json");

        Gson gson = new Gson();
        mData = gson.fromJson(demos, new TypeToken<List<DemoBean>>() {
        }.getType());

        if (mData != null) {
            mIMainView.updateUI(mData);
        }
    }

    /**
     * 获取本地的数据
     *
     * @param fileName
     * @return
     */
    private String getFromAssets(String fileName) {

        InputStreamReader inputReader = null;
        try {
            inputReader = new InputStreamReader(mContext.getResources().getAssets().open(fileName));
            BufferedReader reader = new BufferedReader(inputReader);
            String line = "";
            String result = "";
            while ((line = reader.readLine()) != null)
                result += line;
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
