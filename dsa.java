class dsa{

	int a[] ={10,9,8,7,6,5,4,3,2,1};
	int b[]=new int[a.length];
	int c[]=new int[a.length];
	int count=0;
	int sum;
	double awt;

	public void pickup(){

	}

	public boolean check(){
		for(int i=0;i<a.length;i++){
			if(a[i]<0){
				count++;
			}
		}	
		if(count >0) return false;
		else return true;
	}

	void merge(int arr[], int l, int m, int r) { 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		int L[] = new int [n1]; 
		int R[] = new int [n2]; 
  
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 
  

		int i = 0, j = 0; 

		int k = l; 
		while (i < n1 && j < n2) 
			{ 
		if (L[i] <= R[j]){ 
			arr[k] = L[i]; 
			i++; 
	    	} 
	    	else
	    	{ 
			arr[k] = R[j]; 
			j++; 
		} 
	 	k++; 
		}
  
		while (i < n1) { 
	    		arr[k] = L[i]; 
	    		i++; 
	    		k++; 
		}
		while (j < n2){
		    arr[k] = R[j]; 
		    j++; 
		    k++; 
		}
	}

	void sort(int arr[], int l, int r) { 
		if (l < r) { 
			int m = (l+r)/2; 
  
			sort(arr, l, m); 
			sort(arr , m+1, r); 
  
			merge(arr, l, m, r); 
		}
	} 

	void CandP(){
		System.out.println("Printing Table");
		System.out.println("Pno\tBT\tCT\tTAT\tWT");
		int i=0;
		for(i=0;i<a.length;i++){
			if(i>0)
			b[i]=a[i]+b[i-1];
			else
			b[i]=a[i];
			c[i]=b[i]-a[i];
			sum=sum+c[i];
		System.out.println(i+1+"\t"+a[i]+"\t"+b[i]+"\t"+b[i]+"\t"+c[i]);
		}
		awt=(double)sum/i;
		System.out.println("\nAverage waiting time = "+awt);

	}
	public static void main(String args[]){

		dsa ob=new dsa();
		boolean b1=ob.check();
		if(b1==true){
			System.out.println(b1);
      			ob.sort(ob.a, 0, ob.a.length-1);
			ob.CandP();
		}
		else{
			System.out.println(b1);
			System.out.println("There is a negative number");
		}
	}
}