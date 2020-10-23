package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        //change color of action bar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#492000"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

        /*


        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference();


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final String[] rp=new String[100];

                int i=0;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    rp[i] = snapshot.child("Name").getValue().toString();
                    i=i+1;
                }
                String rr="";
                for(int l=0;l<i;l++)
                {
                    rr=rr+rp[l];
                    rr=rr+"\n\n";
                }
                TextView txt3 = (TextView) findViewById(R.id.llp);
                Intent intent = getIntent();
                java.lang.String str;

                txt3.setText(rr);

    }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("The read failed:" );

            }




        });




         */


    }


}