package com.benmohammad.datastructuresandalgos;

import android.util.Log;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if(head == null) {
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        size++;

    }

    public EmployeeNode removeFromEnd() {
        if(isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if(tail.getPrev() == null) {
            head = null;
        } else {
            tail.getPrev().setNext(null);
        }

        tail = tail.getPrev();
        size--;
        removedNode.setPrev(null);
        return removedNode;
    }

    public EmployeeNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        if(head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrev(null);
        }

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
            Log.v("D&A", "<=> " );
            current = current.getNext();
        }
        Log.v("D&A", "Null...");
    }

}
