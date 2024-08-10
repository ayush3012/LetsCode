package JavaCode;

/**Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
*/
public class CenterOfGraph1791 {
	
	public int findCenter(int[][] edges) {
		return edges[1][0]==edges[0][0] || edges[1][1]==edges[0][0]?edges[0][0]:edges[0][1]; 
    }

	public static void main(String[] args) {
		//int[][] edges = {{1,2},{2,3},{4,2}};

		int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
		
		System.out.print(new CenterOfGraph1791().findCenter(edges));

	}

}
