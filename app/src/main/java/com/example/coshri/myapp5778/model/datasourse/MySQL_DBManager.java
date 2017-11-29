package com.example.coshri.myapp5778.model.datasourse;

import android.content.ContentValues;

import android.util.Log;

import com.example.coshri.myapp5778.model.backend.AcademyConst;
import com.example.coshri.myapp5778.model.backend.DB_manager;
import com.example.coshri.myapp5778.model.entities.Course;
import com.example.coshri.myapp5778.model.entities.Lecturer;
import com.example.coshri.myapp5778.model.entities.Student;

import org.json.JSONArray;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mailo on 15/12/2016.
 */

public class MySQL_DBManager implements DB_manager {

    private final String UserName="oshric";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/Academy/";         //   " שם ה URI שלך";  // "https://oshric.vlab.jct.ac.il/";


    private boolean updateFlag = false;


    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }
    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }

@Override
public long addStudent(ContentValues values) {
    try {
        String result = PHPtools.POST(WEB_URL + "/addStudent.php", values);
        long id = Long.parseLong(result);
        if (id > 0)
            SetUpdate();
        printLog("addStudent:\n" + result);
        return id;
    } catch (IOException e) {
        printLog("addStudent Exception:\n" + e);
        return -1;
    }
}

    @Override
    public long addLecturer(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addLecturer.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addLecturer:\n" +result);
            return id;
        } catch (IOException e) {
            printLog("addLecturer:\n" +e);
        }
        return -1;
    }

    @Override
    public long addCourse(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addCourse.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCourse:\n" +result);
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


@Override
public List<Student> getStudents() {
    List<Student> result = new ArrayList<Student>();

    try {

        String str = PHPtools.GET(WEB_URL + "/students.php");
        JSONArray array = new JSONObject(str).getJSONArray("students");


        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);

//            Student student = new Student();
//            student.setId(jsonObject.getInt("_id"));
//            student.setName(jsonObject.getString("name"));
//            student.setPhone(jsonObject.getString("phone"));
//            student.setYear(Year.valueOf(jsonObject.getString("year")));

            ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
            Student student = AcademyConst.ContentValuesToStudent(contentValues);
            result.add(student);
        }
        return result;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    @Override
    public List<Lecturer> getLecturers() {
        List<Lecturer> result = new ArrayList<Lecturer>();

        try {

        String str = PHPtools.GET(WEB_URL + "/lecturers.php");
        JSONArray array = new JSONObject(str).getJSONArray("lecturers");


        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);

            ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
            Lecturer lecturer = AcademyConst.ContentValuesToLecturer(contentValues);
            result.add(lecturer);
        }
        return result;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}



    @Override
    public List<Course> getCourses() {
        List<Course> result = new ArrayList<Course>();

        try {

            String str = PHPtools.GET(WEB_URL + "/courses.php");
            JSONArray array = new JSONObject(str).getJSONArray("courses");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Course course = AcademyConst.ContentValuesToCourse(contentValues);
                result.add(course);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeStudent(long id) {
        return false;
    }

    @Override
    public boolean removeCourse(long id) {
        return false;
    }

    @Override
    public boolean removeLecturer(long id) {
        return false;
    }


    @Override
    public boolean updateLecturer(long id, ContentValues values) {
        return false;
    }

    @Override
    public long addStudentCourse(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addStudentCourse.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addStudentCourse:\n" +result);
            return id;
        } catch (IOException e) {
            printLog("addStudentCourse:\n" +e);
        }
        return -1;
    }

    @Override
    public boolean updateStudent(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateCourse(long id, ContentValues values) {
        return false;
    }


    private void SetUpdate()
    {
        updateFlag = true;
    }




}