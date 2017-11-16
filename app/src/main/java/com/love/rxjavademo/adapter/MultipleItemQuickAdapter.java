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


    public boolean isShow = false;

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

                if (isShow) {
                    helper.setGone(R.id.iv_point, true);
                } else {
                    helper.setGone(R.id.iv_point, false);
                }

                break;
            case MultipleItem.IMG:
                helper.setImageResource(R.id.iv_image, R.mipmap.ic_girl);
                helper.addOnClickListener(R.id.iv_image);
                if (isShow) {
                    helper.setGone(R.id.iv_point, true);
                } else {
                    helper.setGone(R.id.iv_point, false);
                }
                break;
        }
    }

    public void setShowPoint(boolean isShow) {
        this.isShow = isShow;
        this.notifyDataSetChanged();
    }

}
