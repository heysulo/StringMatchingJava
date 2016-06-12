class StringMatchBF{
	public static void main(String[] args) {
		String txt= "aaaahaaaahaaahahaahaaaaaahahaaaahaaaaahahahahahahahaaaaaaaaaaaaaahahahaaaaaaaaaahaaahaaaaaahaaaaah";
		String pat = "aah";
		int i,j;
		for (i=0;i<txt.length() ;i++ ) {
			j=0;
			while (j<pat.length() && txt.charAt(i+j)==pat.charAt(j)){
				j++;
				if (j==pat.length()){
					System.out.println(i);
				}
			}
			
		}

	}
}
