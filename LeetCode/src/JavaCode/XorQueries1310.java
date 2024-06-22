package JavaCode;


public class XorQueries1310 {
	
	public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res=new int[queries.length];
        int k=0;
        for(int[] a:queries)
        {
            int xor=arr[a[0]];
            for(int i=a[0]+1;i<=a[1];i++)
              xor=xor^arr[i];
            res[k++]=xor;  
        }
        return res;
    }

	public static void main(String[] args) {
		
		int[] arr = {1,3,4,8};
		int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
		int[] res=new int[queries.length];
		res=new XorQueries1310().xorQueries(arr, queries);
		for(int a:res)
			System.out.print(a+" ");

	}

}
