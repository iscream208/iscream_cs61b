package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addGetTest(){
        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
        a.addFirst(7);
        assertEquals(a.size(),1);
        assertEquals((int)a.get(0),7);
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

//    @Test
//    public void iterTest(){
//        ArrayDeque<Integer> a=new ArrayDeque<Integer>();
//        for(int i=0;i<1000;i++){
//            int operationNumber= StdRandom.uniform(0,2);
//            if(operationNumber==0){
//                a.addLast(1);
//            }
//            else if(operationNumber==1){
//                a.addFirst(1);
//            }
//
//        }
//        int count=0;
//        for(int item :a){
//            count+=1;
//        }
//        assertEquals(count,1000);
//    }
@Test
public void get(){
    ArrayDeque<Integer> a=new ArrayDeque<Integer>();
    a.addLast(0);
    int v1=a.removeFirst();
    assertEquals(v1,0);
    a.addLast(2);
    a.addLast(3);
    a.addLast(4);
    a.addLast(5);
    a.addLast(6);
    a.addFirst(7);
    a.addLast(8);
    v1=a.get(3);
    assertEquals(v1,4);
    v1=a.removeFirst();
    assertEquals(v1,7);
    a.addFirst(11);
    v1=a.removeFirst();
    assertEquals(v1,11);
    v1=a.get(4);
    assertEquals(v1,6);
    v1=a.get(3);
    assertEquals(v1,5);
    a.addLast(15);
    a.addFirst(16);
    a.addLast(17);
    a.addLast(18);
    v1=a.get(5);
    assertEquals(v1,6);
}
}
