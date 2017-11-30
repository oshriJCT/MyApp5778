package com.example.coshri.myapp5778.controller;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coshri.myapp5778.R;
import com.example.coshri.myapp5778.model.backend.AcademyConst;
import com.example.coshri.myapp5778.model.backend.DBManagerFactory;
import com.example.coshri.myapp5778.model.entities.Year;

public class AddStudentActivity extends Activity implements View.OnClickListener {

private EditText IdEditText;
private EditText NameEditText;
private EditText PhoneEditText;

private Spinner yearSpinner;
private Button addStudentButton;
private ListView itemListView;
private TextView loadingTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        findViews();
        }

@Override
public void onClick(View v) {
        if (v == addStudentButton) {
        addStudent();
        }
        }


private void findViews() {
        IdEditText = (EditText) findViewById(R.id.IdEditText);
        NameEditText = (EditText) findViewById(R.id.NameEditText);
        PhoneEditText = (EditText) findViewById(R.id.PhoneEditText);

        addStudentButton = (Button) findViewById(R.id.addStudentButton);

        addStudentButton.setOnClickListener(this);

yearSpinner = (Spinner) findViewById(R.id.yearSpinner);
 yearSpinner.setAdapter(new ArrayAdapter<Year>(this, android.R.layout.simple_list_item_1, Year.values()));

        itemListView = (ListView) findViewById(R.id.ItemListView);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);

        }
    private void addStudent() {

        final ContentValues contentValues = new ContentValues();
        try {
            int id = Integer.valueOf(this.IdEditText.getText().toString());
            contentValues.put(AcademyConst.LecturerConst.ID, id);

            contentValues.put(AcademyConst.LecturerConst.NAME, this.NameEditText.getText().toString());
            contentValues.put(AcademyConst.LecturerConst.PHONE, this.PhoneEditText.getText().toString());

            String year = ((Year) yearSpinner.getSelectedItem()).name();
            contentValues.put(AcademyConst.StudentConst.YEAR, year);


            new AsyncTask<Void, Void, Long>() {
                @Override
                protected void onPostExecute(Long idResult) {
                    super.onPostExecute(idResult);
                    if (idResult > 0)
                        Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return DBManagerFactory.getManager().addStudent(contentValues);
                }
            }.execute();


        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error ", Toast.LENGTH_LONG).show();
        }
    }
}