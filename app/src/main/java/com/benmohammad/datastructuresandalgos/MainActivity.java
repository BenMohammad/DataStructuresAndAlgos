package com.benmohammad.datastructuresandalgos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "D&A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        //Arrays.parallelSort(intArray);

        mergeSort(intArray, 0, intArray.length);

        for(int i = 0; i < intArray.length; i++) {
            Log.v(TAG, intArray[i] + "");
        }


        //int[] intArray = {2,5,9,8,2,8, 7, 10, 4, 3};

//        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};
//
//
//        radixSort(radixArray, 10, 4);
//
        //quickSort(intArray, 0, intArray.length);

        //countingSort(intArray, 1, 10);

//        for(int i = 0; i< intArray.length; i++) {
//            Log.v(TAG, intArray[i]+ "");
//        }

        //Log.v(TAG, iterativeFactorial(3) + "");
        //Log.v(TAG, recursiveFactorial(3) + "");

        //shellSort(intArray);
        //insertionSort(intArray);
        //selectionSort(intArray);
        //bubbleSort(intArray);
        //Log.v(TAG, retrievWithoutIndex(intArray,7));




    }

    private void radixSort(int[] input, int radix, int width) {
        for(int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }


    }


    private void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value : input) {

            countArray[getDigit(position, value, radix)]++;

        }

        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }


    }

    private int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    private void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for(int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++) {
            while(countArray[i - min]> 0) {
                input[j++] = i;
                countArray[i - min]--;
            }

        }
    }

    private void quickSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);

    }

    private int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while(i < j) {

            while(i < j && input[--j] >= pivot);
            if(i < j) {
                input[i] = input[j];
            }

            while(i < j && input[++i] <= pivot);
            if(i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }

    private void mergeSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);

    }

    private void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] > input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private void shellSort(int[] input) {
        for(int gap = input.length / 2; gap > 0; gap /= 2) {

            for(int i = gap; i < input.length; i++) {
                int newElement = input[i];

                int j = i;
                while(j >= gap && input[j - gap] > newElement) {
                    input[j] = input[j - gap];
                    j -= gap;
                }

                input[j] = newElement;
            }

        }
        for(int i = 0; i < input.length; i++) {
            Log.v(TAG, input[i]+ "");
        }
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

    public int recursiveFactorial(int num) {
        if(num == 0) {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    public int iterativeFactorial(int num) {
        if(num == 0) {
            return 1;
        }

        int factorial = 1;
        for(int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

}
