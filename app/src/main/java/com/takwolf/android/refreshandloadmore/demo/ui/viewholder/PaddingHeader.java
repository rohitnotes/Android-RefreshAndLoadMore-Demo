package com.takwolf.android.refreshandloadmore.demo.ui.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;

public class PaddingHeader {

    public PaddingHeader(@NonNull Context context, @NonNull HeaderAndFooterRecyclerView recyclerView) {
        View headerView = LayoutInflater.from(context).inflate(R.layout.header_padding, recyclerView.getHeaderContainer(), false);
        recyclerView.addHeaderView(headerView);
    }

}
