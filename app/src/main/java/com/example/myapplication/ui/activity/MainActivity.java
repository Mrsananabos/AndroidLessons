package com.example.myapplication.ui.activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.SampleData;
import com.example.myapplication.view.adapter.AdapterItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterItems adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView rvItems = findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL)); //this add divider between items
//        rvItems.addItemDecoration(new CustomItemDecoration()); //this add space between items
        new LinearSnapHelper().attachToRecyclerView(rvItems); //this add items center after scrolling

        //todo GridLayoutManager

        adapter = new AdapterItems();
        rvItems.setAdapter(adapter);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.updateData(getData());
            }
        }, 2000);

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

    private static class CustomItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view) != 0)
                outRect.top = (int) view.getContext().getResources().getDimension(R.dimen.view_divider_height);
        }
    }
}