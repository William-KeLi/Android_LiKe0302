package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_like0302.R;

public class gestureCase extends AppCompatActivity implements View.OnTouchListener {
    private TextView textView7;
    private GestureDetector g1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_case);
        g1=new GestureDetector(this,new MyGestureListener());
        init();
    }

    private void init(){
        textView7=(TextView) findViewById(R.id.textView7);
        textView7.setOnTouchListener(this);
        textView7.setClickable(true);
        textView7.setFocusable(true);
        textView7.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return g1.onTouchEvent(motionEvent);
    }
    class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Toast.makeText(gestureCase.this, "onDown", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Toast.makeText(gestureCase.this, "showpress", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Toast.makeText(gestureCase.this, "singleTapup", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i("MyGesture", "onScroll: ");
            Toast.makeText(gestureCase.this, "scroll", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Toast.makeText(gestureCase.this, "LONGPRESS", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Toast.makeText(gestureCase.this, "onFling", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}