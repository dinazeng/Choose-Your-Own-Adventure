package com.qbielka.dinazeng.choose_your_own_adventure.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryModel;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryPiece;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    StoryModel storyModel = new StoryModel(1,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        foo();
    }

    private void foo() {
        StoryPiece storyPiece = storyModel.getNextStory();
        setStory (storyPiece);
    }

    public void setStory(StoryPiece storyPiece){
        TextView text = findViewById(R.id.game_story);
        text.setText(storyPiece.getStory());
    }

    public void setButtons (StoryPiece storyPiece){
        Button button_1 = findViewById(R.id.game_option1);
        Button button_2 = findViewById(R.id.game_option2);
        Button button_3 = findViewById(R.id.game_option3);
        Button button_4 = findViewById(R.id.game_option4);

        button_1.setVisibility(View.GONE);
        button_2.setVisibility(View.GONE);
        button_3.setVisibility(View.GONE);
        button_4.setVisibility(View.GONE);

        ArrayList<String> buttonList = storyPiece.getButtons();
        for (int num = 0; num < buttonList.size(); num++){
            if (num == 0){
                button_1.setVisibility(View.VISIBLE);
                button_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storyModel.buttonNPushed(1);
                        //TODO
                    }
                });
            }
            if (num == 1){
                button_2.setVisibility(View.VISIBLE);
                button_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storyModel.buttonNPushed(2);
                        //TODO
                    }
                });
            }
            if (num == 2){
                button_3.setVisibility(View.VISIBLE);
                button_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storyModel.buttonNPushed(3);
                        //TODO
                    }
                });
            }
            if (num == 3){
                button_4.setVisibility(View.VISIBLE);
                button_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storyModel.buttonNPushed(4);
                        //TODO
                    }
                });
            }
        }


    }

}