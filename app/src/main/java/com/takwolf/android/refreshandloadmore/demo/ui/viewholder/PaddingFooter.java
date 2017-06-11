package com.takwolf.android.refreshandloadmore.demo.ui.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.refreshandloadmore.demo.R;

public class PaddingFooter {

    public PaddingFooter(@NonNull Context context, @NonNull HeaderAndFooterRecyclerView recyclerView) {
        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_padding, recyclerView.getFooterContainer(), false);
        recyclerView.addFooterView(footerView);
    }

}
