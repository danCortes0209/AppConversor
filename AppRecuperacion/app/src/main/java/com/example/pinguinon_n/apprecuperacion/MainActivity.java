package com.example.pinguinon_n.apprecuperacion;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNumber;
    Button btnDec;
    Button btnHex;
    Button btnOct;
    TextView tvRes;
    String result = "";
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNumber = (EditText)findViewById(R.id.edVariable);
        btnOct = (Button)findViewById(R.id.btnOct);
        btnDec = (Button)findViewById(R.id.btnDec);
        btnHex = (Button)findViewById(R.id.btnHex);
        tvRes = (TextView)findViewById(R.id.tvRes);
        btnOct.setOnClickListener(clickListener);
        btnDec.setOnClickListener(clickListener);
        btnHex.setOnClickListener(clickListener);
        tvRes.setText(result);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btnDec){
                try {
                    result = "";
                    number = Integer.parseInt(edNumber.getText().toString(), 2);
                    result  = result + number;
                    tvRes.setText(result);
                    result = "";
                } catch (Exception e){
                    setAlertMessages("introduce un numero por favor" + e);
                }
            } else if (v == btnHex){
                try{
                    result = "";
                    number = Integer.parseInt(edNumber.getText().toString(), 2);
                    result = Integer.toHexString(number);
                    tvRes.setText(result);
                } catch (Exception e){
                    setAlertMessages("introduce un numero por favor" + e);
                }
            } else if (v == btnOct){
                try{
                    result = "";
                    number = Integer.parseInt(edNumber.getText().toString(), 2);
                    result = Integer.toOctalString(number);
                    tvRes.setText(result);
                } catch (Exception e){
                    setAlertMessages("introduce un numero por favor" + e);
                }
            }
        }
    };

    public void setAlertMessages(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(message)
                .setNegativeButton("Back",null)
                .create()
                .show();
    }
}
