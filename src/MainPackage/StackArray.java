package MainPackage;

import java.util.NoSuchElementException;

public class StackArray<Type> {
    Type data[]; // array to hold items
    int top; // the top most item index

    public StackArray(int N) {
        data = (Type[]) new Object[N];
        top = -1;
    }

    public void push(Type element) {
        if (isFull()) {
            resize(2 * data.length);
        }
        top++;
        data[top] = element;
    }

    public void resize(int capacity) {
        System.out.println("Resizing stack to " + capacity);

        Type[] tmp = (Type[]) new Object[capacity];

        for (int i = 0; i <= top; i++) {
            tmp[i] = data[i];
        }
        data = tmp;
    }


    public Type pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            top--;
            return data[top + 1];
        }
    }

    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("The content of stack is:");
            for (int i = 0; i <= this.top; i++) {
                if (i == this.top) {
                    System.out.println(data[i].toString());
                } else {
                    System.out.print(data[i].toString() + ", ");
                }
            }
        }
    }

    public void deleteMiddle() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else if ((this.top + 1) % 2 == 1) {

            StackArray<Type> s1 = new StackArray<>(10);

            int constantTop = this.top; //bcs top is decreasing thru the loop, it needs to be constant

            for (int i = constantTop; i > constantTop / 2; i--) {

                s1.push(this.pop());

            }

            this.pop();

            while (!s1.isEmpty()) {
                this.push(s1.pop());
            }

        } else {
            System.out.println("There is no middle element as the size of stack is even.");
        }


    }


    public boolean isPalindrome() {

        if (isEmpty() || top == 0) {
            System.out.println("The stack has only 1 element or doesn't have an element. So,");
            return false;
        }

        StackArray<Type> copySt = new StackArray<Type>(10);

        for (int i = 0; i < this.top + 1; i++) {
            copySt.push(this.data[i]);
        }

        if ((top + 1) % 2 == 1) {   //size = top+1, if the size is odd {
            copySt.deleteMiddle();  //turn odd sized stack array to even sized stack array }
        }                           //as the middle element doesn't matter in palindrome check

        StackArray<Type> s2 = new StackArray<Type>(10);

        int size = copySt.top + 1; //because top is decreasing thru the next loop, it needs to be constant

        for (int i = size; i > size / 2; i--) {
            s2.push(copySt.pop());
        }

        boolean palCheck = true;

        while ((!s2.isEmpty()) || (!copySt.isEmpty())) {

            if (copySt.data[copySt.top].equals(s2.data[s2.top])) { //checking if the top values are the same

                copySt.pop();
                s2.pop();

            } else {
                palCheck = false;
                break;
            }
        }

        return palCheck;

    }

}