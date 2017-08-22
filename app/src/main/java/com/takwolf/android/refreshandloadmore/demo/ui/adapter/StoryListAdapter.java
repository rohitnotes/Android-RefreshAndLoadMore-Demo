package com.takwolf.android.refreshandloadmore.demo.ui.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.Story;
import com.takwolf.android.refreshandloadmore.demo.ui.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.ViewHolder> {

    private final Activity activity;
    private final LayoutInflater inflater;
    private final List<Story> storyList = new ArrayList<>();

    public StoryListAdapter(@NonNull Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    public List<Story> getStoryList() {
        return storyList;
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_story, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.update(storyList.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        private Story story;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void update(@NonNull Story story) {
            this.story = story;
            tvTitle.setText(story.getTitle());
            Glide.with(activity).load(story.getImageList().get(0)).placeholder(R.drawable.image_placeholder).into(imgThumb);
        }

        @OnClick(R.id.btn_item)
        void onBtnItemClick() {
            ToastUtils.with(activity).show(story.getTitle());
        }

    }

}
