//TC O(K)
//SC O(N)
class ProductOfNumbers {
    ArrayList<Integer> res;

    public ProductOfNumbers() {
        res=new ArrayList<>();
    }
    
    public void add(int num) {
        res.add(num);
    }
    
    public int getProduct(int k) {
        int size = res.size();
        int n = size - k;
        int ans=1; 
        while(n<size){
            ans*=res.get(n);
            n++;
        }
        return ans;
        
    }
}


//TC O(1)
//SC O(N)
class ProductOfNumbers {
    //The Main logic is to maintain the prefix product.
    //The only thing to handle is if num is zero.
    //In that case start new arraylist.

    //The main logic to get the product of last k numbers is division.
    //res.get(n-1)/res.get(n-k-1)

    ArrayList<Integer> res;

    public ProductOfNumbers() {
        res=new ArrayList<>();
        res.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            res.clear();
            res.add(1);
        }else{
            res.add(res.get(res.size()-1)*num);
        }
        
    }
    
    public int getProduct(int k) {
        int n=res.size();
        if(n-k-1<0) return 0;
        return res.get(n-1)/res.get(n-k-1);
    }
}




/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */