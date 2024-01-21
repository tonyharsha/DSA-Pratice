class HitCounter {
	Deque<Integer> q;
	public HitCounter() {
		q=new LinkedList<>();
	}

	public void hit(int timestamp) {
		// Your code goes here
		q.offer(timestamp);
	}

	public int getHits(int timestamp) {
		while(!q.isEmpty()){
		    // Here in code i am using +1 because timestamp starts from 1 not from zero.
			if(timestamp-q.getFirst()+1>300){
				q.pop();
			}else{
				break;
			}
		}
		return q.size();
	}
}