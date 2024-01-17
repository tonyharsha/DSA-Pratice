class MovingAverage {
	//Using the queue datastructure because we need to remove element which is inserted first FIFO.
	Queue<Integer> q;
	int sum;
	int n;
	public MovingAverage(int size) {
		q=new LinkedList<>();
		sum=0;
		n=size;
	}

	public double next(int val) {
		if(q.size()==n){
			sum-=q.peek();
			q.remove();
		}
		q.add(val);
		sum+=val;
		return (double)sum/q.size();
	}
}