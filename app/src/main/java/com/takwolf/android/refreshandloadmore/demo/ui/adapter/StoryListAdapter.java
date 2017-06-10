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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.update(storyList.get(position), position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        @BindView(R.id.icon_padding_top)
        View iconPaddingTop;

        private Story story;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void update(@NonNull Story story, int position) {
            this.story = story;
            tvTitle.setText(story.getTitle());
            Glide.with(activity).load(story.getImageList().get(0)).placeholder(R.drawable.image_placeholder).into(imgThumb);
            iconPaddingTop.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
        }

    }

}
