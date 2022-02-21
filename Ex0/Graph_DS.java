package ex0;

import java.util.Collection;
import java.util.HashMap;

class Graph_DS implements ex0.graph {
    private HashMap<Integer, ex0.node_data> V;
    private int numEdges;
    private int MC;

    public Graph_DS() { //empty contractor
        this.V= new HashMap<Integer, node_data>();
        this.numEdges=0;
        this.MC=0;
    }

    public Graph_DS (HashMap<Integer, node_data> V, int numEdges, int MC) { //Contractor for Graph_Algo
        this.V= new HashMap<Integer, node_data>(V);
        this.numEdges= numEdges;
        this.MC= MC;
    }

    public node_data getNode(int key) {
        if(V.containsKey(key)){
            return V.get(key);
        }
        return null; //there is no such a node with this key in V collection
    }

    public boolean hasEdge(int node1, int node2) { //O(1)
        //true if n1 and n2 are ni
        if (V.containsKey(node1)&& V.containsKey(node2)){ //both exist in the graph
            if (node2 == node1) //the same node
                return true;
            return this.getNode(node1).getNi().contains(this.getNode(node2));
        }
        return false;
    }

    public void addNode(node_data n) { //O(1)
        if(n!= null && !V.containsKey(n.getKey())) {
            V.put(n.getKey(), n); //add new node to the collection V
            MC++;
        }
    }

    public void connect(int node1, int node2) { //O(1)
        if(!hasEdge(node1, node2)  && V.containsKey(node2) && V.containsKey(node1)) {
            this.V.get(node1).addNi(getNode(node2));
            this.V.get(node2).addNi(getNode(node1));
            numEdges++; //num of edge +1
            MC++;
        }
    }

    public Collection<node_data> getV() { //O(1)
        return V.values(); //whole V collection
    }

    public Collection<node_data> getV(int node_id) { //O(1)
        return getNode(node_id).getNi(); //get node with key(=node_id) and return all of his ni
    }

    public node_data removeNode(int key) { //O(n)
        node_data Node = getNode(key); //save the node that his key is "key"
        if (Node != null) {
            if (!Node.getNi().isEmpty()) {
                Collection<node_data> Nitemp = Node.getNi();
                for (node_data NodeTemp : Nitemp) { //my ni collection
                    NodeTemp.getNi().remove(Node); //deleted myself from my ni ni collection
                }
                numEdges -= Node.getNi().size(); //num of exist edges - num of his ni
            }
            Node.getNi().clear();
            V.remove(key); //remove node
            MC++;
        }
        return Node;
    }

    public void removeEdge(int node1, int node2) { //O(1)
        if(hasEdge(node1,node2) && V.containsKey(node1) && V.containsKey(node2)) { //if both exist & connected
            getNode(node1).getNi().remove(getNode(node2));
            getNode(node2).getNi().remove(getNode(node1));
            numEdges--; //num of edges -1
            MC++;
        }
    }

    public int nodeSize() { //O(1)
        return V.size(); //num of nodes in V collection
    }

    public int edgeSize() { //O(1)
        return numEdges; //num of edge in the graph
    }

    public int getMC() {
        return MC; //num of changes in the graph
    }
}


