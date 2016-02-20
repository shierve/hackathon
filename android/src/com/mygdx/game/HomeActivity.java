package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        TextView customTitle = getActionBarTextView();
        customTitle.setTextSize(dpToPx(18));
        customTitle.setTypeface(EasyFonts.cac_champagne(this));
        TextView startButton = (TextView) findViewById(R.id.start);
        startButton.setTypeface(EasyFonts.robotoThin(this));
        TextView rankingTitle = (TextView) findViewById(R.id.ranking_title);
        rankingTitle.setTypeface(EasyFonts.droidSerifItalic(this));

        mRecyclerView = (RecyclerView) findViewById(R.id.hall_list);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.setAdapter(new HallAdapter(getHallOfDough()));
    }

    public ArrayList<HallRow> getHallOfDough() {
        ArrayList<HallRow> res = new ArrayList<>();
        res.add(new HallRow("Alfa",1));
        res.add(new HallRow("Bravo",2));
        res.add(new HallRow("Charlie",3));
        res.add(new HallRow("Delta",4));
        res.add(new HallRow("Tango",5));
        res.add(new HallRow("FoxTrot",6));
        return res;
    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            Field f = toolbar.getClass().getDeclaredField("mTitleTextView");
            f.setAccessible(true);
            titleTextView = (TextView) f.get(toolbar);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
        return titleTextView;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @OnClick(R.id.start)
    public void startListener(View view) {
        Intent intent = new Intent(this, AndroidLauncher.class);
        startActivity(intent);
    }
}
