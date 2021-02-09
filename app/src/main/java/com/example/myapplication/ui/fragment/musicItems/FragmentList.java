package com.example.myapplication.ui.fragment.musicItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.SampleData;
import com.example.myapplication.view.adapter.AdapterMusicItems;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    private AdapterMusicItems adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        initList(view);
    }

    private void initList(View view) {
        RecyclerView rvItems = view.findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new AdapterMusicItems();
        rvItems.setAdapter(adapter);
        adapter.updateData(getData());
    }

    private List<SampleData> getData() {
        ArrayList<SampleData> result = new ArrayList<>();
        result.add(new SampleData("СПЛИН", "17 June", " Выхода нет")); //todo refactor to subtype
        result.add(new SampleData("Lumen", "1 March", " Три пути"));
        result.add(new SampleData("LOBODA", "22 February", " Новый Рим"));
        result.add(new SampleData("Агата Кристи", "17 June", " Джиги-дзаги"));
        result.add(new SampleData("Би-2", "8 April", " Чёрное солнце"));
        result.add(new SampleData("СПЛИН", "17 June", " Выхода нет"));
        result.add(new SampleData("Lumen", "1 March", " Три пути"));
        result.add(new SampleData("LOBODA", "22 February", " Новый Рим"));
        result.add(new SampleData("Агата Кристи", "17 June", " Джиги-дзаги"));
        result.add(new SampleData("Би-2", "8 April", " Чёрное солнце"));
        return result;
    }

}
