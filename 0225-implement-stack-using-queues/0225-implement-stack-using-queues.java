class MyStack {
    private Queue<Integer> Q;
    public MyStack() {
        Q = new LinkedList<>();
    }
    
    public void push(int x) {
        Q.add(x);
        int size = Q.size();
        for (int i = 0; i < size - 1; i++) {
        Q.add(Q.poll());
        }
    }
    
    public int pop() {
        if (Q.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return Q.poll();
    }
    
    public int top() {
        if (Q.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return Q.peek();
    }
    
    public boolean empty() {
        return Q.isEmpty();
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