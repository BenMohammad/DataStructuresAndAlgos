package com.benmohammad.datastructuresandalgos;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Vector;

public class OtherActivity extends AppCompatActivity {

    private static final String TAG = "D&A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("mike", "Wilson", 3245));

        employeeList.forEach(employee -> Log.v(TAG, employee.getFirstName()));

    }
}
