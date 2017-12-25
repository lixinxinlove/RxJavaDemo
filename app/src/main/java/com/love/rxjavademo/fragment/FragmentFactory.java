package com.love.rxjavademo.fragment;

import android.support.v4.app.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by android on 2017/12/19.
 */

public class FragmentFactory {

    private static Map<String, Fragment> cacheMap = new LinkedHashMap();

    private static Fragment mFragment;

    public static Fragment getFragmentByTag(String tag) {
        if (cacheMap.get(tag) != null) {
            return cacheMap.get(tag);
        } else {
            return createFragmentForTag(tag);
        }
    }

    private static Fragment createFragmentForTag(String tag) {
        if (HomeFragment.NAME.equals(tag)) {
            mFragment = new HomeFragment();
        } else if (MineFragment.NAME.equals(tag)) {
            mFragment = new MineFragment();
        } else {

        }
        cacheMap.put(tag, mFragment);
        return mFragment;
    }
}
