package com.londonappbrewery.destini;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView story;
    private Button topButton;
    private Button bottomButton;
    private int top;
    private int bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        story = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        top = 1;
        bottom = 1;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        topButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                top++;
                if ( top ==2 && bottom == 1 || top == 2 && bottom == 2){
                    story.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);

                } else if(top == 3 && bottom == 1 || top == 3 && bottom == 2){
                    story.setText(R.string.T6_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setVisibility(View.GONE);

                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bottom ++;
                if (top == 1 && bottom == 2) {
                    story.setText(R.string.T2_Story);
                    topButton.setText(R.string.T2_Ans1);
                    bottomButton.setText(R.string.T2_Ans2);

                } else if(top ==1 && bottom == 3){
                    story.setText(R.string.T4_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setVisibility(View.GONE);

                } else if (top == 2 && bottom == 3){
                    story.setText(R.string.T5_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setVisibility(View.GONE);
                }

            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
        onCreate(null);
    }
}
