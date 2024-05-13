package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addGetTest(){
        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
        a.addFirst(8);
        assertEquals(a.size(),1);
    }

    @Test
    public void addLooongFirst(){
        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
        for(int i=0;i<1000;i++){
            a.addFirst(1);
        }
        assertEquals(a.size(),1000);
    }
    @Test
    public void addLooongLast(){
        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
        for(int i=0;i<1000;i++){
            a.addLast(1);
        }
        assertEquals(a.size(),1000);
    }
    @Test
    public void randomAdd(){
        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
        for(int i=0;i<1000;i++){
            int operationNumber= StdRandom.uniform(0,2);
            if(operationNumber==0){
                a.addLast(1);
            }
            else if(operationNumber==1){
                a.addFirst(1);
            }

        }
        assertEquals(a.size(),1000);
    }
}
