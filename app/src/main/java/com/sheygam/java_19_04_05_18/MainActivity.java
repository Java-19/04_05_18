package com.sheygam.java_19_04_05_18;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float scale = 1.0F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add_view_btn)
                .setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MY_TAG", "onResume: ");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_view_btn){
//            FrameLayout frameLayout = findViewById(R.id.fragment_container);
//            MyView myView = new MyView(this);
//            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(300,300);
//            myView.setLayoutParams(params);
//            frameLayout.addView(myView);

            Random random = new Random();
            int color = Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(R.id.fragment_container,MyFragment.newInstance(color,scale))
//                    .commit();
            MyFragment fragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("COLOR",color);
            args.putFloat("SCALE",scale);
            fragment.setArguments(args);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            scale -= 0.1;
        }
    }
}
