//Main Thing is think the edge cases first
//like when will deque will become full or empty..
class MyCircularDeque {
    int arr[];
    int size;
    int rear;
    int front;

    public MyCircularDeque(int k) {
        arr=new int[k];
        size=k;
        rear=-1;
        front=-1;
    }
    
    public boolean insertFront(int value) {
        if(front==rear+1 || (front==0 && rear==size-1) ) return false;
        if(front==-1){
            front=0;
            rear=0;
        }
        else if(front==0){
            front=size-1;
        }else{
            front=front-1;
        }
        arr[front]=value;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(front==rear+1 || (front==0 && rear==size-1) ) return false;
        if(rear==-1){
            rear=0;
            front=0;
        }else if(rear==size-1){
            rear=0;
        }else{
            rear=rear+1;
        }
        arr[rear]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(front==-1 && rear==-1) return false;
        arr[front]=-1;
        if(front==rear){
            front=-1;
            rear=-1;
        }else if(front==size-1){
            front=0;
        }else{
            front=front+1;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(front==-1 && rear==-1) return false;
        arr[rear]=-1;
        if(front==rear){
            front=-1;
            rear=-1;
        }else if(rear==0){
            rear=size-1;
        }else{
            rear=rear-1;
        } 
        return true;
    }
    
    public int getFront() {
        return (front==-1)?front:arr[front];
    }
    
    public int getRear() {
        return (rear==-1)?rear:arr[rear];
    }
    
    public boolean isEmpty() {
        return (front==-1 && rear==-1)?true:false;
    }
    
    public boolean isFull() {
        return (front==rear+1 || (front==0 && rear==size-1))?true:false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
 
 
