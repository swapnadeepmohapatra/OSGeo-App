package com.example.osgeo.Actvities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.osgeo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        FirebaseDatabase.getInstance().getReference().child(Objects.requireNonNull(name)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("Data", "onDataChange: " + dataSnapshot);
                String details = String.valueOf(dataSnapshot.child("Details").getValue());
                final String link = String.valueOf(dataSnapshot.child("link").getValue());
                final String imgLink = String.valueOf(dataSnapshot.child("imgLnk").getValue());
//                Toast.makeText(DetailsActivity.this, link, Toast.LENGTH_SHORT).show();

                TextView t = findViewById(R.id.projectDetails);
                t.setText(details);

                ImageView i = findViewById(R.id.ProjImg);
                Picasso.get().load(imgLink).into(i);

                Button b = findViewById(R.id.moreInfo);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(DetailsActivity.this, BrowseActivity.class).putExtra("ImageLink", link));
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
