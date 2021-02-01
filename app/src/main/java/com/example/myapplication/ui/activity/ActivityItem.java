package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;


public class ActivityItem extends AppCompatActivity {

    public static final String SINGER_NAME = "singer_name";
    public static final String SONG_NAME = "song_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sing_item);

        initData();

    }

    private void initData() {
        String singerName = getIntent().getExtras().getString(SINGER_NAME);
        String songName = getIntent().getExtras().getString(SONG_NAME);
        ((TextView)findViewById(R.id.singerName)).setText(singerName);
        ((TextView)findViewById(R.id.songName)).setText(songName);
    }
}
