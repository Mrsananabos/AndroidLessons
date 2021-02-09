package com.example.myapplication.ui.fragment.menuItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.MusicGenreData;
import com.example.myapplication.view.adapter.AdapterMusicMenuItems;

import java.util.ArrayList;
import java.util.List;

public class FragmentMenuItem extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_menu, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        initList(view);
    }

    private void initList(View view) {
        RecyclerView rvItems = view.findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        AdapterMusicMenuItems adapter = new AdapterMusicMenuItems();
        rvItems.setAdapter(adapter);
        adapter.updateData(getData());
    }

    private List<MusicGenreData> getData() {
        ArrayList<MusicGenreData> result = new ArrayList<>();
        result.add(new MusicGenreData("Pop", "", ""));
        result.add(new MusicGenreData("Рок", "", ""));
        result.add(new MusicGenreData("Рэп", "", ""));
        return result;
    }


}
