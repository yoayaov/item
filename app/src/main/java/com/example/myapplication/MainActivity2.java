package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = (TextView) findViewById(R.id.textView2);
        Button bt3 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.button4);
        EditText et = (EditText) findViewById(R.id.editText);
        Intent it2=getIntent();
        String s=it2.getStringExtra("备忘");
        tv.setText(""+s.substring(0,2));
        if(s.length()>3){et.setText(""+s.substring(2));}
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent();
                it2.putExtra("备忘",(""+tv.getText()+ et.getText()));
                setResult(RESULT_OK,it2);
                finish();
            }
        });

    }
    }
