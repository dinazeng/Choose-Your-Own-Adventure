package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;

public class programAdapter extends RecyclerView.Adapter<programAdapter.ViewHolder> {

    Context context;
    String [] names;
    String [] jobs;
    int [] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowJob;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView);
            rowJob = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView2);
        }
    }

    public programAdapter(Context context, String[] names, String[] jobs, int[] images) {
        this.context = context;
        this.names = names;
        this.jobs = jobs;
        this.images = images;
    }

    @NonNull
    @Override
    public programAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.credits_resource,parent, false);
        ViewHolder viewHolder = new ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull programAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(names[position]);
        holder.rowJob.setText(jobs[position]);
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
