package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.love.rxjavademo.adapter.ExpandableListAdapter;
import com.love.rxjavademo.bean.Group;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    private ExpandableListView expandableListView;

    private ExpandableListAdapter adapter;

    private List<Group> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        expandableListView = (ExpandableListView) findViewById(R.id.elv);

        initData();

        adapter = new ExpandableListAdapter(this, mData);
        expandableListView.setAdapter(adapter);
        int groupCount = expandableListView.getCount();

        for (int i = 0; i < groupCount; i++) {
            expandableListView.expandGroup(i);
        }

        expandableListView.setOnGroupClickListener(this);

        expandableListView.setOnChildClickListener(this);

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.setTitle("第" + i + "组");
            List<String> groups = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                groups.add("china" + j);
            }
            group.setGroups(groups);
            mData.add(group);
        }
    }


    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        Toast.makeText(this, "第" + groupPosition + "组", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Toast.makeText(this, "第" + groupPosition + "组第" + childPosition + "个", Toast.LENGTH_SHORT).show();
        return true;
    }
}
