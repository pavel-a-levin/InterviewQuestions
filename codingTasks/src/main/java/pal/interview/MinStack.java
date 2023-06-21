package pal.interview;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


//    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        Implement the MinStack class:
//
//        MinStack() initializes the stack object.
//        void push(int val) pushes the element val onto the stack.
//        void pop() removes the element on the top of the stack.
//        int top() gets the top element of the stack.
//        int getMin() retrieves the minimum element in the stack.
//        You must implement a solution with O(1) time complexity for each function.
class MinStack {

    static class Node {
        Integer val;
        Integer min;
        Node next;

        public Node(Integer val, Integer min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node head;

    public void push(int val) {
        Node newNode = new Node(val, val);
        if (head != null) {
            newNode.min = Math.min(head.min, val);
        }
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}