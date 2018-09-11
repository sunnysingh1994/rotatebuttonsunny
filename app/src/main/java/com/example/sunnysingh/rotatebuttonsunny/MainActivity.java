package com.example.sunnysingh.rotatebuttonsunny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button butn1, butn2;

    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butn1 = (Button) findViewById(R.id.btn1);
        butn2 = (Button) findViewById(R.id.btn2);

        butn2.setVisibility(View.GONE);
        butn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage) {
                    applyRotation(0, 90);
                    isFirstImage = !isFirstImage;

                } else {
                    applyRotation(0, -90);
                    isFirstImage = !isFirstImage;
                }
            }
        });

    }

    private void applyRotation(float start, float end) {
// Find the center of image
        final float centerX = butn1.getWidth() / 2.0f;
        final float centerY = butn2.getHeight() / 2.0f;

// Create a new 3D rotation with the supplied parameter
// The animation listener is used to trigger the next animation
        final Flip3dAnimation rotation =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage, butn1, butn2));

        if (isFirstImage) {
            butn1.startAnimation(rotation);
        } else {
            butn1.startAnimation(rotation);
        }


    }
}
