/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penilaian_mahasiswa;

class Stack {
    private int maxSize;
    private Penilaian[] stackArray;
    private int top;
    
    public Stack(int max) {
        maxSize = max;
        stackArray = new Penilaian[max];
        top = -1;
    }
    
    public void push(Penilaian item) {
        stackArray[++top] = item;
    }
    
    public Penilaian pop() {
        return stackArray[top--];
    }
    
    public Penilaian peek() {
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

