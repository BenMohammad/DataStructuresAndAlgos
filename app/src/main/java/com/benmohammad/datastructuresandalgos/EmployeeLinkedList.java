package com.benmohammad.datastructuresandalgos;

import android.util.Log;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        EmployeeNode current = head;
        Log.v("D&A", "HEAD ->");
        while(current != null) {
            Log.v("D&A", current.toString());
            Log.v("D&A", "-> " );
            current = current.getNext();
        }
        Log.v("D&A", "Null...");
    }


}
