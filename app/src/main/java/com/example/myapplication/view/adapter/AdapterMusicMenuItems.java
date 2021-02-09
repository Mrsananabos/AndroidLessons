package com.example.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.MusicGenreData;
import com.example.myapplication.model.SampleData;
import com.example.myapplication.ui.activity.MainActivity;

import java.util.List;

public class AdapterMusicMenuItems extends RecyclerView.Adapter<AdapterMusicMenuItems.ViewHolderItem> {

    private List<MusicGenreData> data;

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

    public void updateData(List<MusicGenreData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class ViewHolderItem extends RecyclerView.ViewHolder {
        private final TextView vmmiName;
        private final ImageView vmmiBack, vmmiIcon;

        public ViewHolderItem(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_music_menu_item, parent, false));
            vmmiBack = itemView.findViewById(R.id.vmmiBack);
            vmmiIcon = itemView.findViewById(R.id.vmmiIcon);
            vmmiName = itemView.findViewById(R.id.vmmiName);
        }

        public void setData(int position) {
            vmmiBack.setImageResource(R.drawable.back_music_item);
            vmmiIcon.setImageResource(R.drawable.ic_baseline_shuffle_24);
            vmmiName.setText(data.get(position).genreName);
        }

    }
}
