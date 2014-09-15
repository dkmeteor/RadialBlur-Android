package com.dk.image.process;

import com.dk.image.process.blur.MotionBlur;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
    private ImageView mImage;
    private Bitmap mSrc;
    private SeekBar mDx, mDy;
    private RadioButton mTranslateBlur, mCenterBlur, mOrigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = (ImageView) findViewById(R.id.imageview);
        mSrc = BitmapFactory.decodeResource(getResources(), R.drawable.charming);
        mImage.setImageBitmap(mSrc);

        mDx = (SeekBar) findViewById(R.id.dx);
        mDy = (SeekBar) findViewById(R.id.dy);

        mDx.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
        mDy.setOnSeekBarChangeListener(mOnSeekBarChangeListener);

        mTranslateBlur = (RadioButton) findViewById(R.id.translate);
        mCenterBlur = (RadioButton) findViewById(R.id.center);
        mOrigin = (RadioButton) findViewById(R.id.origin);

        mOrigin.setChecked(true);
        mTranslateBlur.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCenterBlur.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mOrigin.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (mTranslateBlur.isChecked()) {
                mDx.setMax(5);
                mDy.setMax(5);
            } else {
                mDx.setMax(800);
                mDy.setMax(800);
            }
        }
    };

    private OnSeekBarChangeListener mOnSeekBarChangeListener = new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (mTranslateBlur.isChecked())
                mImage.setImageBitmap(MotionBlur.doMotionBlur(mSrc, mDx.getProgress(), mDy.getProgress()));
            else if (mCenterBlur.isChecked())
                mImage.setImageBitmap(MotionBlur.doMotionBlur(mSrc, mDx.getProgress(), mDy.getProgress(), 0.02f));
            else
                mImage.setImageBitmap(mSrc);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
