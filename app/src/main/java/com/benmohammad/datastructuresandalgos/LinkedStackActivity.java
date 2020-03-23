package com.benmohammad.datastructuresandalgos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LinkedStackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Employee janeJones = new Employee("Jane", "Jones", 1234);
        Employee tomGreen = new Employee("Tom", "Green", 2345);
        Employee mikeWilson = new Employee("Mike", "Wilson", 7899);
        Employee billyBlue = new Employee("Billy", "Blue", 634);
        Employee marySmith = new Employee("Mary", "Smith", 4684);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(tomGreen);
        stack.push(mikeWilson);
        stack.push(billyBlue);
        stack.push(marySmith);

        stack.pop();
        stack.pop();
        stack.printStack();

    }
}
