class Solution {
	public boolean savePatients(int[] vaccine, int[] midichlorians) {
		// Your code goes here
		Arrays.sort(vaccine);
		Arrays.sort(midichlorians);

		for(int i=0;i<vaccine.length;i++){
			if(vaccine[i]<midichlorians[i]) return false;
		}

		return true;
	}
}