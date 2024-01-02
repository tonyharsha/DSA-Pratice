/*
// This will take lot of space and doesn't handle collision.
class MyHashSet {
    int arr[];


    public MyHashSet() {
        arr=new int[1000000+1];
    }
    
    public void add(int key) {
        arr[key]=1;
    }
    
    public void remove(int key) {
        arr[key]=0;
    }
    
    public boolean contains(int key) {
        if(arr[key]==1) return true;
        return false;
    }
}
*/

//Using Linked List arrays to handle the colision.
class MyHashSet {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }

    Node set[];

    public MyHashSet() {
        set=new Node[999];
    }

    public int hash(int num){
        return num%987;
    }
    

    public void add(int key) {
        int index=hash(key);
        Node newNode=new Node(key);
        if(set[index]==null){
            set[index]=newNode;
        }else{
            Node temp=set[index];
            //check for first element
            if(temp.val==key){
                return;
            }
            while(temp.next!=null){
                //extra OR statement added so that last element will not get missed.
                if(temp.val==key || temp.next.val==key) return;
                temp=temp.next;
            }
            //Insertion of new Node.
            temp.next=newNode;
        }
    }
    
    public void remove(int key) {
        int index=hash(key);
        Node temp=set[index];
        if(temp!=null && temp.val==key){
            set[index]=temp.next;
            return;
        }

        Node Curr = (temp != null) ? temp.next : null;
        Node prev = temp;
        while(Curr!=null){
            if(Curr.val==key){
                prev.next=Curr.next;
                return;
            }
            prev=Curr;
            Curr=Curr.next;
        }
        
    }
    
    
    public boolean contains(int key) {
        int index=hash(key);

        Node temp=set[index];

        while(temp!=null){
            if(temp.val==key) return true;
            temp=temp.next;
        }

        return false;
        
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */