package ex0;

    public class testNodeData {

        public static void printNi(node_data node, String s, String result){
            String Neighbors = s + " Neighbors - ";
            String str ="[";
            int a = 0;
            for(node_data n : node.getNi()){
                if(a == 0){
                    str += n.getKey() ;
                }else{
                    str += " , " + n.getKey();
                }
                a++;
            }
            str += "]";

            System.out.print( " " +Neighbors+ str + " == " + result);
            System.out.print( "\n the answer is: " + checkVal(result,str) + "\n");
        }
        public static boolean checkVal(String result, String result3){
            if(result.equals(result3))return true;
            return false;
        }
        public static void main(String[] args) {

            //check for class node_data
            NodeData n0 = new NodeData();
            NodeData n1 = new NodeData();
            NodeData n2 = new NodeData();
            NodeData n3 = new NodeData();
            NodeData n4 = new NodeData();
       /* System.out.println(n0.toString(n0));
        System.out.println(n1.toString(n1));
        System.out.println(n2.toString(n2));
        System.out.println(n3.toString(n3));
        System.out.println(n4.toString(n4));
*/
            System.out.println();

            //0->1->4
            n0.addNi(n1);
            n0.addNi(n4);
            printNi(n0, "n0", "[1 , 4]");

            //1->0->4->2->3
            n1.addNi(n0);
            n1.addNi(n0);
            n1.addNi(n4);
            n1.addNi(n2);
            n1.addNi(n2);
            n1.addNi(n3);
            n1.addNi(n3);
            printNi(n1, "n1", "[0 , 2 , 3 , 4]");

            //2->1->3
            n2.addNi(n1);
            n2.addNi(n3);
            n2.addNi(n1);
            n2.addNi(n3);
            printNi(n2, "n2", "[1 , 3]");

            //3->1->4->2
            n3.addNi(n1);
            n3.addNi(n4);
            n3.addNi(n2);
            n3.addNi(n1);
            n3.addNi(n4);
            n3.addNi(n2);
            n3.addNi(n1);
            n3.addNi(n4);
            n3.addNi(n2);
            printNi(n3, "n3", "[1 , 2 , 4]");

            //4->3->0->1
            n4.addNi(n3);
            n4.addNi(n0);
            n4.addNi(n1);
            n4.addNi(n3);
            n4.addNi(n0);
            n4.addNi(n1);
            n4.addNi(n3);
            n4.addNi(n0);
            n4.addNi(n1);
            printNi(n4 , "n4", "[0 , 1 , 3]");

            n0.setInfo("n0 info");
            n0.setTag(0);


            n1.setInfo("n1 info");
            n1.setTag(1);

            n2.setInfo("n2 info");
            n2.setTag(2);

            n3.setInfo("n3 info");
            n3.setTag(3);

            n4.setInfo("n4 info");
            n4.setTag(4);

            System.out.println();
        /*System.out.println(n0.toString(n0));
        System.out.println(n1.toString(n1));
        System.out.println(n2.toString(n2));
        System.out.println(n3.toString(n3));
        System.out.println(n4.toString(n4));*/

        }
    }


