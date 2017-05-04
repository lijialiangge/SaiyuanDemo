package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.li.andy.saiyuandemo.R;

import java.util.ArrayList;
import java.util.List;


public class guide extends Fragment {


    private ArrayList<View> views;
    private ViewPager vp;
    private viewpagerAdapter vpAdapter;
    private Context context;

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


        return view;

    }


}
