package com.example.androidtest.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidtest.bean.DemoBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoAdapter extends ArrayAdapter<DemoBean> {

    private List<DemoBean> mDemoBeans;
    private Context mContext;

    public DemoAdapter(@NonNull Context context, int resource, @NonNull List<DemoBean> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mDemoBeans = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder();
            holder.tvDemoDesc = convertView.findViewById(android.R.id.text1);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvDemoDesc.setText(mDemoBeans.get(position).desc);
        return convertView;
    }
}

class ViewHolder {
    TextView tvDemoDesc;
}
