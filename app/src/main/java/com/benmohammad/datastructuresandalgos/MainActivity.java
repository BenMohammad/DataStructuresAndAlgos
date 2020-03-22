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

        insertionSort(intArray);
        //selectionSort(intArray);
        //bubbleSort(intArray);
        //Log.v(TAG, retrievWithoutIndex(intArray,7));




    }

    private void insertionSort(int[] input) {
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {
            int newElement = input[firstUnsortedIndex];

            int i;
            for(i = firstUnsortedIndex; i > 0 && input[i - 1] > newElement; i--) {
                input[i] = input[i - 1];
            }

            input[i] = newElement;
        }
        for(int i = 0; i < input.length; i++) {
            Log.v(TAG, input[i] + "");
        }
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


    private void selectionSort(int[] input) {
        //O(n²) time complexity

        for(int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for(int i = 1; i <= lastUnsortedIndex; i++) {
                if(input[i] > input[largest]) {
                    largest = i;
                }
            }
            swap(input, largest, lastUnsortedIndex);
        }

        for(int i = 0; i < input.length; i++) {
            Log.v(TAG, input[i] + "");
        }
    }

}
