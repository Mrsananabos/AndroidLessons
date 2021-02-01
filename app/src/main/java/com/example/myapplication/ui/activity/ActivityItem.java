package com.example.myapplication.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;


public class ActivityItem extends AppCompatActivity {

    public static final String EXTRA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sing_item);

        initData();

    }

    private void initData() {
        String name = getIntent().getExtras().getString(EXTRA_ID);
//        ((TextView)findViewById(R.id.tvName)).setText(name);
    }
}
