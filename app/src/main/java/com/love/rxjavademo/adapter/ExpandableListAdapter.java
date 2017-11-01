package com.love.rxjavademo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.Group;

import java.util.List;

/**
 * Created by android on 2017/11/1.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;

    private List<Group> mData;

    public ExpandableListAdapter(Context mContext, List<Group> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @Override
    public int getGroupCount() {
        return mData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mData.get(groupPosition).getGroups().size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return mData.get(groupPosition);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return mData.get(groupPosition).getGroups().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Group group = getGroup(groupPosition);
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = View.inflate(mContext, R.layout.item_group_view, null);
            groupViewHolder.groupText = (TextView) convertView.findViewById(R.id.group_text);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.groupText.setText(group.getTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = getChild(groupPosition, childPosition);
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = View.inflate(mContext, R.layout.item_child_view, null);
            childViewHolder.childText = (TextView) convertView.findViewById(R.id.child_text);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.childText.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true; // 如果响应child 的点击事件 必须返回true
    }

    static class GroupViewHolder {
        public TextView groupText;
    }

    static class ChildViewHolder {
        public TextView childText;
    }
}
