package com.li.andy.saiyuandemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class viewpagerAdapter extends PagerAdapter {


    private ArrayList<View> views;
    private Context context;




    public  viewpagerAdapter(ArrayList<View> views,Context context){
        this.views=views;
        this.context=context;
    }

    public int getCount() {
        return views.size();
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}
