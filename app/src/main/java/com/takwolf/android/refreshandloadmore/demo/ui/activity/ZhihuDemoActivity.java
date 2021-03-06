package com.takwolf.android.refreshandloadmore.demo.ui.activity;

import android.os.Bundle;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.CallbackWrapper;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.StoryPage;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.ZhihuClient;
import com.takwolf.android.refreshandloadmore.demo.ui.adapter.StoryListAdapter;
import com.takwolf.android.refreshandloadmore.demo.ui.holder.LoadMoreFooter;
import com.takwolf.android.refreshandloadmore.demo.ui.holder.PaddingFooter;
import com.takwolf.android.refreshandloadmore.demo.ui.holder.PaddingHeader;
import com.takwolf.android.refreshandloadmore.demo.ui.listener.NavigationFinishClickListener;
import com.takwolf.android.refreshandloadmore.demo.ui.util.ToastUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhihuDemoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, LoadMoreFooter.OnLoadMoreListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    HeaderAndFooterRecyclerView recyclerView;

    private LoadMoreFooter loadMoreFooter;
    private StoryListAdapter adapter;

    private String date = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        toolbar.setTitle("知乎日报");
        toolbar.setNavigationOnClickListener(new NavigationFinishClickListener(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMoreFooter = new LoadMoreFooter(this, recyclerView, this);
        new PaddingHeader(this, recyclerView);
        new PaddingFooter(this, recyclerView);

        adapter = new StoryListAdapter(this);
        recyclerView.setAdapter(adapter);

        refreshLayout.setColorSchemeResources(R.color.color_accent);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setRefreshing(true);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        ZhihuClient.service.getLatestStoryList().enqueue(new CallbackWrapper<StoryPage>() {

            @Override
            public void onDataOk(StoryPage data) {
                date = data.getDate();
                adapter.getStoryList().clear();
                adapter.getStoryList().addAll(data.getStoryList());
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
                loadMoreFooter.setState(LoadMoreFooter.STATE_ENDLESS);
            }

            @Override
            public void onKindsOfError(@NonNull String message) {
                ToastUtils.with(ZhihuDemoActivity.this).show(message);
                refreshLayout.setRefreshing(false);
            }

        });
    }

    @Override
    public void onLoadMore() {
        ZhihuClient.service.getStoryListBefore(date).enqueue(new CallbackWrapper<StoryPage>() {

            @Override
            public void onDataOk(StoryPage data) {
                date = data.getDate();
                int startPosition = adapter.getItemCount();
                adapter.getStoryList().addAll(data.getStoryList());
                adapter.notifyItemRangeInserted(startPosition, data.getStoryList().size());
                loadMoreFooter.setState(LoadMoreFooter.STATE_ENDLESS);
            }

            @Override
            public void onKindsOfError(@NonNull String message) {
                ToastUtils.with(ZhihuDemoActivity.this).show(message);
                loadMoreFooter.setState(LoadMoreFooter.STATE_FAILED);
            }

        });
    }

}
