package com.example.myapplication.view.ui.fragment.musicItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;

public class FragmentDetails extends Fragment {

    public static final String SINGER_NAME = "singer_name";
    public static final String SONG_NAME = "song_name";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sing_item, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        String singerName = getArguments().getString(SINGER_NAME);
        String songName = getArguments().getString(SONG_NAME);
        ((TextView) view.findViewById(R.id.singerName)).setText(singerName);
        ((TextView) view.findViewById(R.id.songName)).setText(songName);
    }


}
