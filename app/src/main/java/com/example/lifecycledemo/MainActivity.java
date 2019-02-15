package com.example.lifecycledemo;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    TextView contentTv;
    Button updateBtn;
    LifeViewModel mViewModel;
    MyTextView lifeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateBtn = findViewById(R.id.update);
        contentTv = findViewById(R.id.content);
        mViewModel = ViewModelProviders.of(this).get(LifeViewModel.class);
        mViewModel.getmName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                contentTv.setText(mViewModel.getmName().getValue());
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getmName().setValue(new Random().nextLong()+"");
            }
        });
        lifeTv = findViewById(R.id.text);
        getLifecycle().addObserver(lifeTv);
    }
}
