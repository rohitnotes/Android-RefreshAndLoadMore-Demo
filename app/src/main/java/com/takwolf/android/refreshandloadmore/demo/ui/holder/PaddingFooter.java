package com.takwolf.android.refreshandloadmore.demo.ui.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;

import androidx.annotation.NonNull;

public class PaddingFooter {

    public PaddingFooter(@NonNull Context context, @NonNull HeaderAndFooterRecyclerView recyclerView) {
        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_padding, recyclerView.getFooterContainer(), false);
        recyclerView.addFooterView(footerView);
    }

}
