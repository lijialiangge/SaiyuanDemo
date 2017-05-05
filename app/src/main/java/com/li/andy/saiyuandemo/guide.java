package com.li.andy.saiyuandemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


public class guide extends Fragment implements ViewPager.OnPageChangeListener{


    private ArrayList<View> views;
    private ViewPager vp;
    private viewpagerAdapter vpAdapter;
    private Context context;
    private ImageView[] dots;
    private int[] rid={R.id.iv11,R.id.iv22,R.id.iv33};
    private Button btn1;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate((R.layout.fragment_guide), container, false);
        LayoutInflater inflater1=LayoutInflater.from(getActivity());
        views=new ArrayList<>();
        views.add(inflater1.inflate(R.layout.fragment_guide__one,null));
        views.add(inflater1.inflate(R.layout.fragment_guide__two,null));
        views.add(inflater1.inflate(R.layout.fragment_guide__three,null));

        vpAdapter=new viewpagerAdapter(views,getActivity());
        vp= (ViewPager) view.findViewById(R.id.viewPager);
        vp.setAdapter(vpAdapter);

        dots=new ImageView[views.size()];
        for(int i=0;i<views.size();i++){

            dots[i]= (ImageView) view.findViewById(rid[i]);

        }

        vp.setOnPageChangeListener(this);

        btn1= (Button) views.get(2).findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Main.class);
                startActivity(intent);



            }
        });
        return view;

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for(int i=0;i<rid.length;i++){
            if(i==position){
                dots[i].setImageResource(R.drawable.login_point_selected);
            }else{
                dots[i].setImageResource(R.drawable.login_point);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
