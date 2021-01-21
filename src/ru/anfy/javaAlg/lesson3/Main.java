package ru.anfy.javaAlg.lesson3;

public class Main {

    //Стек(скопировано)
    private static class Stack {
        private char[] stack;
        private int head;

        public Stack(int size) {
            this.stack = new char[size];
            this.head = -1;
        }

        public boolean isEmpty() {
            return head == -1;
        }

        public boolean isFull() {
            return head == stack.length - 1;
        }

        public boolean push(char i) {
            if (isFull()) return false;
            stack[++head] = i;
            return true;
        }

        public char pop() throws RuntimeException {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head--];
        }

        public char peek() throws RuntimeException {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head];
        }

    }

    //Очередь(скопировано)
    private static class Queue {
        protected int[] queue;
        protected int head;
        protected int tail;
        protected int capacity;

        public Queue(int initial) {
            queue = new int[initial];
            head = 0;
            tail = -1;
            capacity = 0;
        }

        public boolean isEmpty() {
            return capacity == 0;
        }

        public boolean isFull() {
            return capacity == queue.length;
        }

        public int length() {
            return capacity;
        }

        public void insert(int i) {
            if (isFull())
                throw new RuntimeException("Queue is full!");
            if (tail == queue.length - 1)
                tail = -1;
            queue[++tail] = i;
            capacity++;
        }

        public int remove() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            int temp = queue[head++];
            head %= queue.length; //if (head == queue.length) head = 0;
            capacity--;
            return temp;
        }

    }

    //Дек (не отлажилвал)
    private static class Deque extends Queue {

        public Deque(int initial) {
            super(initial);
        }

        public void insertRight(int i) {
            insert(i);
        }

        public void removeLeft() {
            remove();
        }

        public void insertLeft(int i) {
            if (isFull())
                throw new RuntimeException("Queue is full!");
            if (tail == 0)
                tail = queue.length;
            queue[--tail] = i;
            capacity++;
        }

        public int removeRight() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            int temp = queue[tail--];
            if (tail == 0) head = queue.length;
            capacity--;
            return temp;
        }
    }

    //Приоритетная очередь (не отлажилвал)
    private static class PriorityQueue extends Queue {

        public PriorityQueue(int initial) {
            super(initial);
        }

        public void insert(int item) {
            if (isFull())
                throw new RuntimeException("Queue is full!");
            if(isEmpty()){
                super.insert(item);
                return;
            }

            int pointer = head;
            int i = 0;
            for (; i < capacity && queue[pointer] < item; i++, pointer++) {
                if(pointer == queue.length) pointer = 0;
            }

            if(i == capacity){
                super.insert(item);
                return;
            }

            if(tail < head){
                System.arraycopy(queue, 0, queue, 1, tail);
                queue[0] = queue[queue.length-1];
            }
            System.arraycopy(queue, pointer, queue, pointer+1, queue.length - pointer - 1);

            queue[pointer] = item;
            capacity++;
        }

    }

    public static String reverse(String src){

        char[] dst = new char[src.length()];
        Stack stack = new Stack(src.length());

        for (int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));
        }

        for (int i = 0; i < src.length(); i++) {
            dst[i] = stack.pop();
        }

        return new String(dst);
    }

    public static void main(String[] args) {

        //Перевернём строку
        String str1 = "Это строка должна быть перевёрнута";
        String str2 = reverse(str1);
        System.out.println(str2);

    }
}
