package com.takwolf.android.refreshandloadmore.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.CallbackWrapper;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.StoryPage;
import com.takwolf.android.refreshandloadmore.demo.model.zhihu.ZhihuClient;
import com.takwolf.android.refreshandloadmore.demo.ui.adapter.StoryListAdapter;
import com.takwolf.android.refreshandloadmore.demo.ui.listener.NavigationFinishClickListener;
import com.takwolf.android.refreshandloadmore.demo.ui.util.ToastUtils;
import com.takwolf.android.refreshandloadmore.demo.ui.viewholder.LoadMoreFooter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_and_load_more);
        ButterKnife.bind(this);

        toolbar.setTitle("知乎日报");
        toolbar.setNavigationOnClickListener(new NavigationFinishClickListener(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMoreFooter = new LoadMoreFooter(this, recyclerView, this);

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
                ToastUtils.with(ZhihuDemoActivity.this).show(data.getDate());
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
                ToastUtils.with(ZhihuDemoActivity.this).show(data.getDate());
                date = data.getDate();
                adapter.getStoryList().addAll(data.getStoryList());
                adapter.notifyDataSetChanged();
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
