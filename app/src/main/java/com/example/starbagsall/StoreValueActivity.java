package com.example.starbagsall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.starbagsall.db.StarDatabase;
import com.example.starbagsall.entites.DataPojo;
import com.google.android.material.snackbar.Snackbar;

public class StoreValueActivity extends AppCompatActivity {

    EditText handdleET, dCutET, wCutET, gsm40ET, gsm50ET, gsm60ET, gsm70ET, gsm80ET;
    EditText autoSealingET, netSwingET, noColorET, color1ET, color2ET, color3ET, color4ET, screenPrintET;

    Button saveBtn,updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_value);

        setTitle("Save Value");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        handdleET = findViewById(R.id.handleET);
        dCutET = findViewById(R.id.decutET);
        wCutET = findViewById(R.id.wCutET);
        gsm40ET = findViewById(R.id.gsm40ET);
        gsm50ET = findViewById(R.id.gsm50ET);
        gsm60ET = findViewById(R.id.gsm60ET);
        gsm70ET = findViewById(R.id.gsm70ET);
        gsm80ET = findViewById(R.id.gsm80ET);
        autoSealingET = findViewById(R.id.autoScallingET);
        netSwingET = findViewById(R.id.netSwingET);
        noColorET = findViewById(R.id.noColorET);
        color1ET = findViewById(R.id.color1ET);
        color2ET = findViewById(R.id.color2ET);
        color3ET = findViewById(R.id.color3ET);
        color4ET = findViewById(R.id.color4ET);
        screenPrintET = findViewById(R.id.screenPrintET);
        saveBtn = findViewById(R.id.saveBtn);
        updateBtn = findViewById(R.id.updateBtn);


        Bundle bundle = getIntent().getExtras();

        if (bundle!=null) {
            String update = bundle.getString("data");

            if (update.equals("update")) {
                saveBtn.setVisibility(View.GONE);
                updateBtn.setVisibility(View.VISIBLE);

                DataPojo dataPojo = StarDatabase.getInstance(StoreValueActivity.this).getStarBagDao().getAllData(1);

                if (dataPojo != null) {

                    handdleET.setText(String.valueOf(dataPojo.getHandleValue()));
                    dCutET.setText(String.valueOf(dataPojo.getdCutValue()));
                    wCutET.setText(String.valueOf(dataPojo.getWcutValue()));
                    gsm40ET.setText(String.valueOf(dataPojo.getGsm40Value()));
                    gsm50ET.setText(String.valueOf(dataPojo.getGsm50Value()));
                    gsm60ET.setText(String.valueOf(dataPojo.getGsm60Value()));
                    gsm70ET.setText(String.valueOf(dataPojo.getGsm70Value()));
                    gsm80ET.setText(String.valueOf(dataPojo.getGsm80Value()));
                    autoSealingET.setText(String.valueOf(dataPojo.getAutoSealingValue()));
                    netSwingET.setText(String.valueOf(dataPojo.getNetSwingValue()));
                    noColorET.setText(String.valueOf(dataPojo.getNoColorValue()));
                    color1ET.setText(String.valueOf(dataPojo.getColor1Value()));
                    color2ET.setText(String.valueOf(dataPojo.getColor2Value()));
                    color3ET.setText(String.valueOf(dataPojo.getColor3Value()));
                    color4ET.setText(String.valueOf(dataPojo.getColor4Value()));
                    screenPrintET.setText(String.valueOf(dataPojo.getScreenPrint()));
                }
            }
        }


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String handleValue = handdleET.getText().toString();
                String dcutValue = dCutET.getText().toString();
                String wCutvalue = wCutET.getText().toString();
                String gsm40Value = gsm40ET.getText().toString();
                String gsm50Value = gsm50ET.getText().toString();
                String gsm60Value = gsm60ET.getText().toString();
                String gsm70Value = gsm70ET.getText().toString();
                String gsm80Value = gsm80ET.getText().toString();
                String autoScaling = autoSealingET.getText().toString();
                String netSwing = netSwingET.getText().toString();
                String noColorValue = noColorET.getText().toString();
                String color1Value = color1ET.getText().toString();
                String color2Value = color2ET.getText().toString();
                String color3Value = color3ET.getText().toString();
                String color4Value = color4ET.getText().toString();
                String screenPrint = screenPrintET.getText().toString();



                if (color1Value.isEmpty())
                {
                    Snackbar.make(v,"Insert All Value",Snackbar.LENGTH_SHORT).show();
                }

                else  if (gsm80Value.isEmpty())
                {
                    Snackbar.make(v,"Insert All Value",Snackbar.LENGTH_SHORT).show();

                }

                else
                {
                    DataPojo dataPojo = new DataPojo(Double.parseDouble(handleValue),
                            Double.parseDouble(dcutValue),
                            Double.parseDouble(wCutvalue),
                            Double.parseDouble(gsm40Value),
                            Double.parseDouble(gsm50Value),
                            Double.parseDouble(gsm60Value),
                            Double.parseDouble(gsm70Value),
                            Double.parseDouble(gsm80Value),
                            Double.parseDouble(autoScaling),
                            Double.parseDouble(netSwing),
                            Double.parseDouble(noColorValue),
                            Double.parseDouble(color1Value),
                            Double.parseDouble(color2Value),
                            Double.parseDouble(color3Value),
                            Double.parseDouble(color4Value),
                            Double.parseDouble(screenPrint)
                    );



                    long insert = StarDatabase.getInstance(StoreValueActivity.this).getStarBagDao().InsertValue(dataPojo);

                    if (insert > 0) {
                        Toast.makeText(StoreValueActivity.this, "Saved Sucessfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(StoreValueActivity.this,CorporateActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(StoreValueActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String handleValue = handdleET.getText().toString();
                String dcutValue = dCutET.getText().toString();
                String wCutvalue = wCutET.getText().toString();
                String gsm40Value = gsm40ET.getText().toString();
                String gsm50Value = gsm50ET.getText().toString();
                String gsm60Value = gsm60ET.getText().toString();
                String gsm70Value = gsm70ET.getText().toString();
                String gsm80Value = gsm80ET.getText().toString();
                String autoScaling = autoSealingET.getText().toString();
                String netSwing = netSwingET.getText().toString();
                String noColorValue = noColorET.getText().toString();
                String color1Value = color1ET.getText().toString();
                String color2Value = color2ET.getText().toString();
                String color3Value = color3ET.getText().toString();
                String color4Value = color4ET.getText().toString();
                String screenPrint = screenPrintET.getText().toString();




                DataPojo dataPojo = new DataPojo(1,Double.parseDouble(handleValue),
                        Double.parseDouble(dcutValue),
                        Double.parseDouble(wCutvalue),
                        Double.parseDouble(gsm40Value),
                        Double.parseDouble(gsm50Value),
                        Double.parseDouble(gsm60Value),
                        Double.parseDouble(gsm70Value),
                        Double.parseDouble(gsm80Value),
                        Double.parseDouble(autoScaling),
                        Double.parseDouble(netSwing),
                        Double.parseDouble(noColorValue),
                        Double.parseDouble(color1Value),
                        Double.parseDouble(color2Value),
                        Double.parseDouble(color3Value),
                        Double.parseDouble(color4Value),
                        Double.parseDouble(screenPrint)
                );

                int update = StarDatabase.getInstance(StoreValueActivity.this).getStarBagDao().updateValue(dataPojo);

                if (update > 0) {

                    Snackbar.make(v,"Update Sucessfully",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(StoreValueActivity.this, "Update Fail", Toast.LENGTH_SHORT).show();
                }

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
