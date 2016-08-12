package sample;

import javax.xml.soap.Node;

/**
 * Created by Spencer on 11/23/2015.
 */
public class ResponseBuffer {

    private int size;//capacity size for list so basically the max size we want the list
    private int count;//keeps track of size of list
    private Node head;
    private Node tail;

    /**
     * inner class to create node for linkedlist
     *
     */
    class Node{
        private char data;
        private Node next;
        public Node(char flip, Node next){
            data = flip;
            this.next = next;
        }

    }

    /**
     * constructor that sets the size for the list and sets head and tail to null
     * head represents beggining of list while tail represents the last item in the list
     * @param size
     */
        public ResponseBuffer(int size){
            this.size = size;
            count = 0;
            head=null;
            tail=null;
        }

    /**
     * Inserts data into linked list, basic add method that uses tail and head to make navigation more efficient
     */
        public void insert(char c) {


            if (head == null) {
                head = new Node(c, null);
                tail = head;


            } else {

                tail.next = new Node(c, null);
                tail = tail.next;

            }

            count++;

            if(count>size){//if at maximum capacity then chops off oldest guess
                head = head.next;
                count--;
            }
        }

    /**
     * basic toString for the linked list that holds the last four guesses
     * this string is used as key in HashMap
     * @return
     */
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Node ref = head;
            if(head == null){
                return "";
            }else {
                while (ref != null) {
                    sb.append(ref.data);
                    ref=ref.next;
                }
                return sb.toString().toUpperCase();
            }
        }


}
