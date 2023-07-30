package com.example.blitzzware;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new SliderViewHolder(view);
    }
    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        return layoutScreens[position];
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    int[] layoutScreens;
    public SliderAdapter(int[] layoutScreens) {
        this.layoutScreens = layoutScreens;
    }

    @Override
    public int getItemCount() {
//        return 0;
        return layoutScreens.length;
    }
}
