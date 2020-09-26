package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
                // for name
        TextView tp;
        tp = (TextView) findViewById(R.id.txt6);
        Intent intent = getIntent();
        java.lang.String str;
        str = intent.getStringExtra("messageh");
        tp.setText(str);

        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference().child(str);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
             Member member;
            String rr="hey";
            String rr3="f";
            for( DataSnapshot snapshot:dataSnapshot.getChildren()) {
                member = snapshot.getValue(Member.class);
                 rr3 = member.getName();
            }
                TextView txt3 = (TextView) findViewById(R.id.txt3);
                Intent intent = getIntent();
                java.lang.String str;

                txt3.setText(rr3);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("The read failed:" );

            }
        });



    }


}