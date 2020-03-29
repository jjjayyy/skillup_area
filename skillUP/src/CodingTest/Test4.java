package CodingTest;

import java.io.BufferedWriter;
import java.io.IOException;

public class Test4 {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head_ref, SinglyLinkedListNode del)
    {
        SinglyLinkedListNode temp = head_ref;

        // If node to be deleted is head node
        if (head_ref.data == del.data)
        {
            head_ref = del.next;
        }

        // traverse list till not found
        // delete node
        while (temp.next.data != del.data)
        {
            temp = temp.next;
        }

        // copy address of node
        temp.next = del.next;
        return head_ref;
    }

    public static SinglyLinkedListNode deleteOdd(SinglyLinkedListNode listHead) {
        // Write your code here

        SinglyLinkedListNode temp = listHead;
        SinglyLinkedListNode deleteNode = listHead;


        while(deleteNode.next != null) {

            if(deleteNode.data % 2 == 1) {

                if (temp.data == deleteNode.data) {
                    temp = deleteNode.next;
                }

                while (temp.next.data != deleteNode.data) {
                    temp = temp.next;
                }

                temp.next = deleteNode.next;
            }

            deleteNode = deleteNode.next;
        }

//        while(listHead.next != null) {
//            isNextStep = false;
//
//            if(listHead.data % 2 == 1) {
//                listHead = listHead.next;
//                isNextStep = true;
//            }
//
//            if(!isNextStep) {
//                listHead = listHead.next;
//            }
//        }
        return listHead;
    }

    public static void main(String[] args) {

        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertNode(2);
        sl.insertNode(1);
        sl.insertNode(2);
        sl.insertNode(3);
        sl.insertNode(4);

        deleteOdd(sl.head);

        System.out.println(sl);


    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
