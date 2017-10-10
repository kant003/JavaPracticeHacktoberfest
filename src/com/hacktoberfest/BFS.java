import java.util.*;
import java.math.*;
import java.io.*;
class BFS
{
	
	class graph											//creating a class(blueprint) for an graph object
	{
		private int  nodes;
		private LinkedList list[];
		public graph(int n)
		{
			nodes=n;
			list=new LinkedList[nodes];
			for(int i=0; i<nodes; i++)
			{
				list[i]=new <Integer>LinkedList();
			}
		}
		public void addEdge(int s, int d)
		{
			list[s].add(d);
			list[d].add(s);
		}
		public boolean existEdge(int s, int d)
		{
			return list[s].contains(d);
		}
	}
	
	public BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public PrintWriter pw=new PrintWriter(System.out, true);
	public int n=0;
	
	public static void main(String args [])	throws IOException
	{
		new BFS().run();
	}
	
	public void run()	throws IOException
	{
	
			int t=Integer.parseInt(in.readLine());
			while(t-->0)
			{
				String str[]=in.readLine().split(" ");
				n=Integer.parseInt(str[0]);
				int m=Integer.parseInt(str[1]);
				graph g=new graph(n); 
				while(m-->0)
				{
					String edge[]=in.readLine().split(" ");								//take input 
					g.addEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));		//add edges to the graph
				}	
				int s=Integer.parseInt(in.readLine());
				bfs(s,g);																//calling the bfs function
			}
		
	}
	public void	bfs(int s, graph g)
	{
		List <Integer>Q = new <Integer> LinkedList();	
		int visited[]=new int[n+1];
		visited[s]=1;
		Q.add(s);
		int i,j;
		
		while(!Q.isEmpty())																//continue until all nodes are visited
		{
			j=Q.remove(Q.size()-1);
			i=j;
			pw.println(i);																//keep printing the path
			while(i<=n)
			{
				if(visited[i]==0 && g.existEdge(j,i))
				{
					Q.add(i);
					visited[i]=1;														//mark the current node visited
				}
				i++;
			}
		}
	}	
}
