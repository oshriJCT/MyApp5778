package com.example.coshri.myapp5778.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coshri.myapp5778.R;

public class MainActivity extends Activity  implements View.OnClickListener {

    private Button addStudentButton;
    private Button addLecturerButton;
    private Button addCourseButton;
    private Button addStudentCourseButton;
    private Button showStudentListButton;
    private Button showCourseListButton;

    private void findViews() {
        addStudentButton = (Button) findViewById(R.id.addStudentButton);
        addLecturerButton = (Button) findViewById(R.id.addLecturerButton);
        addCourseButton = (Button) findViewById(R.id.addCourseButton);
        addStudentCourseButton = (Button) findViewById(R.id.addStudentCourseButton);
        showStudentListButton = (Button) findViewById(R.id.showStudentListButton);
        showCourseListButton = (Button) findViewById(R.id.showCourseListButton);

        addStudentButton.setOnClickListener(this);
        addLecturerButton.setOnClickListener(this);
        addCourseButton.setOnClickListener(this);
        addStudentCourseButton.setOnClickListener(this);
        showStudentListButton.setOnClickListener(this);
        showCourseListButton.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void addStudent() {
        Intent intent = new Intent(this,AddStudentActivity.class);
        startActivity(intent);
    }
private void addLecturer() {
    Intent intent = new Intent(this,AddLecturerActivity.class);
    startActivity(intent);
}
    private void addCourse() {

    }
    private void addStudentCourse() {

    }
    private void showStudentLis() {
        Intent intent = new Intent(this,StudentListActivity.class);
        startActivity(intent);
    }
    private void showCourseList() {

    }

    @Override
    public void onClick(View v) {
        if (v == addStudentButton) {
            addStudent(); // Handle clicks for addStudentButton
        } else if (v == addLecturerButton) {
            addLecturer(); // Handle clicks for addLecturerButton
        } else if (v == addCourseButton) {
            addCourse();// Handle clicks for addCourseButton
        } else if (v == addStudentCourseButton) {
            addStudentCourse(); // Handle clicks for addStudentCourseButton
        } else if (v == showStudentListButton) {
            showStudentLis();// Handle clicks for showStudentListButton
        } else if (v == showCourseListButton) {
            showCourseList();// Handle clicks for showCourseListButton
        }
    }
}