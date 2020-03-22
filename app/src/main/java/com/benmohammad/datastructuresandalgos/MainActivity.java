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
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        bubbleSort(intArray);


        //Log.v(TAG, retrievWithoutIndex(intArray,7));




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

    public void swap(int[] array, int i, int j) {
        if(i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    private void bubbleSort(int[] input) {
        for(int lastSortedIndex = input.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            for(int i = 0; i < lastSortedIndex; i++) {
                if(input[i] > input[i+1]) {
                    swap(input, i, i + 1);
                }
            }
        }

        for(int i = 0; i < input.length; i++) {
            Log.v(TAG, input[i] + "");
        }

    }

}
