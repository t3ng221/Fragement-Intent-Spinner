package com.example.fragmentintentspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mySpinner;
    RadioGroup myRadiogroup;
    RadioButton selectedRadiobutton;
    String selectedValue;
    public static String quizmarks="I'm A STUDENT";
    int marks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner=findViewById(R.id.mySpinnerID);
        myRadiogroup=findViewById(R.id.radioGroupID);

        ArrayAdapter<CharSequence> myAdapter=ArrayAdapter.createFromResource(this,R.array.mycountryArray,android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Fragment myfragment;
        if(text.equals("Bangladesh")){
            // load BDFragment2;
            myfragment=new BDFragment();
        }
        else if(text.equals("India")){
            //INFragment2;
            myfragment= new INFragment();
        }
        else {
            // BlankFragment;
            myfragment=new BlankFragment();
        }

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.myFragmentAreaID,myfragment);
        ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Fragment myfragment;
        myfragment=new BlankFragment();

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.myFragmentAreaID,myfragment);
        ft.commit();
    }


    public void submitfunction(View view) {
        int radioButtonid=myRadiogroup.getCheckedRadioButtonId();
        selectedRadiobutton=findViewById(radioButtonid);
        selectedValue=selectedRadiobutton.getText().toString();
        if(selectedValue.equals("Ashulia")){
            marks=5;
        }
        Intent myIntent=new Intent(MainActivity.this,MainActivity2.class );
        myIntent.putExtra(quizmarks,marks);
        startActivity(myIntent);

    }
}
