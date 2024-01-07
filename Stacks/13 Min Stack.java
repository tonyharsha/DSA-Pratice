class MinStack {
    class pair{
        int num;
        int min;
        public pair(int num,int min){
            this.num=num;
            this.min=min;
        }

        public int getmin(){
            return this.min;
        }

        public int getnum(){
            return this.num;
        }
    }

    ArrayList<pair> arr;
    int minimum;
    int top;

    public MinStack() {
        arr=new ArrayList<>();
        minimum=Integer.MAX_VALUE;
        top=-1;
    }
    
    public void push(int val) {
        minimum=Math.min(minimum,val);
        pair p=new pair(val,minimum);
        arr.add(p);
        top++;
    }
    
    public void pop() {
        arr.remove(top);
        top--;
        //This IF ELSE is very imp we need to track the min value 
        //if top is -1 then we need to fix to MAX_VALUE
        //else the previous min value.
        if(top==-1){
            minimum=Integer.MAX_VALUE;
        }else{
            minimum=arr.get(top).getmin();
        }
    }
    
    public int top() {
        return arr.get(top).getnum();
    }
    
    public int getMin() {
        return arr.get(top).getmin();
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