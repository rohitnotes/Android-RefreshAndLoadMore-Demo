package com.takwolf.android.refreshandloadmore.demo.ui.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;

import androidx.annotation.NonNull;

public class PaddingHeader {

    public PaddingHeader(@NonNull Context context, @NonNull HeaderAndFooterRecyclerView recyclerView) {
        View headerView = LayoutInflater.from(context).inflate(R.layout.header_padding, recyclerView.getHeaderContainer(), false);
        recyclerView.addHeaderView(headerView);
    }

}
