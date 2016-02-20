package com.mygdx.game;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void startListener(View view) {
        Intent intent = new Intent(this, AndroidLauncher.class);
        startActivity(intent);
    }
}
