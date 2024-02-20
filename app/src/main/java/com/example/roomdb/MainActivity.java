package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.roomdb.entity.Perso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText firstNameEditText,lastNameEditText,ageEditText;

    Button btnAdd,btnAffich,btnOlderThen18;

    ListView lv;
    costumAdapter listViewcostumAdapter;

    PersoDataBase persoDataBase;

    List<Perso> persoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.prenomEditText);
        lastNameEditText = findViewById(R.id.nomEditText);
        ageEditText = findViewById(R.id.ageEditText);
        btnAdd =  findViewById(R.id.btnAdd);
        btnAffich = findViewById(R.id.getDat);
        btnOlderThen18 = findViewById(R.id.getOlderThen18);
        lv = findViewById(R.id.listV);

        persoList.add(new Perso("asdsad","asdsad",18));
        listViewcostumAdapter = new costumAdapter(this,persoList);
        lv.setAdapter(listViewcostumAdapter);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               new Thread(()->{
                    insertData(new Perso("abde","routabi",18));
                }).start();
            }
        });
        btnAffich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Cursor cur = persoDataBase.persoDoa().getData();
//                persoList.add(new Perso(cur.getString(1),cur.getString(2),cur.getInt(3)));
                persoList.add(new Perso("asdsad","asdsad",18));
                listViewcostumAdapter.setPersoList(persoList);
                lv.setAdapter(listViewcostumAdapter);
            }
        });

    }
    public void insertData(Perso perso){
        persoDataBase.persoDoa().insert(perso);
    }
}