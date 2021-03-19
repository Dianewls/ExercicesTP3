package com.firida_diane.exercicestp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> planetes;
    private ListView listview;
    private PlaneteAdapter adapter;
    private Data data=new Data();
    Button btn;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // installePlanetes();

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this,data);
        listview.setAdapter(adapter);
        btn=findViewById(R.id.button);
        btn.setEnabled(false);

        btn.setOnClickListener((view) -> {
            int score=0;
            String[] taille=data.getTaillePlanetes();
            for (int i = 0; i <taille.length ; i++) {
                View v=listview.getChildAt(i);
                spinner=v.findViewById(R.id.spiner);
                if(spinner.getSelectedItem().toString().equals(taille[i])){
                    score=score+1;
                }


            }
            Toast.makeText(MainActivity.this, "votre score est :" +score+ "sur "+taille.length,Toast.LENGTH_SHORT).show();
        });


    }
}