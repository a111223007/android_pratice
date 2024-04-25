package com.example.raddiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr= "";

                RadioButton boy =(RadioButton) findViewById(R.id.rdbBoy);
                RadioButton girl=(RadioButton) findViewById(R.id.rdbGirl);
                EditText quantityEditText = (EditText) findViewById(R.id.editTextQuantity);

                double ticketPrice = 0.0;


                if (boy.isChecked())
                    outputStr += "男生\n";
                else if (girl.isChecked())
                    outputStr +="女生\n";
                RadioGroup type = (RadioGroup) findViewById(R.id.rgType);


                if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                    outputStr += "全票\n";

                else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                    outputStr += "兒童票\n";
                else
                    outputStr += "學生票\n";


                if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                    ticketPrice = 500;
                else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                    ticketPrice = 250;
                else
                    ticketPrice = 400;

                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(outputStr);
                String quantityStr = quantityEditText.getText().toString();
                if (!quantityStr.isEmpty()) {
                    int quantity = Integer.parseInt(quantityStr);
                    int totalPrice = (int)(ticketPrice * quantity);
                    outputStr += "張數：" + quantity + "\n";
                    outputStr += "總價：" + totalPrice + " 元";
                } else {
                    outputStr += "請輸入張數";
                }

                output.setText(outputStr);


            }
        });

    }
}