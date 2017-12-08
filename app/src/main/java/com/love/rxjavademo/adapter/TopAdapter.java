package com.love.rxjavademo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.love.rxjavademo.R;

/**
 * Created by android on 2017/12/8.
 */

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_TITLE = 1;
    private Context mContext;

    public TopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_top_view, null);
        View itemView1 = View.inflate(mContext, R.layout.item_top_view1, null);
        if (viewType == TYPE_ITEM) {
            return new ViewHolder(itemView);
        }
        return new ViewHolder(itemView1);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 1) {
            return TYPE_TITLE;
        }
        return TYPE_ITEM;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
//        if (manager instanceof GridLayoutManager) {
//            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
//            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//
//                    if (getItemViewType(position) == TYPE_HEADER) {
//                        return gridManager.getSpanCount();
//                    }
//                    if (getItemViewType(position) == TYPE_TITLE) {
//                        return gridManager.getSpanCount();
//                    }
//                    return 1;
//                }
//            });
//        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
