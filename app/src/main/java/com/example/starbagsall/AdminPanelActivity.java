package com.example.starbagsall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AdminPanelActivity extends AppCompatActivity {

    CardView setUpCard,UpdateCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        setTitle("Admin Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpCard = findViewById(R.id.setUpCard);
        UpdateCard = findViewById(R.id.updateCard);

        setUpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanelActivity.this,StoreValueActivity.class);
                startActivity(intent);
            }
        });
          UpdateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanelActivity.this,StoreValueActivity.class);
                intent.putExtra("data","update");
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
