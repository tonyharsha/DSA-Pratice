//TC increment operation is O(K)
//SC O(N)
class CustomStack {
    int arr[];
    int top=-1;
    int size;

    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        size=maxSize;
    }
    
    public void push(int x) {
        if(top<size-1)
          arr[++top]=x;
    }
    
    public int pop() {
        if(top>-1){
            return arr[top--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int n=Math.min(k,size);
        for(int i=0;i<n;i++){
            arr[i]=arr[i]+val;
        }
    }
}


//TC for increment operation is O(1)
//SC O(2N)
// Still not the current ans need to work on it.
class CustomStack {
    int arr[];
    int incr[];
    int n;
    int top=-1;

    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        incr=new int[maxSize];
        n=maxSize;
    }
    
    public void push(int x) {
        if(top<n-1){
            arr[++top]=x;
        }
    }
    
    public int pop() {
        if(top>0){
            incr[top-1]+=incr[top];
            int res=arr[top]+incr[top];
            top--;
            return res;
        }else if(top==0){
            top--;
            return arr[top+1]+incr[top+1];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
       int index=Math.min(k-1,top);
       if(index>=0)
        incr[index]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */