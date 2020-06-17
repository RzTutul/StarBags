package com.example.starbagsall;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starbagsall.db.StarDatabase;
import com.example.starbagsall.entites.DataPojo;
import com.google.android.material.snackbar.Snackbar;

public class CorporateActivity extends AppCompatActivity {

    String bagType[] = {"Select Bag", "Handle", "D-Cut", "W-Cut"};
    String gsm[] = {"Select gsm","gsm", "50gsm", "60gsm", "70gsm", "80gsm"};
    String swingtype[] = {"Select Swing", "Auto/Heat Sealing", "Net Swing"};
    String print[] = {"Select Color", "No color", "1 color", "2 color", "3 color", "4 color", "Screen Color"};

    Button calculateBtn;
    EditText weightET, heightET, guessetET,qytET;


    double bagValue, gsmValue, swingValue, printValue;


    Spinner bagTypeSp, gsmSP, swingtypeSP, printSP;
    String selectBag, selectgsm, selectSwing, selectPrint;
    DataPojo dataPojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporate);

        setTitle("Corporate");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bagTypeSp = findViewById(R.id.bagtpeSp);
        gsmSP = findViewById(R.id.gsmSP);
        swingtypeSP = findViewById(R.id.swingSP);
        printSP = findViewById(R.id.printSP);
        calculateBtn = findViewById(R.id.calculateBtn);
        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);
        guessetET = findViewById(R.id.guessetET);
        qytET = findViewById(R.id.qytET);




        dataPojo = StarDatabase.getInstance(CorporateActivity.this).getStarBagDao().getAllData(1);
       // View parentLayout = findViewById(android.R.id.content);

        if (dataPojo == null) {
            Toast.makeText(this, "At first Insert all Value", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CorporateActivity.this,StoreValueActivity.class);
            startActivity(intent);
        }


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightET.getText().toString();
                String height = heightET.getText().toString();
                String guesset = guessetET.getText().toString();
                String qyt = qytET.getText().toString();

                if (weight.isEmpty()) {
                    weightET.setError("Enter Weigh!");
                } else if (height.isEmpty()) {
                    heightET.setError("Enter Heigh!");
                } else if (guesset.isEmpty()) {
                    guessetET.setError("Enter Guesset");
                } else if (selectBag.equals("Select Bag")) {
                    TextView errorText = (TextView) bagTypeSp.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);//just to highlight that this is an error
                    errorText.setText("Select Bug Type");
                } else if (selectgsm.equals("Select gsm")) {
                    TextView errorText = (TextView) gsmSP.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);//just to highlight that this is an error
                    errorText.setText("Select gsm");
                } else if (selectSwing.equals("Select Swing")) {
                    TextView errorText = (TextView) swingtypeSP.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);//just to highlight that this is an error
                    errorText.setText("Select Swing");
                } else if (selectPrint.equals("Select Color")) {
                    TextView errorText = (TextView) printSP.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);//just to highlight that this is an error
                    errorText.setText("Select Color");
                }

                else if(qyt.isEmpty())
                {
                    qytET.setError("Enter Qyt!");
                }


                ///StarBugResult


                else
                {
                    TextView weightTV =findViewById(R.id.weightTV);
                    TextView heightTV = findViewById(R.id.heightTV);
                    TextView gussetTV = findViewById(R.id.gussetTV);
                    TextView bagTV = findViewById(R.id.bagTV);
                    TextView bagValueTV = findViewById(R.id.bagValueTV);
                    TextView gsmTV = findViewById(R.id.gsmTV);
                    TextView gsmValueTV = findViewById(R.id.gsmValueTV);
                    TextView swingTV = findViewById(R.id.swingTV);
                    TextView swingValueTV = findViewById(R.id.swingValueTV);
                    TextView printTV = findViewById(R.id.printTV);
                    TextView printValueTV = findViewById(R.id.printValueTV);
                    TextView qytValueTV = findViewById(R.id.QytTV);
                    TextView resultTV = findViewById(R.id.resultTV);

                    weightTV.setText(weight);
                    heightTV.setText(height);
                    gussetTV.setText(guesset);
                    bagTV.setText(selectBag);
                    bagValueTV.setText(String.valueOf(bagValue));
                    gsmTV.setText(selectgsm);
                    gsmValueTV.setText(String.valueOf(gsmValue));
                    swingTV.setText(selectSwing);
                    swingValueTV.setText(String.valueOf(swingValue));
                    printTV.setText(selectPrint);
                    printValueTV.setText(String.valueOf(printValue));
                    qytValueTV.setText(qyt);


                    double valueA =(Double.valueOf(weight)+Double.valueOf(guesset))*(Double.valueOf(height)+(Double.valueOf(guesset)/2));
                    double valueB = (valueA+(bagValue));
                    double valueC = valueB*2;
                    double valueD = valueC*gsmValue;
                    double valueE = valueD*swingValue;
                    double valueF = valueE+printValue;
                    double finalValue = valueF+0.60;
                    double finalValue2 = finalValue*Double.valueOf(qyt);
                    resultTV.setText(String.valueOf(finalValue2));


                }


            }
        });


        ArrayAdapter<String> bagAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bagType);
        ArrayAdapter<String> gsmAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gsm);
        ArrayAdapter<String> swingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, swingtype);
        ArrayAdapter<String> printAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, print);

        bagTypeSp.setAdapter(bagAdapter);
        gsmSP.setAdapter(gsmAdapter);
        swingtypeSP.setAdapter(swingAdapter);
        printSP.setAdapter(printAdapter);


        bagTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectBag = parent.getItemAtPosition(position).toString();
                if (selectBag.equals("Select Bag")) {
                } else if (selectBag.equals("Handle")) {
                    bagValue = dataPojo.getHandleValue();
                    Snackbar.make(view, "" + selectBag + "-" +bagValue, Snackbar.LENGTH_SHORT).show();
                } else if (selectBag.equals("D-Cut")) {
                    bagValue = dataPojo.getdCutValue();
                    Snackbar.make(view, "" + selectBag + "-" + bagValue, Snackbar.LENGTH_SHORT).show();
                } else if (selectBag.equals("W-Cut")) {
                    bagValue = dataPojo.getWcutValue();
                    Snackbar.make(view, "" + selectBag + "-" + bagValue, Snackbar.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gsmSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectgsm = parent.getItemAtPosition(position).toString();

                if (selectgsm.equals("Select gsm")) {


                }

                else if (selectgsm.equals("gsm")) {
                    gsmValue = dataPojo.getGsm40Value();
                    Snackbar.make(view, "" + selectgsm + "-" + gsmValue, Snackbar.LENGTH_SHORT).show();
                }
                else if (selectgsm.equals("50gsm")) {

                    gsmValue = dataPojo.getGsm50Value();
                    Snackbar.make(view, "" + selectgsm + "-" + gsmValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectgsm.equals("60gsm")) {

                    gsmValue = dataPojo.getGsm60Value();
                    Snackbar.make(view, "" + selectgsm + "-" +gsmValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectgsm.equals("70gsm")) {
                    gsmValue = dataPojo.getGsm70Value();
                    Snackbar.make(view, "" + selectgsm + "-" +gsmValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectgsm.equals("80gsm")) {

                    gsmValue = dataPojo.getGsm80Value();
                    Snackbar.make(view, "" + selectgsm+"-"+gsmValue, Snackbar.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        swingtypeSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectSwing = parent.getItemAtPosition(position).toString();

                if (selectSwing.equals("Select Swing")) {

                } else if (selectSwing.equals("Auto/Heat Sealing")) {

                    swingValue = dataPojo.getAutoSealingValue();
                    Snackbar.make(view, "" + selectSwing + "-" + swingValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectSwing.equals("Net Swing")) {

                    swingValue = dataPojo.getNetSwingValue();

                    Snackbar.make(view, "" + selectSwing + "-" + swingValue, Snackbar.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        printSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectPrint = parent.getItemAtPosition(position).toString();

                if (selectPrint.equals("Select Print")) {

                } else if (selectPrint.equals("No color")) {
                    printValue = dataPojo.getNoColorValue();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectPrint.equals("1 color")) {
                    printValue = dataPojo.getColor1Value();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectPrint.equals("2 color")) {
                    printValue = dataPojo.getColor2Value();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectPrint.equals("3 color")) {
                    printValue = dataPojo.getColor3Value();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectPrint.equals("4 color")) {
                    printValue = dataPojo.getColor4Value();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                } else if (selectPrint.equals("Screen Color")) {
                    printValue = dataPojo.getScreenPrint();
                    Snackbar.make(view, "" + selectPrint + "-" + printValue, Snackbar.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
