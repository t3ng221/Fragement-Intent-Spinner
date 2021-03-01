package com.example.fragmentintentspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    int result;
    TextView outputTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent myGetIntent=getIntent();
        result=myGetIntent.getIntExtra(MainActivity.quizmarks,0);
        outputTextview=findViewById(R.id.outputTextviewID);
        if (result==5){
            outputTextview.setText("Your answer is correct");
        }
        else{
            outputTextview.setText("Your answer is wrong");
        }
    }
    public void TryagainFunction(View view){
        Intent myfirstIntent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(myfirstIntent);
    }
}
