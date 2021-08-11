package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton ib = findViewById(R.id.ib);
        TextView winning = findViewById(R.id.winning);
        final int[] count = {0};

        ib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                winning.setText("");
                int winnum[] = new int[7];
                Random random = new Random();
                while(true) {
                    for (int i = 0; i < 7; i++) {
                        winnum[i] = random.nextInt(45) + 1;
                        for (int j = 0; j < i; j++) {
                            if (winnum[i] == winnum[j]) {
                                i--;
                            }
                        }
                    }
                    for(int w : winnum) {
                        winning.append(w + " ");
                    }
                    count[0]++;
                    if(count[0] > 4)
                        break;
                    winning.append("\n");
                }
            }
        });
    }
}
