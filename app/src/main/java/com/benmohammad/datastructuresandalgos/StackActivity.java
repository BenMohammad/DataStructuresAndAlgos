package com.benmohammad.datastructuresandalgos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayStack stack = new ArrayStack(5);
        stack.push(new Employee("Ben ", "Mohammad", 23));
        stack.push(new Employee("Ted ", "jill", 99));
        stack.push(new Employee("Dillon ", "sid", 88));


        stack.pop();
        stack.pop();
        stack.printSTack();
    }
}
