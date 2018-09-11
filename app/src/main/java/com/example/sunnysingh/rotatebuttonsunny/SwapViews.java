package com.example.sunnysingh.rotatebuttonsunny;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class SwapViews implements Runnable {

    private boolean mIsFirstView;

    private Button butn1, butn2;

    public SwapViews(boolean isFirstView, Button butn1, Button butn2) {
        mIsFirstView = isFirstView;
        this.butn1 = butn1;
        this.butn2 = butn2;

    }
    public void run() {
        final float centerX = butn1.getWidth() / 2.0f;
        final float centerY = butn1.getHeight() / 2.0f;
        Flip3dAnimation rotation;

        if (mIsFirstView) {
            butn1.setVisibility(View.GONE);
            butn2.setVisibility(View.VISIBLE);
            butn2.requestFocus();

            rotation = new Flip3dAnimation(-90, 0, centerX, centerY);
        } else {
            butn2.setVisibility(View.GONE);
            butn1.setVisibility(View.VISIBLE);
            butn1.requestFocus();

            rotation = new Flip3dAnimation(90, 0, centerX, centerY);
        }

        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new DecelerateInterpolator());

        if (mIsFirstView) {
            butn2.startAnimation(rotation);
        } else {
            butn1.startAnimation(rotation);
        }
    }



}
