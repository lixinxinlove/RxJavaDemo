package com.love.rxjavademo.adapter;

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
    }
}
