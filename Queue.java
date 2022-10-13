public class Queue<E> {

    public Node head, tail; //declare head and tail nodes

    public Queue() { //public constructor creates empty queue
        head = null;
        tail = null;
    }

    public void Enqueue(Object input) { //method adds node to end of list
        Node temp = new Node(input); //create temp node for insertion
        if (tail == null) { //if empty list
            head = temp; //set head and tail to new node
            tail = temp;
        } else if (tail == head) { // if one item in list
            tail = temp; //set tail to node and head pointer to tail
            head.next = tail;
        } else { //otherwise
            tail.next = temp; //set current tail pointer and set tail to node
            tail = temp;
        }
    }

    public E Dequeue() { //return next value and remove it from list
        Node temp = head; //create temp node for reference
        if (temp == null) { //if empty
            return null;
        } else if (temp == tail) { // if one item
            head = null; //set head and tail to null and return temp
            tail = null;
            return temp.data;
        }
        else{ //otherwise return temp data and set head to pointer
            head = temp.next;
            return temp.data;
        }
    }

    public E Front(){ //return front value without removing
        return head.data;
    }

    public int Size(){ //count the size of the queue
        int count = 0; //initialize count
        Node temp = head; //initialize reference node
        boolean stop = false; //initialize loop condition
        while (!stop){ //loop on !stop
            if (temp == null) stop = true; //if empty node stop counting
            else { //else increase count and move to next node
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    public boolean IsEmpty(){ //if empty return true, otherwise return false
        if (head == null) return true;
        else return false;
    }

    public String PrintList(Node temp){ //print list contents
        if (tail == null) return "Empty"; //if empty send empty
        else if (temp == tail) return tail.toString(); //if last node end recursion
        else return (temp.toString() + ", " + PrintList(temp.next)); //recursive print of current node
    }

    public String PrintList(Node temp, int amount){
        if (tail == null) return "Empty";
        else {
            String answer = "";
            for (int a = 0; a < amount; a++){
                if (temp == tail) answer += temp.toString();
                else answer += temp.toString() + ", ";
                temp = temp.next;
            }
            return answer;
        }

    }


    private class Node { //create node class
        E data; //data is of declared type
        Node next; //next is pointer

        public Node(Object value) { //constructor takes any object
            data = (E) value; //converts input to declared type and stores it
            next = null; //next is empty until specified
        }

        @Override //override toString to output the data
        public String toString() { //override toString to the data
            return data.toString();
        }
    }
}