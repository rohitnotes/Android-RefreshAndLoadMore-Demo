package com.takwolf.android.refreshandloadmore.demo.ui.activity;

import android.os.Bundle;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.illust.IllustClient;
import com.takwolf.android.refreshandloadmore.demo.ui.adapter.IllustListAdapter;
import com.takwolf.android.refreshandloadmore.demo.ui.holder.LoadMoreFooter;
import com.takwolf.android.refreshandloadmore.demo.ui.listener.NavigationFinishClickListener;
import com.takwolf.android.refreshandloadmore.demo.util.HandlerUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewDemoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, LoadMoreFooter.OnLoadMoreListener {

    private static final int PAGE_SIZE = 20;
    private static final int TOTAL_COUNT = 200;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    HeaderAndFooterRecyclerView recyclerView;

    private LoadMoreFooter loadMoreFooter;
    private IllustListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        toolbar.setTitle("RecyclerView 实现");
        toolbar.setNavigationOnClickListener(new NavigationFinishClickListener(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMoreFooter = new LoadMoreFooter(this, recyclerView, this);

        adapter = new IllustListAdapter(this);
        recyclerView.setAdapter(adapter);

        refreshLayout.setColorSchemeResources(R.color.color_accent);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setRefreshing(true);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        HandlerUtils.handler.postDelayed(() -> {
            adapter.getIllustList().clear();
            adapter.getIllustList().addAll(IllustClient.buildIllustList(PAGE_SIZE));
            adapter.notifyDataSetChanged();
            refreshLayout.setRefreshing(false);
            loadMoreFooter.setState(LoadMoreFooter.STATE_ENDLESS);
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        HandlerUtils.handler.postDelayed(() -> {
            int startPosition = adapter.getItemCount();
            adapter.getIllustList().addAll(IllustClient.buildIllustList(PAGE_SIZE));
            adapter.notifyItemRangeInserted(startPosition, PAGE_SIZE);
            loadMoreFooter.setState(adapter.getItemCount() >= TOTAL_COUNT ? LoadMoreFooter.STATE_FINISHED : LoadMoreFooter.STATE_ENDLESS);
        }, 1000);
    }

}
