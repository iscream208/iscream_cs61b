package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  public static void main(String[] args) {
  }
  @Test
  public void testThreeAddThreeRemove(){
    AListNoResizing<Integer> Alist=new AListNoResizing<>();
    BuggyAList<Integer> BuggyList=new BuggyAList<>();
    for(int i=0;i<3;i++) {
        Alist.addLast(i+4);
        BuggyList.addLast(i+4);
    }
    for(int i=0;i<3;i++){
        org.junit.Assert.assertEquals(Alist.removeLast(), BuggyList.removeLast());
    }
    }

    @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> BL=new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              BL.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");

          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int Bsize = BL.size();
              System.out.println("size: " + size);
              org.junit.Assert.assertEquals(size,Bsize);
          }
          else if (operationNumber == 2) {
              // getLast
              if(L.size()>0){
                  int last = L.getLast();
                  int Blast = BL.getLast();
                  System.out.println("getlast: " + last);
                  System.out.println("getBlast: " + Blast);
                  org.junit.Assert.assertEquals(last,Blast);
              }
              else {continue;}
          }
          else if (operationNumber == 3) {
              // removeLast
              if(L.size()>0){
                  int last = L.removeLast();
                  int Blast = BL.removeLast();
                  System.out.println("removeLast: " + last);
                  System.out.println("removeBLast: " + Blast);
                  org.junit.Assert.assertEquals(last,Blast);
              }
              else {continue;}
          }

      }
  }


}
