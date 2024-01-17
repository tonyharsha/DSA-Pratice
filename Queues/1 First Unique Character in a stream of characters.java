//TC O(N)
//SC O(N)
//Here we are using queue because we need to pop the element which was inserted first.
class Solution {
	public String firstNonRepeatingChar(String s) {
		Queue<Character> q=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		int count[]=new int[26];
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			count[c-'a']++;
			if(count[c-'a']==1 ){
				q.offer(c);
			}
            
			//Here we are using while instead of if beacuse we need to get next non repeating character.
			while(!q.isEmpty() && count[q.peek()-'a']>1){
				q.remove();
			}

			if(q.isEmpty()){
				sb.append('#');
			}else{
				sb.append(q.peek());
			}

		}
		return sb.toString();
	}
}

/*
If we use if this sort of cases will fail
Your submission failed for the following input
A : "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"

The expected return value: 
jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyqqqqq
Your function returned the following: 
jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyhrcwu
*/