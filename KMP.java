class KMP{
	public static void main(String[] args) {
		String txt = "AAABAABA";
		String pat = "AB";
		if (txt.length()>=pat.length() && pat.length() >0){
			String pref[] = new String[pat.length()-1];
			int table[] = new int[pat.length()];
			//get prefixes;
			int i,j;
			table[0]=0;
			
			for (i=0;i<pat.length() ;i++ ) {
				String prefix = pat.substring(0,i+1);
				int max = 0;
				for (j=1;j<prefix.length();j++ ) {
					String x = (prefix.substring(0,j));
					String y = (prefix.substring(prefix.length()-j,prefix.length()));
					if(x.equals(y)){
						max = j;
					}
				}
				table[i] = max;
			}

			for (i=0;i<txt.length() ;) {
				j=0;
				while (j<pat.length() && (i+j)<txt.length() && txt.charAt(i+j)==pat.charAt(j)){
					j++;
					if (j==pat.length()){
						System.out.println(i);
					}
				}
				if (j==pat.length()){
					j-=1;
				}
				if (table[j]==0){
					i++;
				}else{
					i+=table[j];
				}
			}
		
		}
	}
}