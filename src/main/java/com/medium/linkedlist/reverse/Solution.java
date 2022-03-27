package com.medium.linkedlist.reverse;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        Node start = createList(arr);
        Node print = start;
        while(print != null){
            System.out.println(print.val);
            print = print.next;
        }
        Node reverseList = reverse(start);
        while(reverseList != null){
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }
    }
//1->2->3->4
// 1->null;
    private static Node reverse(Node list) {

        Node head = null;
        Node c = list;
      while(c != null){
          if(head == null) {
              Node temp = new Node();
              temp.val = c.val;
              head = temp;
          } else{
              Node temp = new Node();
              temp.val = c.val;
              temp.next=head;
              head = temp;
          }
c=c.next;

      }
return head;

       // return list;
    }
// start|1 -> Node|2
// current(start|1)
    private static Node createList(int[] arr) {
        Node start = null;
        Node current = null;
        for(int i=0;i<arr.length;i++){
            if(current == null){
                Node temp = new Node();
                temp.val=arr[i];
                current = temp;
                start=temp; //1
            } else{
                Node temp = new Node();
                temp.val=arr[i]; //2
                current.next = temp;
                current=temp;
            }
        }
        return start;
    }
}
class Node{
    Node next;
    int val;

}