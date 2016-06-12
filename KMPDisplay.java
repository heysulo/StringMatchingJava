class KMPDisplay{
	public static void main(String[] args) {
		String txt = "ABC ABCDAB ABCDABCDABDE ABCDABCDABDEABCDABCDABDEABCDABCDABDE";
		String pat = "ABCDABD";
		int []preft = new int[pat.length()];
		int i,j,max;
		for (i=1;i<pat.length() ;i++ ) {
			String prefix = pat.substring(0,i);
			//System.out.println(prefix);
			max=0;
			for (j=0;j<prefix.length() ;j++ ) {
				String n_prefix = prefix.substring(0,j);
				String n_suffix = prefix.substring(prefix.length()-j,prefix.length());
				if (n_suffix.equals(n_prefix)){
					//System.out.println(n_prefix + "\t" + n_suffix);
					max = j;
				}
			}
			preft[j] = max;			
		}
		preft[0] = -1;

		System.out.println(txt);
		for (i=0;i<txt.length()-pat.length() ; ) {
			j=0;
			for (max=0;max<i ;max++ ) {
				System.out.print("-");
			}
			System.out.println(pat);
			while (j<pat.length() && txt.charAt(i+j)==pat.charAt(j)){
				j++;
				if (j==pat.length()){
					System.out.println(i);
					j--;
					break;
				}
			}
			i+=j-preft[j];
		}
	}
}