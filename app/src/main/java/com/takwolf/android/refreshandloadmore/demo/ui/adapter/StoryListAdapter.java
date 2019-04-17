package com.takwolf.android.refreshandloadmore.demo.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.GlideApp;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.Story;
import com.takwolf.android.refreshandloadmore.demo.ui.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_story, parent, false), activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(storyList.get(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        private final Activity activity;

        private Story story;

        ViewHolder(@NonNull View itemView, @NonNull Activity activity) {
            super(itemView);
            this.activity = activity;
            ButterKnife.bind(this, itemView);
        }

        void bind(@NonNull Story story) {
            this.story = story;
            tvTitle.setText(story.getTitle());
            GlideApp.with(activity).load(story.getImageList().get(0)).placeholder(R.drawable.image_placeholder).into(imgThumb);
        }

        @OnClick(R.id.btn_item)
        void onBtnItemClick() {
            ToastUtils.with(activity).show(story.getTitle());
        }

    }

}
