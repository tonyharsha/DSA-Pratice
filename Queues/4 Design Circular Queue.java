class MyCircularQueue {
    int count=0;
    int arr[];
    int rear;
    int front;
    int size;
    public MyCircularQueue(int k) {
        arr=new int[k];
        rear=0;
        front=0;
        size=k;
    }
    
    public boolean enQueue(int value) {
        if(count==size) return false;
        arr[rear%size]=value;
        rear++;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0) return false;
        arr[front%size]=0;
        front++;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0) return -1;
		//IMP
        return arr[(front)%size];
    }
    
    public int Rear() {
        if(count==0) return -1;
		//IMP
        return arr[(rear-1)%size];
    }
    
    public boolean isEmpty() {
        return (count==0)?true:false;
    }
    
    public boolean isFull() {
        return (count==size)?true:false;
    }
}