package com.takwolf.android.refreshandloadmore.demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.takwolf.android.refreshandloadmore.demo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_recycler_view_demo)
    void onBtnRecyclerViewDemoClick() {
        startActivity(new Intent(this, RecyclerViewDemoActivity.class));
    }

    @OnClick(R.id.btn_recycler_view_not_full_demo)
    void onBtnRecyclerViewNotFullDemoClick() {
        startActivity(new Intent(this, RecyclerViewNotFullDemoActivity.class));
    }

    @OnClick(R.id.btn_list_view_demo)
    void onBtnListViewDemoClick() {
        startActivity(new Intent(this, ListViewDemoActivity.class));
    }

    @OnClick(R.id.btn_list_view_not_full_demo)
    void onBtnListViewNotFullDemoClick() {
        startActivity(new Intent(this, ListViewNotFullDemoActivity.class));
    }

    @OnClick(R.id.btn_zhihu_demo)
    void onBtnZhihuDemoClick() {
        startActivity(new Intent(this, ZhihuDemoActivity.class));
    }

    @OnClick(R.id.btn_zhihu_not_full_demo)
    void onBtnZhihuNotFullDemoClick() {
        startActivity(new Intent(this, ZhihuNotFullDemoActivity.class));
    }

}
