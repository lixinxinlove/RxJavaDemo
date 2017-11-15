package com.love.rxjavademo.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.MultipleItem;

import java.util.List;

/**
 * Created by android on 2017/11/15.
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.text_view);
        addItemType(MultipleItem.IMG, R.layout.image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv_text, item.getText());
                helper.addOnClickListener(R.id.tv_text);
                break;
            case MultipleItem.IMG:
                helper.setImageResource(R.id.iv_image, R.mipmap.ic_girl);
                helper.addOnClickListener(R.id.iv_image);
                break;
        }

    }
}
