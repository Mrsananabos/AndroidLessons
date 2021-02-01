package com.example.myapplication.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.SampleData;
import com.example.myapplication.ui.activity.ActivityItem;

import java.util.List;

public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ViewHolderItem> {

    private List<SampleData> data;

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderItem(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void updateData(List<SampleData> data) {
        this.data = data;
        notifyDataSetChanged();
        //notifyItemChanged();
        //notifyItemInserted();
        //notifyItemRemoved();
    }

    class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView vmdSingerName, vmdDesc, songName;

        public ViewHolderItem(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_music_item, parent, false));
            vmdSingerName = itemView.findViewById(R.id.vmdSingerName);
            vmdDesc = itemView.findViewById(R.id.vmdDesc);
            songName = itemView.findViewById(R.id.songName);
            itemView.setOnClickListener(this);

        }

        public void setData(int position) {
            vmdSingerName.setText(data.get(position).singerName);
            vmdDesc.setText(data.get(position).date + " \u2022 " + data.get(position).songName);
            songName.setText(data.get(position).songName);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ActivityItem.class);
            intent.putExtra(ActivityItem.EXTRA_ID, data.get(getAdapterPosition()).singerName);
            intent.putExtra(ActivityItem.EXTRA_ID, data.get(getAdapterPosition()).date);
            view.getContext().startActivity(intent);
        }
    }
}
