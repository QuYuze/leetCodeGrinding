package Playground;

import java.util.Stack;

public class MinStack {


        Stack<Node> stack = new Stack<>();
        int min = 0;

        class Node {
            int val;
            int preMin;

            public Node(int val, int preMin) {
                this.val = val;
                this.preMin = preMin;
            }

        }

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                Node node = new Node(val, val);
                min = val;
                stack.push(node);
            } else {
                Node node = new Node(val, min);
                if (min > val) {
                    min = val;
                }
                stack.push(node);
            }

        }

        public void pop() {
            Node node = stack.pop();
            if (node.val == min) {
                min = node.preMin;
            }
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

