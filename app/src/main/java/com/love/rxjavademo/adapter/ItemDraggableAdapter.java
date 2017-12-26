package com.love.rxjavademo.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.love.rxjavademo.R;

import java.util.List;

/**
 * Created by android on 2017/9/22.
 */

public class ItemDraggableAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {

    public ItemDraggableAdapter(List<String> data) {
        super(R.layout.item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
        if (item.equals("lee5")) {
            helper.getView(R.id.fl_layout).setVisibility(View.VISIBLE);
            helper.getView(R.id.rl_layout).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.fl_layout).setVisibility(View.GONE);
            helper.getView(R.id.rl_layout).setVisibility(View.VISIBLE);
        }
        helper.addOnClickListener(R.id.tv);
    }
}
