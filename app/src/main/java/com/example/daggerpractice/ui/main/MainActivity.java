package com.example.daggerpractice.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.daggerpractice.BaseActivity;
import com.example.daggerpractice.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: inside onCreate of the MainActivity...");
        
        Toast.makeText(this, "This is Main Activity", Toast.LENGTH_SHORT).show();
    }
}
