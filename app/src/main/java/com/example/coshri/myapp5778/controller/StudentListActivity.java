package com.example.coshri.myapp5778.controller;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.example.coshri.myapp5778.R;
import com.example.coshri.myapp5778.model.backend.DBManagerFactory;
import com.example.coshri.myapp5778.model.entities.Student;


import java.util.List;

public class StudentListActivity extends ListActivity {

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


new AsyncTask<Void, Void, ListAdapter>() {
    @Override
    protected ListAdapter doInBackground(Void... params) {
        List<Student> studentList = DBManagerFactory.getManager().getStudents();
        return new ArrayAdapter<Student>(getBaseContext(), R.layout.student_item_view, studentList);
    }

    @Override
    protected void onPostExecute(ListAdapter adapter) {
        setListAdapter(adapter);
    }
}.execute();


    }
}
