package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameBoard extends AppCompatActivity {

    private String playerOne;
    private String playerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_board);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent i = getIntent();
        this.playerOne = i.getStringExtra("playerOne");
        this.playerTwo = i.getStringExtra("playerTwo");

        if (this.playerOne != null && this.playerTwo != null) {
            this.setPlayersName(this.playerOne, this.playerTwo);
        }
    }

    private void setPlayersName(String one, String two) {
        ((EditText) findViewById(R.id.plyerOne)).setText(one);
        ((EditText) findViewById(R.id.plyerTwo)).setText(two);
    }


}