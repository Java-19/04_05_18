package com.sheygam.java_19_04_05_18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment {
    private int color;
    private float scale;

    public static MyFragment newInstance(int color, float scale){
        MyFragment fragment = new MyFragment();
        fragment.color = color;
        fragment.scale = scale;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        if(args != null){
            color = args.getInt("COLOR");
            scale = args.getFloat("SCALE");
        }else{
            scale = 0.5F;
            color = Color.rgb(255,255,255);
        }
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
        view.setBackgroundColor(color);
        view.setScaleY(scale);
        view.setScaleX(scale);
        return view;
    }
}
