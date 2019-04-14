package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText heightt,weightt, result;
    Button btn_Cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Cal=findViewById(R.id.val_btn);
        btn_Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightt=findViewById(R.id.val_height);
                weightt=findViewById(R.id.val_weight);
                result=findViewById(R.id.val_bmi);

             String  re_height=heightt.getText().toString();
               String re_weight=weightt.getText().toString();
               if (re_height.length()==0){
                   heightt.setError("Enter your height in cm");
               }
                else if (weightt.length()==0){
                    weightt.setError("Enter your weight in kg");
                }
                else{
                    float h1,w1;
                    String print="";
                    h1=Float.parseFloat(re_height);
                   w1=Float.parseFloat(re_weight);
                   float hh1=h1/100;

                   float BMI=w1/(hh1*hh1);
                   result.setText(""+BMI);


               if (BMI<18.5)
               {
                  print="UnderWeight";
               }

               else if (BMI>18.4 && BMI<25)
               {
                   print="Normal Weight";
               }
               else if (BMI>24.9 && BMI<30)
               {
                   print="Over Weight";
               }
               else if (BMI>29.9)
               {
                   print="Obesity";
               }
                Toast.makeText(MainActivity.this,print,Toast.LENGTH_LONG).show();

                }
            }

        });
    }


}
