package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.RecyclerViewAdapeters.CreditsAdapter;

public class CreditsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    String [] name = {"Quince Bielka", "Dina Zeng", "WriterNameHere"};
    String [] job = {"Lead Developer","Developer","Author"};
    int [] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new CreditsAdapter(this, name, job, images);
        recyclerView.setAdapter(recyclerAdapter);
    }
}