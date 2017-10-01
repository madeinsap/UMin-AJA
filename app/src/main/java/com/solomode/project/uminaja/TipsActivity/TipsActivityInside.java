package com.solomode.project.uminaja.TipsActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 10/1/2017.
 */

public class TipsActivityInside extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;

    private int[] layouts = new int[]{
            R.layout.layout_tips1, R.layout.layout_tips2, R.layout.layout_tips3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            if (window != null) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
        setContentView(R.layout.activity_tips);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        setBtnClickListener(R.id.btn_got_it);
        setBtnClickListener(R.id.btn_next);
        setBtnClickListener(R.id.btn_prev);

        viewPager.setAdapter(new TipsActivityInside.MyViewPagerAdapter());
        viewPager.addOnPageChangeListener(pageChangeListener);
    }

    private void setBtnClickListener(int id) {
        Button button = (Button) findViewById(id);
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    private void showHideView(int id, int visibility) {
        View view = findViewById(id);
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    private void launchHomeScreen() {
        Globals.saveFirstTimeLaunch(false);
        super.onBackPressed();
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        int prevPos = 0;

        @Override
        public void onPageSelected(int position) {
            boolean isLastPage = (position == (layouts.length - 1));
            boolean isFirstPage = (position == 0);
            showHideView(R.id.btn_prev, isFirstPage ? View.GONE : View.VISIBLE);
            showHideView(R.id.btn_next, isLastPage ? View.GONE : View.VISIBLE);
            showHideView(R.id.btn_got_it, isLastPage ? View.VISIBLE : View.GONE);

            prevPos = position;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_got_it:
                launchHomeScreen();
                break;
            case R.id.btn_next:
                showNextSlide();
                break;
            case R.id.btn_prev:
                showPrevSlide();
                break;
        }
    }

    private void showNextSlide() {
        int nextIndex = viewPager.getCurrentItem() + 1;
        if ((viewPager != null) && (nextIndex < layouts.length)) {
            viewPager.setCurrentItem(nextIndex);
        }
    }

    private void showPrevSlide() {
        int prevIndex = viewPager.getCurrentItem() - 1;
        if ((viewPager != null) && (prevIndex >= 0)) {
            viewPager.setCurrentItem(prevIndex);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return (layouts != null) ? layouts.length : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return (view == obj);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    @Override
    public void onBackPressed(){
        Globals.saveFirstTimeLaunch(false);
        super.onBackPressed();
    }
}
