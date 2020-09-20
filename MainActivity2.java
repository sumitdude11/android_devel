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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
EditText quotea;
Spinner spina;
Button btna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //write your name
        TextView textt=(TextView)findViewById(R.id.textt);
        Intent intent = getIntent();
        java.lang.String str = intent.getStringExtra("message");
        if(str=="")
            str="anonymous";
        java.lang.String str1;
        str1=str;
        str="By: "+str;
        textt.setText(str);



        //spinn
        Spinner spinner = findViewById(R.id.spin1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.quote,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





        //for dbms
        final DatabaseReference reff;
        final DatabaseReference reff2;
        final Member member;
        quotea = (EditText)findViewById(R.id.le);
        spina=(Spinner)findViewById(R.id.spin1);
        btna = (Button)findViewById(R.id.buttn);
       member = new Member();
         reff = FirebaseDatabase.getInstance().getReference().child(str1);

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //for spiner
                String txt=String.valueOf(spina.getSelectedItem().toString());
                member.setTypec(txt);
                reff.child(txt);

                String mes= String.valueOf(quotea.getText());
                member.setName(mes);
                reff.child(txt).push().setValue(member);


                Toast.makeText(MainActivity2.this, "Your Quote is submitted Successfully", Toast.LENGTH_SHORT).show();
            }
        });





        //color of above and background
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#492000"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
