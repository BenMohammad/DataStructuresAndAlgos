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

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();
        Log.v(TAG, list.getSize()+ " size of list");

        list.addToEnd(new Employee("Bugzy", "Malone", 888));

        Log.v(TAG, list.getSize()+ "  NEW size of list");
        list.printList();

        list.removeFromFront();
        list.printList();
        Log.v(TAG, list.getSize()+ "  NEW This!!! size of list");
        list.removeFromEnd();
        Log.v(TAG, list.getSize()+ "");





    }
}
