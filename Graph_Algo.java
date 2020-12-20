package ex0;

import java.util.*;

class Graph_Algo implements graph_algorithms{

    private graph g;

    public Graph_Algo(){
        graph g = new Graph_DS();
    }

    private int BFS(int s) { //s is first node key

        int counter = 0;
        int dist = 0; //my distance from src to dest

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        g.getNode(s).setTag(++dist); //first Node with s=key mark as visited
        counter ++;
        queue.add(s);

        while (queue.size() != 0) { //queue is not empty
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            // visited and enqueue it
            for (node_data Node : g.getNode(s).getNi()) {
                if (Node.getTag() == 0)  { //not visited in this node
                    Node.setTag(g.getNode(s).getTag()+1); // number- mark as visited; 0- mark as not visited
                    counter ++;
                    queue.add(Node.getKey());
                }
            }
        }
        return counter;
    }

    public void init(graph g) {
        this.g =  g;
    }

    public graph getGraph() {
        return this.g;
    }

    public graph copy() {
        graph newg = new Graph_DS();
        for(node_data Node: g.getV()) { //copy nodes
            node_data newNode = new NodeData(); //copy constructor- NodeData
            newNode.setTag(Node.getTag()); //copy Node Tag
            newNode.setInfo(Node.getInfo()); //copy Node Info
        }
        for(node_data Node1: g.getV()) { //copy each node ni == edges
            for(node_data Node2: g.getNode(Node1.getKey()).getNi()){ //all ni of node1
                if(!g.hasEdge(Node1.getKey(), Node2.getKey())){
                    g.connect(Node1.getKey(), Node2.getKey());
                }
            }
        }
        return newg;
    }

    public boolean isConnected() {
        for(node_data Node: g.getV()) {
            Node.setTag(0); //mark each node in g graph as not visited
        }
        int RandomKey=0;
        if (g.nodeSize()== 0){
            return true;
        }
        for(node_data Node: g.getV()) {
            RandomKey= Node.getKey();
        }
        return BFS(RandomKey)==g.nodeSize(); //if counter is equal to nodesize return true;
    }

    public int shortestPathDist(int src, int dest) {
        for(node_data Node: g.getV()) {
            Node.setTag(0); //mark each node in g graph as not visited
        }
        BFS(src);
        if(g.getNode(src)==g.getNode(dest)){ //path from this node to himself
            return 0;
        }
        if(g.getNode(src) == null || g.getNode(dest) == null || g.getNode(dest).getTag()==0){ //no path at all
            return -1;
        }
        return g.getNode(dest).getTag()-1; //return "dist" of dest node
    }

    public List<node_data> shortestPath(int src, int dest) {
        BFS(src);
        List<node_data> list =new LinkedList<node_data>();
        if(shortestPathDist(src, dest)==-1){
            return list; //empty list
        }
        for(node_data Node: g.getV()) {
            Node.setTag(0); //mark each node in g graph as not visited
        }
        if(shortestPathDist(src, dest)==0){
            list.add(g.getNode(src));
            return list;
        }
        for(node_data Node: g.getV()) {
            Node.setTag(0); //mark each node in g graph as not visited
        }
        int dist= shortestPathDist(dest, src)+1;
        node_data Node = g.getNode(src);
        do {
            for (node_data Node1 : Node.getNi()) {
                if (Node1.getTag() == dist -1) {
                    list.add(Node);
                    dist--;
                    Node = Node1;
                }
            }
        }
        while (dist > 1);
        list.add(g.getNode(dest));
        return list;
    }
}


