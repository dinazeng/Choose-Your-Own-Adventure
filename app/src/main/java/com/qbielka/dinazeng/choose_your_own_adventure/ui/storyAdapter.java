package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.ViewHolder> {

    Context context;
    ArrayList<com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button> buttons;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }

    public storyAdapter(Context context, ArrayList<com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button> text) {
        this.context = context;
        this.buttons = text;
    }

    @NonNull
    @Override
    public storyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.game_buttons, parent, false);

        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setText(buttons.get(position).getButtonText());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }
}
