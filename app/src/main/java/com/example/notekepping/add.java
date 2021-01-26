package com.example.notekepping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class add extends AppCompatActivity {

    private EditText title;
    private EditText discriptions;
    private NumberPicker numberPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        title=(EditText)findViewById(R.id.titleofnote);
        discriptions=(EditText)findViewById(R.id.disc);
        numberPicker=(NumberPicker)findViewById(R.id.numberpicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_cancel_24);
        setTitle("Add Note");


    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.savemenu:
                save();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void save() {
        String t=title.getText().toString();
        String d=discriptions.getText().toString();
        int n=numberPicker.getValue();


        if(t.trim().isEmpty()|d.trim().isEmpty())
        {
            Toast.makeText(add.this, "Content are Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Intent data=new Intent();
            data.putExtra("title",t);
            data.putExtra("discriptions",d);
            data.putExtra("numberpocker",n);

            setResult(RESULT_OK,data);
            finish();

        }
    }
}