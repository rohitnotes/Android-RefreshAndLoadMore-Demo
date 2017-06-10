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

    @OnClick(R.id.btn_normal_demo)
    void onBtnNormalDemoClick() {
        startActivity(new Intent(this, NormalDemoActivity.class));
    }

    @OnClick(R.id.btn_step_one_demo)
    void onBtnStepOneDemoClick() {
        startActivity(new Intent(this, StepOneDemoActivity.class));
    }

    @OnClick(R.id.btn_zhihu_demo)
    void onBtnZhihuDemoClick() {
        startActivity(new Intent(this, ZhihuDemoActivity.class));
    }

    @OnClick(R.id.btn_zhihu_not_full_demo)
    void onBtnZhihuNotFullDemoClick() {
        startActivity(new Intent(this, ZhihuNotFullDemoActivity.class));
    }

    @OnClick(R.id.btn_abs_list_demo)
    void onBtnAbsListDemoClick() {
        startActivity(new Intent(this, AbsListDemoActivity.class));
    }

    @OnClick(R.id.btn_abs_list_not_full_demo)
    void onBtnAbsListNotFullDemoClick() {
        startActivity(new Intent(this, AbsListNotFullDemoActivity.class));
    }

}
