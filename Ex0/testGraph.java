//package ex0;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//    public class testGraph {
//
//        public static String printNi(node_data node) {
//            String str = "[";
//            int a = 0;
//            for (node_data n : node.getNi()) {
//                if (a == 0) {
//                    str += n.getKey();
//                } else {
//                    str += " , " + n.getKey();
//                }
//                a++;
//            }
//            str += "]";
//            return str;
//        }
//        public static String printNi2(Collection<node_data> node, String result) {
//
//            String str = "[";
//            int a = 0;
//            for (node_data n : node) {
//                if (a == 0) {
//                    str += n.getKey();
//                } else {
//                    str += " , " + n.getKey();
//                }
//                a++;
//            }
//            str += "]";
//            String result2 = str + "\n the answer is: " + checkVal(result,str) + "\n";
//            return result2;
//        }
//        public static boolean checkVal(String result, String result3){
//            if(result.equals(result3))return true;
//            return false;
//        }
//        public static void main(String[] args) {
//            node_data n0 = new NodeData();
//            node_data n1 = new NodeData();
//            node_data n2 = new NodeData();
//            node_data n3 = new NodeData();
//            node_data n4 = new NodeData();
//            node_data n5 = new NodeData();
//
//
//
//
//
//            Graph_DS graph = new Graph_DS();
//            graph.addNode(n0);
//            graph.addNode(n1);
//            graph.addNode(n2);
//            graph.addNode(n3);
//            graph.addNode(n4);
//            graph.addNode(n5);
//            System.out.println( "nodeSize should be 6 = " + graph.nodeSize());
//
//            for (node_data node : graph.getV()) {
//                System.out.println("node.getKey() = " + node.getKey() + "  node.getInfo() = " + node.getInfo() + "  node.getNi() = " + printNi(node));
//            }
//
//
//
//            for (node_data node : graph.getV()) {
//                System.out.println(printNi(node));
//            }
//
//
//            graph.connect(n0.getKey(), n1.getKey());
//            graph.connect(n0.getKey(), n4.getKey());
//            graph.connect(n0.getKey(), n5.getKey());
//
//
//            graph.connect(n1.getKey(), n0.getKey());
//            graph.connect(n1.getKey(), n4.getKey());
//            graph.connect(n1.getKey(), n2.getKey());
//            graph.connect(n1.getKey(), n3.getKey());
//            graph.connect(n1.getKey(), n5.getKey());
//
//            graph.connect(n2.getKey(), n1.getKey());
//            graph.connect(n2.getKey(), n3.getKey());
//            graph.connect(n2.getKey(), n5.getKey());
//
//            graph.connect(n3.getKey(), n1.getKey());
//            graph.connect(n3.getKey(), n4.getKey());
//            graph.connect(n3.getKey(), n2.getKey());
//            graph.connect(n3.getKey(), n5.getKey());
//
//            graph.connect(n4.getKey(), n3.getKey());
//            graph.connect(n4.getKey(), n0.getKey());
//            graph.connect(n4.getKey(), n1.getKey());
//            graph.connect(n4.getKey(), n5.getKey());
//            graph.connect(n0.getKey(), n1.getKey());
//            graph.connect(n0.getKey(), n4.getKey());
//            graph.connect(n0.getKey(), n5.getKey());
//
//            graph.connect(n1.getKey(), n0.getKey());
//            graph.connect(n1.getKey(), n4.getKey());
//            graph.connect(n1.getKey(), n2.getKey());
//            graph.connect(n1.getKey(), n3.getKey());
//            graph.connect(n1.getKey(), n5.getKey());
//
//            graph.connect(n2.getKey(), n1.getKey());
//            graph.connect(n2.getKey(), n3.getKey());
//            graph.connect(n2.getKey(), n5.getKey());
//
//            graph.connect(n3.getKey(), n1.getKey());
//            graph.connect(n3.getKey(), n4.getKey());
//            graph.connect(n3.getKey(), n2.getKey());
//            graph.connect(n3.getKey(), n5.getKey());
//
//            graph.connect(n4.getKey(), n3.getKey());
//            graph.connect(n4.getKey(), n0.getKey());
//            graph.connect(n4.getKey(), n1.getKey());
//            graph.connect(n4.getKey(), n5.getKey());
//            System.out.println("after connent the nodes in the graph");
//
//            System.out.println();
//
//        /*for (node_data node : graph.getV()) {
//            System.out.println("node.getKey() = " + node.getKey() + "  node.getInfo() = " + node.getInfo() + "  node.getNi() = " + printNi(node));
//        }*/
//            System.out.println();
//
//
//            System.out.println( "0 =  " + (graph.getNode(n0.getKey())).getKey());
//            System.out.println( "1 =  " + (graph.getNode(n1.getKey())).getKey());
//            System.out.println( "2 =  " + (graph.getNode(n2.getKey())).getKey());
//            System.out.println( "3 =  " + (graph.getNode(n3.getKey())).getKey());
//            System.out.println( "4 =  " + (graph.getNode(n4.getKey())).getKey());
//            System.out.println( "5 =  " + (graph.getNode(n5.getKey())).getKey());
//            System.out.println();
//
//
//            System.out.println("true = " + graph.hasEdge(n0.getKey() , n1.getKey()));
//            System.out.println("true = " + graph.hasEdge(n1.getKey() , n0.getKey()));
//            System.out.println("true = " + graph.hasEdge(n1.getKey() , n5.getKey()));
//            System.out.println();
//
//            System.out.println("n0 --> " + printNi2(graph.getV(n0.getKey()) , "[1 , 4 , 5]"));
//            System.out.println("n1 --> " + printNi2(graph.getV(n1.getKey()), "[0 , 2 , 3 , 4 , 5]"));
//            System.out.println("n2 --> " + printNi2(graph.getV(n2.getKey()), "[1 , 3 , 5]"));
//            System.out.println("n3 --> " + printNi2(graph.getV(n3.getKey()), "[1 , 2 , 4 , 5]"));
//            System.out.println("n4 --> " + printNi2(graph.getV(n4.getKey()), "[0 , 1 , 3 , 5]"));
//            System.out.println();
//
//
//            System.out.println("delete node:" + graph.removeNode(n5.getKey()).getKey());
//            System.out.println("after deleted key 5");
//
//            System.out.println("n0 --> " + printNi2(graph.getV(n0.getKey()) , "[1 , 4]"));
//            System.out.println("n1 --> " + printNi2(graph.getV(n1.getKey()), "[0 , 2 , 3 , 4]"));
//            System.out.println("n2 --> " + printNi2(graph.getV(n2.getKey()), "[1 , 3]"));
//            System.out.println("n3 --> " + printNi2(graph.getV(n3.getKey()), "[1 , 2 , 4]"));
//            System.out.println("n4 --> " + printNi2(graph.getV(n4.getKey()), "[0 , 1 , 3]"));
//            System.out.println();
//
//            System.out.println( "nodeSize should be 5 = " + graph.nodeSize());
//            System.out.println( "edgeSize should be 7 = " + graph.edgeSize());
//            System.out.println();
//            graph_algorithms algo = new Graph_Algo();
//            algo.init(graph);
//            graph g = algo.copy();
//            for(node_data node : g.getV()){
//                System.out.println(node.getKey());
//            }
//            System.out.println(g.getV(n0.getKey()));
//            System.out.println("n0 --> " + printNi2(g.getV(n0.getKey()) , "[1 , 4]"));
//            System.out.println("n1 --> " + printNi2(g.getV(n1.getKey()), "[0 , 2 , 3 , 4]"));
//            System.out.println("n2 --> " + printNi2(g.getV(n2.getKey()), "[1 , 3]"));
//            System.out.println("n3 --> " + printNi2(g.getV(n3.getKey()), "[1 , 2 , 4]"));
//            System.out.println("n4 --> " + printNi2(g.getV(n4.getKey()), "[0 , 1 , 3]"));    }
//    }
//
//
