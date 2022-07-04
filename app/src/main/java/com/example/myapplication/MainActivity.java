package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
String []item = {"1.单机编辑","2.长按消除","3.","4.","5.","6.","7."};
ArrayAdapter<String>ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.lv);
        ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(MainActivity.this,MainActivity2.class);
                it.putExtra("备忘",item[i]);
                startActivityForResult(it,i);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item[i]=(i+1)+".";
                ad.notifyDataSetChanged();
                return true;
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
             super.onActivityResult(requestCode, resultCode, data);
             if(resultCode==RESULT_OK){
                 item[requestCode]=data.getStringExtra("备忘");
                 ad.notifyDataSetChanged();
        }
    }
}