package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.ViewHolder> {

    Context context;
    ArrayList<String> text;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowText = itemView.findViewById(R.id.button_view);
        }
    }

    public storyAdapter(Context context, ArrayList<String> text) {
        this.context = context;
        this.text = text;
    }

    @NonNull
    @Override
    public storyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.game_buttons,parent, false);
        ViewHolder viewHolder = new ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowText.setText(text.get(position));
    }

    @Override
    public int getItemCount() {
        return text.size();
    }
}
