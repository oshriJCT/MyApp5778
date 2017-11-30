package com.example.coshri.myapp5778.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coshri.myapp5778.R;
import com.example.coshri.myapp5778.controller.custom_view.CustomDatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddStudentCourseActivity extends Activity implements View.OnClickListener {

    private CustomDatePicker regDateCustomDatePicker;
    private Spinner studentIdSpinner;
    private Spinner courseIdSpinner;
    private Button addCourseStudentButton;
    private TextView loadingTextView;
    private ListView ItemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_course);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == addCourseStudentButton) {
            addStudentCourse();
        }
    }


    private void findViews() {
        regDateCustomDatePicker = (CustomDatePicker) findViewById(R.id.regDateCustomDatePicker);
        studentIdSpinner = (Spinner) findViewById(R.id.studentIdSpinner);
        courseIdSpinner = (Spinner) findViewById(R.id.courseIdSpinner);
        addCourseStudentButton = (Button) findViewById(R.id.addCourseStudentButton);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);
        ItemListView = (ListView) findViewById(R.id.ItemListView);

        addCourseStudentButton.setOnClickListener(this);


//        new AsyncTask<Void, Void, Cursor>() {
//            @Override
//            protected Cursor doInBackground(Void... params) {
//                return getContentResolver().query(AcademyContract.Student.STUDENT_URI, null, null, null, null);
//            }
//
//            @Override
//            protected void onPostExecute(Cursor cursor) {
//                super.onPostExecute(cursor);
//                CursorAdapter adapter = new CursorAdapter(AddStudentCourseActivity.this, cursor) {
//                    @Override
//                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//                        TextView tv = new TextView(context);
//                        tv.setTextSize(15);
//                        tv.setTextColor(Color.BLUE);
//                        return tv;
//                    }
//
//                    @Override
//                    public void bindView(View view, Context context, Cursor cursor) {
//                        TextView tv = (TextView) view;
//                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
//                    }
//                };
//
//                studentIdSpinner.setAdapter(adapter);
//                studentIdSpinner.setEnabled(true);
//            }
//        }.execute();


//        new AsyncTask<Void, Void, Cursor>() {
//            @Override
//            protected Cursor doInBackground(Void... params) {
//                return getContentResolver().query(AcademyContract.Course.COURSE_URI, null, null, null, null);
//                // return null;
//            }
//
//            @Override
//            protected void onPostExecute(Cursor cursor) {
//                super.onPostExecute(cursor);
//                CursorAdapter adapter = new CursorAdapter(AddStudentCourseActivity.this, cursor) {
//                    @Override
//                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//                        TextView tv = new TextView(context);
//                        tv.setTextSize(15);
//                        tv.setTextColor(Color.BLUE);
//                        return tv;
//                    }
//
//                    @Override
//                    public void bindView(View view, Context context, Cursor cursor) {
//                        TextView tv = (TextView) view;
//                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
//
//                    }
//
//
//                };
//
//                courseIdSpinner.setAdapter(adapter);
//                courseIdSpinner.setEnabled(true);
//            }
//        }.execute();


    }

    private void addStudentCourse() {

//        final Uri uri = AcademyContract.StudentCourse.STUDENT_COURSE_URI;
//        final ContentValues contentValues = new ContentValues();
//
//        long studentId = ((Cursor) this.studentIdSpinner.getSelectedItem()).getLong(0);
//        contentValues.put(AcademyContract.StudentCourse.STUDENT_ID, studentId);
//
//        long courseId = ((Cursor) this.courseIdSpinner.getSelectedItem()).getLong(0);
//        contentValues.put(AcademyContract.StudentCourse.COURSE_ID, courseId);
//
//        Date regDate = regDateCustomDatePicker.getDate();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // like MySQL Format
//        String dateString = dateFormat.format(regDate);
//        contentValues.put(AcademyContract.StudentCourse.REG_DATE, dateString);
//
//        new AsyncTask<Void, Void, Long>() {
//            @Override
//            protected Long doInBackground(Void... params) {
//              return   DBManagerFactory.getManager().addStudentCourse(contentValues);
//               // return null;
//            }
//
//            @Override
//            protected void onPostExecute(Long longResult) {
//                super.onPostExecute(longResult);
//
//                long id = longResult;
//                if (id > 0)
//                    Toast.makeText(getBaseContext(), "insert id: " + id, Toast.LENGTH_LONG).show();
//
//                updateItemList(uri);
//            }
//        }.execute();
    }

    private void updateItemList(final Uri uri) {

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                ItemListView.setVisibility(View.INVISIBLE);
                loadingTextView.setVisibility(View.VISIBLE);
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                return getContentResolver().query(uri, null, null, null, null);
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                CursorAdapter adapter = new CursorAdapter(AddStudentCourseActivity.this, cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        TextView tv = new TextView(context);
                        return tv;
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                    }
                };

                ItemListView.setAdapter(adapter);
                ItemListView.setVisibility(View.VISIBLE);
                loadingTextView.setVisibility(View.INVISIBLE);
            }
        }.execute();
    }
}
