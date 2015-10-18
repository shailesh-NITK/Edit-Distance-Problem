//Edit Distance Problem by Shailesh

import java.*;

class EditDistance{
	int T[][];
	int l1,l2;
	
	void convertPrint(String s1, String s2){
		for(int i=l1,j=l2; i>0 && j>0;i--,j--){
			if(s1.charAt(i-1)!=s2.charAt(j-1)){
				if(T[i-1][j]< T[i-1][j-1] && T[i-1][j]<T[i][j-1]){
					System.out.println("Remove->" + s1.charAt(i-1));
					j++;
				}
				else if(T[i][j-1]<T[i-1][j-1] && T[i][j-1]<T[i-1][j]){
					System.out.println("Insert->" + s1.charAt(i-1));
				}else{
					System.out.println("Replace->" + s1.charAt(i-1) + " " + s2.charAt(j-1));
				}
			}
		}
	}
	
	int min(int a,int b,int c){
		return Math.min(Math.min(a,b),c);
	}
	
	int editDistance(String s1, String s2){
		l1=s1.length();
		l2=s2.length();
		T=new int[l1+1][l2+1];
		for(int i=0;i<=l1;i++){
			for(int j=0;j<=l2;j++){
				if(i==0){
					T[i][j]=j;
				}
				else if(j==0){
					T[i][j]=i;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)){
					T[i][j]=T[i-1][j-1];
				}
				else{
					T[i][j]= 1 + min(T[i-1][j],T[i][j-1],T[i-1][j-1]);
				}
			}
		}
		return T[l1][l2];
	}
	
	public static void main(String args[]){
		String s1="abcdef";
		String s2="azced";
		EditDistance ls=new EditDistance();
		int result=ls.editDistance(s1,s2);
		System.out.println(result);
		ls.convertPrint(s1,s2);
	}
}
