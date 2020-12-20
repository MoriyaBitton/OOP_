package ex0;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class NodeData implements node_data {

        private int Key, Tag;
        private HashMap<Integer,node_data> ni =new HashMap<>();
        private String Info;
        private static int nodeId = 0;



    public NodeData (int Key, int Tag, Collection<node_data> ni, String Info) { //Constructor for Graph_Algo
            this.Key=Key;
            this.Tag=Tag;
            this.ni= new HashMap<Integer, node_data>(); //new HashMap
            this.Info=new String(Info);
    }

    public NodeData (node_data nd) { //Copy Contractor for Graph_Algo
            this.Key=nd.getKey();
            this.Tag=nd.getTag();
            this.ni=new HashMap<Integer, node_data>(); //new HashMap for the copy contractor
            Iterator<node_data> it=nd.getNi().iterator();
            while(it.hasNext()){
                node_data temp=it.next();
                this.ni.put(temp.getKey(),temp);
            }
            this.Info=new String(nd.getInfo());
    }

    public NodeData() { //empty contractor
        this.Key=nodeId;
        nodeId++;
        this.Tag=0;
        this.ni=new HashMap<Integer, node_data>();
        this.Info="";
    }

    public int getKey() {
        return Key;
    }

    public Collection<node_data> getNi() {
        return this.ni.values();
    }

    public boolean hasNi(int key) {
        if (ni.containsKey(key)) return true;
        return false;
    }

    public void addNi(node_data t) {
        if(t.getKey()!=this.getKey() ) {
            if (t != null) {
                this.ni.put(t.getKey(), t); //add t to my ni collection
            }
        }
    }

    public void removeNode(node_data node) {
        //remove node by deleted him from his ni, ni collection
        //after we isolate him we can delete the node itself
        if (node != null && ni.containsKey(node.getKey())){
            ni.remove(node.getKey());
        }
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String s) {
        Info=s;
    }

    public int getTag() {
        return Tag;
    }

    public void setTag(int t) {
        Tag=t;
    }
}




