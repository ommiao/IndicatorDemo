package cn.ommiao.indicatordemo;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.ommiao.indicatordemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();
        View red = inflater.inflate(R.layout.layout_red, null);
        View green = inflater.inflate(R.layout.layout_green, null);
        View blue = inflater.inflate(R.layout.layout_blue, null);
        View purple = inflater.inflate(R.layout.layout_purple, null);
        final ArrayList<View> views = new ArrayList<>();
        views.add(red);
        views.add(green);
        views.add(blue);
        views.add(purple);
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(views.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }
        };
        mBinding.viewpager.setAdapter(adapter);
        mBinding.indicator.setViewPager(mBinding.viewpager);
    }
}
