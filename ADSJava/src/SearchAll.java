import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Nodes {

	public char label;
	public boolean visited=false;

	public Nodes(char l){
		this.label=l;
	}
}


class Graph {

	public Nodes rootNode;
	public ArrayList nodes;
	public int[][] adjMatrix;
	int size;
	
	public Graph() {
		nodes = new ArrayList();
	}

	public void setRootNode(Nodes n) {
		this.rootNode=n;
	}
	
	public Nodes getRootNode() {
		return this.rootNode;
	}
	
	public void addNode(Nodes n) {
		nodes.add(n);
	}
	
	
	public void connectNode(Nodes start,Nodes end) {

		if(adjMatrix==null) {
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}
	
	private Nodes getUnvisitedChildNode(Nodes n) {
		
		int index=nodes.indexOf(n);
		int j=0;
		
		while(j<size) {
			if(adjMatrix[index][j]==1 && ((Nodes)nodes.get(j)).visited==false) {
				return (Nodes)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	

	public void bfs() {
		
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;

		while(!q.isEmpty()) {
			Nodes n=(Nodes)q.remove();
			Nodes child=null;
			
			while((child=getUnvisitedChildNode(n))!=null) {
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		clearNodes();
	}
	

	public void dfs() {

		Stack s=new Stack();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty()) {
			Nodes n=(Nodes)s.peek();
			Nodes child=getUnvisitedChildNode(n);
			if(child!=null) {
				child.visited=true;
				printNode(child);
				s.push(child);
			} else{
				s.pop();
			}
		}
		clearNodes();
	}
	

	private void clearNodes() {
		int i=0;
		while(i<size)
		{
			Nodes n=(Nodes)nodes.get(i);
			n.visited=false;
			i++;
		}
	}
	
	
	private void printNode(Nodes n) {
		System.out.print(n.label+" ");
	}
}



public class SearchAll {

	public static void main(String[] args)  {
		
		Nodes nA=new Nodes('A');
		Nodes nB=new Nodes('B');
		Nodes nC=new Nodes('C');
		Nodes nD=new Nodes('D');
		Nodes nE=new Nodes('E');
		Nodes nF=new Nodes('F');

		Graph g=new Graph();

		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);
		
		g.connectNode(nA,nB);
		g.connectNode(nA,nC);
		g.connectNode(nA,nD);
		
		g.connectNode(nB,nE);
		g.connectNode(nB,nF);
		g.connectNode(nC,nF);
		
		System.out.println("DFS Traversal of a tree is ------------->");
		g.dfs();
		
		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();
	}
}