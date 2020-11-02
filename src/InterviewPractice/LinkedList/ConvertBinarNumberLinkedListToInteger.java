package InterviewPractice.LinkedList;


public class ConvertBinarNumberLinkedListToInteger {

    public static int getDecimalValue(Node head) {
        String number = "";
        Node temp = head;

        while(temp != null){
            number = number + temp.val;
            temp = temp.next;
        }

        return binaryToInteger(number);
    }

    public static int binaryToInteger(String number){
        int result = 0;
        int size = number.length();
        int count = 0;
        for(int i= size-1;i>=0;i--){
         result = result + (Character.getNumericValue(number.charAt(i))* (int) Math.pow(2,count++));
        }
        return result;
    }

    /*

    Approach 1: num = num * 2 + x
    Approach 2: num = (num << 1) | x

      public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }
     */


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(0);
        first.next.next = new Node(1);
        first.next.next.next = new Node(0);
        System.out.println(getDecimalValue(first));
    }


}
