package com.example.lifecycledemo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MyTextView extends AppCompatTextView implements LifecycleObserver {
    private StringBuffer sb = new StringBuffer();
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        sb.append("onCreate");
        this.setText(sb.toString());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        sb.append("-onResume");
        this.setText(sb.toString());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        sb.append("-onStart");
        this.setText(sb.toString());
    }
}
