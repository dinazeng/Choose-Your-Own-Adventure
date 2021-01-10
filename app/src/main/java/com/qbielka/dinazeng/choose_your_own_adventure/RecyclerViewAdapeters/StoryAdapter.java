package com.qbielka.dinazeng.choose_your_own_adventure.RecyclerViewAdapeters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryModel;
import com.qbielka.dinazeng.choose_your_own_adventure.ui.GameActivity;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    Activity context;
    ArrayList<com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button> buttons;
    StoryModel model;
    GameActivity g;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }

    public StoryAdapter(Activity context, ArrayList<com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button> text, StoryModel model) {
        this.context = context;
        this.buttons = text;
        this.model = model;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
                model.buttonNPushed(position, context);

                Intent nextStage = new Intent(context, GameActivity.class);
                context.finish();
                context.startActivity(nextStage);


            }
        });
    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }
}
