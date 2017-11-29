package com.example.coshri.myapp5778.controller;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.coshri.myapp5778.R;
import com.example.coshri.myapp5778.model.backend.DBManagerFactory;
import com.example.coshri.myapp5778.model.entities.Course;

import java.util.List;

public class CourseListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, ListAdapter>() {
            @Override
            protected ListAdapter doInBackground(Void... params) {
                List<Course> studentList = DBManagerFactory.getManager().getCourses();
                return new ArrayAdapter<Course>(getBaseContext(), R.layout.course_item_view, studentList);
            }

            @Override
            protected void onPostExecute(ListAdapter adapter) {
                setListAdapter(adapter);
            }
        }.execute();

    }
}