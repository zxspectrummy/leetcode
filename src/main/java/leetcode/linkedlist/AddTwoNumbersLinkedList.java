package leetcode.linkedlist;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    @Override
    public String toString() {
        return this.val + " "+ getString(this.next);
    }

    private String getString(ListNode node) {
        StringBuilder s = new StringBuilder();
        while (node!=null) {
            s.append(" ").append(node.val);
            node = node.next;
        }
        return s.toString();
    }
}


public class AddTwoNumbersLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode root = sum;
        int shift=0;
        int val1;
        int val2;
        while ((l1!=null) || (l2!=null)) {
            if (l1!=null) {
                val1=l1.val;
                l1=l1.next;
            } else {
                val1 = 0;
            }
            if (l2!=null) {
                val2=l2.val;
                l2=l2.next;
            } else {
                val2=0;
            }
            sum.val=(val1+val2+shift) % 10;
            shift = (val1+val2+shift) / 10;
            if ((l1!=null)||(l2!=null)) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        };
        if (shift!=0) {
            sum.next = new ListNode();
            sum = sum.next;
            sum.val =1;
        }
        return root;
    }

    private static void initList(ListNode node, int[] arr) {
        node.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode();
            node = node.next;
            node.val = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {9,9,9,9,9,9};
        int[] arr2 = new int[] {9,9,9,9};
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        initList(l1,arr1);
        initList(l2,arr2);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
