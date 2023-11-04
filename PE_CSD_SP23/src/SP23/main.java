
package SP23;


public class main {
    
    
    public static void main(String[] args) {
          worker w1 = new worker(1, "Hung" , 20);
          worker w2 = new worker(6, "Nguyen" , 70);
          worker w3 = new worker(8, "Minh" , 35);
          worker w4 = new worker(43, "Hai" , 60);
          bst b = new bst();
         
          worker[] w = new worker[4];
          w[0] = w1;
          w[1] = w2;
          w[2] = w3;
          w[3] = w4;
        
//        
//        worker w5 = new worker(12, "Hung" , 20);
//        worker w6 = new worker(44, "Nguyen" , 70);
//        worker w7 = new worker(15, "Minh" , 35);
//        worker w8 = new worker(85, "Hai" , 24);
//        
//        worker[] w1 = new worker[4];
//        w1[0] = w5;
//        w1[1] = w6;
//        w1[2] = w7;
//        w1[3] = w8;
        

        
//        //2.To obtain tree from A
          b.insertMany(w);
//        
//        //1.Find the node of T containing worker whost key matches a given key
          System.out.println("Question 1 ---");
          System.out.println(""+b.find(8).getData());  
          System.out.println();
//        
//        //3.Output the workers on T descending order
          System.out.println("Question 3 ---");
          b.PrintDescendingOrder();
          System.out.println();
////        
//        //4.Count the number of workers stored in T
          System.out.println("Question 4 ---");
          System.out.println("Count = "+b.countYounger25());
          System.out.println();
////        
//        //5.Delete the right most node of T
          System.out.println("Question 5 ---");
          b.deleteRightMostNode(b.root);
          b.PrintDescendingOrder();
          System.out.println();
////        
//        //6.Determine the height
          System.out.println("Height: "+b.heightTree());
//        
        //7.Create a binary search tree
//        b.createTreeWithLargetHeight(w1);
        
    }
}
