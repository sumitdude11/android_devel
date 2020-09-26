package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
public class MainActivity extends androidx.appcompat.app.AppCompatActivity  {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //change color of action bar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#492000"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);


        //take text from one page to other
        final EditText user_name = (EditText) findViewById(R.id.user_name);


        button = (Button) findViewById(R.id.btn4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String str;
                str = user_name.getText().toString();
                Intent intent = new Intent(MainActivity.this , MainActivity3.class);
                intent.putExtra("messageh",str);
                startActivity(intent);
            }



        });


        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String str;
                str = user_name.getText().toString();
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                intent.putExtra("message",str);
                startActivity(intent);
            }



        });

    }
}
