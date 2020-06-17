package com.example.starbagsall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    CardView corparteCard,dealerCard,starCard;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("DashBoard");
        corparteCard = findViewById(R.id.corpateCard);
        starCard = findViewById(R.id.starCard);
        linearLayout = findViewById(R.id.ll);
        Animation aboveAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.above_animation);
        linearLayout.setAnimation(aboveAnim);

        corparteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CorporateActivity.class);
                startActivity(intent);
            }
        });



        starCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AdminPanelActivity.class);
                startActivity(intent);
            }
        });
    }
}
