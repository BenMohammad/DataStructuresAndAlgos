package com.benmohammad.datastructuresandalgos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "D&A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;


        Log.v(TAG, retrievWithoutIndex(intArray,7));



    }

    private String retrievWithoutIndex(int[] input,int value) {
        //O(1) Time complexity with index for retrieval
        //O(n) Time complexity without index
        int index = -1;
        for(int i =0; i < input.length; i++) {
            if(input[i] == value) {
                index = i;
                break;
            }
        }
        return index + " is the index";

    }
}
