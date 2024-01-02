class MyHashMap {
 //same logic used for hash set only change in structure of Node
    class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            this.next=null;
        }
    }

    Node HashMap[];
    public MyHashMap() {
        HashMap=new Node[987];
    }

    public int hash(int num){
        return num%987;
    }
    
    public void put(int key, int value) {
        int index=hash(key);

        Node newNode=new Node(key,value);
        if(HashMap[index]==null){
            HashMap[index]=newNode;
        }else{
            Node temp=HashMap[index];
            if(temp.key==key){
                temp.val=value;
                return;
            }
            while(temp.next!=null){
                if(temp.key==key){
                    temp.val=value;
                    return;
                }

                if(temp.next.key==key){
                    temp.next.val=value;
                    return;
                }
                temp=temp.next;

            }

            temp.next=newNode;
        }
    }
    
    public int get(int key) {
        int index=hash(key);
        Node temp=HashMap[index];
        while(temp!=null){
            if(temp.key==key) return temp.val;
            temp=temp.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int index=hash(key);
        Node temp=HashMap[index];
        if(temp!=null && temp.key==key){
            HashMap[index]=temp.next;
        }

        Node prev=temp;
        Node Curr=(temp!=null)?temp.next:null;
        while(Curr!=null){
            if(Curr.key==key){
                prev.next=Curr.next;
                return;
            }
            prev=Curr;
            Curr=Curr.next;
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */