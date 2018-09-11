package com.example.sunnysingh.rotatebuttonsunny;

import android.view.animation.Animation;
import android.widget.Button;

public class DisplayNextView implements Animation.AnimationListener {

    private boolean mCurrentView;
    private Button butn1, butn2;

    public DisplayNextView(boolean currentView, Button butn1, Button butn2) {
        mCurrentView = currentView;
        this.butn1 = butn1;
        this.butn2 = butn2;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        butn1.post(new SwapViews(mCurrentView, butn1, butn2));
    }

    public void onAnimationRepeat(Animation animation) {
    }






}
