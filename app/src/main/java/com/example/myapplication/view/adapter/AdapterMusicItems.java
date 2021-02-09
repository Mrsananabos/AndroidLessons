package com.example.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.SampleData;
import com.example.myapplication.ui.activity.MainActivity;

import java.util.List;

public class AdapterMusicItems extends RecyclerView.Adapter<AdapterMusicItems.ViewHolderItemBase> {
    private List<SampleData> data;
    private int TYPE_HEADER = 1;
    private int TYPE_ITEM = 2;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    @NonNull
    @Override
    public ViewHolderItemBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER)
            return new ViewHolderHeader(parent);
        return new ViewHolderItem(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItemBase holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void updateData(List<SampleData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    abstract static class ViewHolderItemBase extends RecyclerView.ViewHolder {

        public ViewHolderItemBase(@NonNull View itemView) {
            super(itemView);
        }

        abstract public void setData(int position);
    }

    class ViewHolderItem extends ViewHolderItemBase implements View.OnClickListener {
        private final TextView vmdSingerName, vmdDesc;

        public ViewHolderItem(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_music_item, parent, false));
            vmdSingerName = itemView.findViewById(R.id.vmdSingerName);
            vmdDesc = itemView.findViewById(R.id.vmdDesc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void setData(int position) {
            vmdSingerName.setText(data.get(position).singerName);
            vmdDesc.setText(data.get(position).date + " \u2022 " + data.get(position).songName);
        }

        @Override
        public void onClick(View view) {
            ((MainActivity) view.getContext()).showDetails(data.get(getAdapterPosition()).singerName, data.get(getAdapterPosition()).songName);
        }
    }

    static class ViewHolderHeader extends ViewHolderItemBase implements View.OnClickListener {

        public ViewHolderHeader(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false));
        }

        public void setData(int position) {
            ImageView imageView = super.itemView.findViewById(R.id.ivButton);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ((MainActivity) view.getContext()).showMenuDetails();
        }
    }

}
