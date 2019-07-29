

package rubik2;
import java.util.*; 


public class BreadthFirstSearch {


   
    
    
    public static void BFS(int[] startingState){
        int[] goalState = {0, 1 , 2, 3, 4, 5, 6, 7}; //Goal
        String[] goalPath;  //Path
        boolean Goal;       //Goal Reached? 
        
        
        
        Queue<int[]> Frontier = new LinkedList<>();     //Frontier Queue
        ArrayList<int[]> explored = new ArrayList<>();     //Explored Set         
        
        
        
        int[] currentState = startingState.clone(); //a node with STATE=problem.INITIAL-STATE
        Frontier.add(currentState);                 //add Current state to frontier
        
        
        //Test Goal
        if(Rubik2.check()){
            Goal = true;
        }
        
        else{
        
        if(Frontier.isEmpty()){
            return; //failure 
        }
        currentState = Frontier.poll();
        explored.add(currentState);        

       
        
           while(!Frontier.isEmpty()) {
            int parent[]  = Frontier.poll();
            for(int i = 1; i<13 ; i++) {
                int[] child = motion(i,parent);
                if(!Rubik2.check())
                     Frontier.add(child);
            }
            
        }
        
        }
        
                
    }
    
    public static int []  motion(int i,int[]current){
        
        
        int state[] = current.clone();
        
        switch (i) {
            case 1:  Rubik2.c.up();
                     break;
            case 2:  Rubik2.c.up_inv();
                     break;
            case 3:  Rubik2.c.down();
                     break;
            case 4:  Rubik2.c.down_inv();
                     break;
            case 5:  Rubik2.c.right();
                     break;
            case 6:  Rubik2.c.right_inv();
                     break;
            case 7:  Rubik2.c.left();
                     break;
            case 8:  Rubik2.c.left_inv();
                     break;
            case 9:  Rubik2.c.front();
                     break;
            case 10:  Rubik2.c.front_inv();
                     break;
            case 11:  Rubik2.c.back();
                     break;
            case 12:  Rubik2.c.back_inv();
                     break;
        
        }
        return  state;
    }
    
    
       
    
    
    
    
    
}
