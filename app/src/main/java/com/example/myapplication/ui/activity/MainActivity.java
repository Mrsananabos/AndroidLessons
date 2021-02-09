package com.example.myapplication.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.fragment.musicItems.FragmentDetails;
import com.example.myapplication.ui.fragment.musicItems.FragmentList;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, new FragmentList())
                .commit();

    }

    public void showDetails(String singerName, String songName) {
        FragmentDetails fragment = new FragmentDetails();

        Bundle params = new Bundle();
        params.putString(FragmentDetails.SINGER_NAME, singerName);
        params.putString(FragmentDetails.SONG_NAME, songName);
        fragment.setArguments(params);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, fragment)
                .addToBackStack(null)
                .commit();

    }

}