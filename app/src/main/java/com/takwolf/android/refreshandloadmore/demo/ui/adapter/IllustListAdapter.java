package com.takwolf.android.refreshandloadmore.demo.ui.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class IllustListAdapter extends RecyclerView.Adapter<IllustListAdapter.ViewHolder> {

    private final Activity activity;
    private final LayoutInflater inflater;
    private final List<Illust> illustList = new ArrayList<>();

    public IllustListAdapter(@NonNull Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    public List<Illust> getIllustList() {
        return illustList;
    }

    @Override
    public int getItemCount() {
        return illustList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_illust, parent, false), activity);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(illustList.get(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        private final Activity activity;

        private Illust illust;

        ViewHolder(@NonNull View itemView, @NonNull Activity activity) {
            super(itemView);
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
