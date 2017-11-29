package com.example.coshri.myapp5778.controller;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coshri.myapp5778.R;
import com.example.coshri.myapp5778.model.backend.AcademyConst;
import com.example.coshri.myapp5778.model.backend.DBManagerFactory;

public class AddLecturerActivity extends Activity implements View.OnClickListener {

    private EditText IdEditText;
    private EditText NameEditText;
    private EditText PhoneEditText;
    private EditText SeniorityEditText;
    private Button addLecturerButton;


    private void findViews() {
        IdEditText = (EditText) findViewById(R.id.IdEditText);
        NameEditText = (EditText) findViewById(R.id.NameEditText);
        PhoneEditText = (EditText) findViewById(R.id.PhoneEditText);
        SeniorityEditText = (EditText) findViewById(R.id.SeniorityEditText);
        addLecturerButton = (Button) findViewById(R.id.addLecturerButton);

        addLecturerButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecturer);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == addLecturerButton) {
            addLecturer();
        }
    }

private void addLecturer() {
        final ContentValues contentValues = new ContentValues();
        try {
            int id = Integer.valueOf(this.IdEditText.getText().toString());
            contentValues.put(AcademyConst.LecturerConst.ID, id);

            contentValues.put(AcademyConst.LecturerConst.NAME, this.NameEditText.getText().toString());
            contentValues.put(AcademyConst.LecturerConst.PHONE, this.PhoneEditText.getText().toString());

            int Seniority = Integer.valueOf(this.SeniorityEditText.getText().toString());
            contentValues.put(AcademyConst.LecturerConst.SENIORITY, Seniority);




new AsyncTask<Void, Void, Long>() {
    @Override
    protected void onPostExecute(Long idResult) {
        super.onPostExecute(idResult);
        if (idResult > 0)
            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
    }

    @Override
    protected Long doInBackground(Void... params) {
        return DBManagerFactory.getManager().addLecturer(contentValues);
    }
}.execute();




        } catch (Exception e) {
        }
    }
}