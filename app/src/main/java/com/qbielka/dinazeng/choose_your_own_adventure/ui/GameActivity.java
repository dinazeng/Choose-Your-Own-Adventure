package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryModel;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryPiece;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {


    StoryModel storyModel;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        storyModel = new StoryModel(1, getApplicationContext());

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
        button_1 = findViewById(R.id.game_option1);
        button_2 = findViewById(R.id.game_option2);
        button_3 = findViewById(R.id.game_option3);
        button_4 = findViewById(R.id.game_option4);

        hideButtons();

        ArrayList<String> buttonList = storyPiece.getButtons();
        for (int num = 0; num < buttonList.size(); num++){
            if (num == 0){
                button_1.setVisibility(View.VISIBLE);
                setOnClickListeners(button_1, 1);
            }
            if (num == 1){
                button_2.setVisibility(View.VISIBLE);
                setOnClickListeners(button_2, 2);
            }
            if (num == 2){
                button_3.setVisibility(View.VISIBLE);
                setOnClickListeners(button_3, 3);
            }
            if (num == 3){
                button_4.setVisibility(View.VISIBLE);
                setOnClickListeners(button_4, 4);
            }
        }


    }

    private void setOnClickListeners(Button button_1, int i) {
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyModel.buttonNPushed(i);
                updateUI();
            }
        });
    }

    private void hideButtons() {
        button_1.setVisibility(View.GONE);
        button_2.setVisibility(View.GONE);
        button_3.setVisibility(View.GONE);
        button_4.setVisibility(View.GONE);
    }

    private void updateUI(){
        // todo
    }

}