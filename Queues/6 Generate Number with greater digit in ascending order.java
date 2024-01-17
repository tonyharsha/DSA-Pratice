//Refer the Notes section of queue.
public void GenerateN (int n){
	Queue<String> q=new LinkedList<>();
	q.add("5");
	q.add("6");
	
	for(int i=0;i<n;i++){
		String temp=q.remove();
		System.out.print(temp+" ");
		q.offer(temp+"5");
		q.offer(temp+"6");
	}
	
	
}

eg: 56 n=8

5 6 55 56 65 66 555 556 .

if n=3.
5 6 55 .
but queue will contain till 556.