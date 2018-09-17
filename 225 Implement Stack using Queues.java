class MyStack {
    public Queue<Integer> q1, q2;
    /** Initialize your data structure here. */
    public MyStack() {
         q1 = new LinkedList<Integer>();
         q2 = new LinkedList<Integer>();
    }
    public int move() {
        if (q2.isEmpty()) {
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
        while(q2.size() > 1)
            q1.offer(q2.poll());
        return q2.peek();
    }
    /** Push element x onto stack. */
    public void push(int x) {  
        q2.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        move();
        return q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return move();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/* A more efficient way: q will be treated as a stack to replace its order.
class MyStack {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    public void push(int x) {
        if(q1.isEmpty()) {
            q1.add(x);
            for(int i = 0; i < q2.size(); i ++)
                q1.add(q2.poll());
        }else {
            q2.add(x);
            for(int i = 0; i < q1.size(); i++)
                q2.add(q1.poll());
        }
    }

    public int pop() {
        if(!q1.isEmpty()) 
            return q1.poll();
        else
            return q2.poll();
    }
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
*/