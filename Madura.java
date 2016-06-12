class strmatching{
	static int naive(String p,String t){
		int n=t.length();
		int m=p.length();
		int i=0;
		while(i<n-m+1){
			int j=0;
			while((j<m)&&(p.charAt(j)==t.charAt(i+j))){
				j++;
			}
			if(j==m){
				return i;
			}
			i++;
		}
		return 0;
	}
	static int[] kmptable(String p){
		int m=p.length();
		int pi[]=new int[m];
		for(int i=0;i<m;i++){
			pi[i]=0;
		}
		int i=1;
		while(i<m){
			int j=pi[i-1];
			while(j>0){
					if(p.charAt(i)==p.charAt(j)){
						break;
					}
					j=pi[j-1];
			}
			if(p.charAt(i)==p.charAt(j)){
				pi[i]=j+1;
			}
			i++;
		}
		return pi;
	}
	static void KMP(String p,String t){
		int m=p.length();
		int n=t.length();
		int pi[]=kmptable(p);
		int i=0;
		int j=0;
		while(i<n-m+1){
			while((j<m)&&(p.charAt(j)==t.charAt(i+j))){
				j++;
			}
			if(j==m){
				System.out.println(i);
				j = 0;
			}
			if(j<1){
				i++;
			}
			else{
				i=i+j-pi[j-1];
			}
			j=pi[j];
		}
		System.out.println("nothing match");
	}
	static long hash(String p,int d){
		int m=p.length();
		long h=0;
		for(int i=0;i<m;i++){
			h+=((int)p.charAt(i)*(long)Math.pow(d,m-i-1));
		}
		return h;
	}
	static int RBC(String p,String t,int d,int q){
		int n=t.length();
		int m=p.length();
		long h=hash(p,d)%q;
		long hp=hash(t.substring(0,m),d);
		int i=0;
		while(i<n-m+1){
			//hp=hash(t.substring(i,i+m),d,q);
			if(i>0){
				int r=(int)t.charAt(i-1);
				int a=(int)t.charAt(i+m-1);
				hp=((hp-r*(long)Math.pow(d,m-1))*d+a);
			}
			//System.out.println(h+" "+hp);
			if(h==hp%q){
				return i;
			}
			i++;
		}
		return 0;
	}
	static int[][] BMtable(String p){
		int lx=(int)'z';
		int ly=p.length();
		int alp[][]=new int[lx][ly];
		int index[]=new int[lx];
		for(int i=0;i<lx;i++){
			index[i]=0;
		}
		for(int i=0;i<lx;i++){
			for(int j=0;j<ly;j++){
				alp[i][j]=-1;
			}
		}
		for(int i=0;i<ly;i++){
			int c=(int)p.charAt(i);
			alp[c][index[c]]=i;
			index[c]++;
		}
		return alp;
	}
	static int BM(String p,String t){
		int n=t.length();
		int m=p.length();
		int i=0;
		int alp[][]=BMtable(p);
		while(i<n-m+1){
			int j=m-1;
			while((j>-1)&&p.charAt(j)==t.charAt(i+j)){
				j--;
			}
			if(j==-1){
				return i;
			}
			int index=(int)t.charAt(i+j);
			int k=m-1;
			while((k>-1)&&((alp[index][k]==-1)||(alp[index][k]>j))){
				k--;
			}
			if(k>-1){
				i+=j-alp[index][k];
			}
			else{
				i+=j;
			}
		}
		return 0;
	}
	public static void main(String []args){
		String p="r";
		String t="tdldmlkvmfvdfvrrmldkvr";
		//22
		System.out.println(naive(p,t));
		KMP(p,t);
		System.out.println(RBC(p,t,10,1001));
		System.out.println(BM(p,t));
	}
}