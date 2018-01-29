package com.takwolf.android.refreshandloadmore.demo.ui.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.GlideApp;
import com.takwolf.android.refreshandloadmore.demo.model.illust.Illust;
import com.takwolf.android.refreshandloadmore.demo.ui.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IllustListAdapter2 extends BaseAdapter {

    private final Activity activity;
    private final LayoutInflater inflater;
    private final List<Illust> illustList = new ArrayList<>();

    public IllustListAdapter2(@NonNull Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    public List<Illust> getIllustList() {
        return illustList;
    }

    @Override
    public int getCount() {
        return illustList.size();
    }

    @Override
    public Object getItem(int position) {
        return illustList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_illust, parent, false);
            holder = new ViewHolder(convertView, activity);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bind(illustList.get(position));
        return convertView;
    }

    static class ViewHolder {

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        private final Activity activity;

        private Illust illust;

        ViewHolder(@NonNull View itemView, @NonNull Activity activity) {
            this.activity = activity;
            ButterKnife.bind(this, itemView);
        }

        void bind(@NonNull Illust illust) {
            this.illust = illust;
            GlideApp.with(activity).load(illust.getImage()).placeholder(R.drawable.image_placeholder).into(imgThumb);
        }

        @OnClick(R.id.btn_item)
        void onBtnItemClick() {
            ToastUtils.with(activity).show(illust.getImage());
        }

    }

}
