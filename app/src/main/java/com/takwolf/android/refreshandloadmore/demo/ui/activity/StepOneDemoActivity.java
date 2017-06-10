package com.takwolf.android.refreshandloadmore.demo.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;
import com.takwolf.android.refreshandloadmore.demo.model.illust.IllustClient;
import com.takwolf.android.refreshandloadmore.demo.ui.adapter.IllustListAdapter;
import com.takwolf.android.refreshandloadmore.demo.ui.listener.NavigationFinishClickListener;
import com.takwolf.android.refreshandloadmore.demo.ui.viewholder.LoadMoreFooter;
import com.takwolf.android.refreshandloadmore.demo.util.HandlerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepOneDemoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, LoadMoreFooter.OnLoadMoreListener {

    private static final int PAGE_SIZE = 1;
    private static final int TOTAL_COUNT = 8;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    HeaderAndFooterRecyclerView recyclerView;

    private LoadMoreFooter loadMoreFooter;
    private IllustListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_and_load_more);
        ButterKnife.bind(this);

        toolbar.setTitle("步长不足一屏");
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
        HandlerUtils.handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                adapter.getIllustList().clear();
                adapter.getIllustList().addAll(IllustClient.buildIllustList(PAGE_SIZE));
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
                loadMoreFooter.setState(LoadMoreFooter.STATE_ENDLESS);
            }

        }, 1000);
    }

    @Override
    public void onLoadMore() {
        HandlerUtils.handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                int startPosition = adapter.getItemCount();
                adapter.getIllustList().addAll(IllustClient.buildIllustList(PAGE_SIZE));
                adapter.notifyItemRangeInserted(startPosition, PAGE_SIZE);
                loadMoreFooter.setState(adapter.getItemCount() >= TOTAL_COUNT ? LoadMoreFooter.STATE_FINISHED : LoadMoreFooter.STATE_ENDLESS);
            }

        }, 1000);
    }

}
