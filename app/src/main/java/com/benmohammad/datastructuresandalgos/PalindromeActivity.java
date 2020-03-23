package com.benmohammad.datastructuresandalgos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class PalindromeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?") + "  bug");
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));

    }

    private boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowercase = string.toLowerCase();

        for(int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if(c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedStr = new StringBuilder(stack.size());
        while(!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }

        return reversedStr.toString().equals(stringNoPunctuation.toString());
    }
}
