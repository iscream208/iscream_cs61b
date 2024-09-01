package deque;
import org.junit.Test;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    public static class intComparator implements Comparator<Integer>{
        public intComparator(){
            super();
        }
        public int compare(Integer o1,Integer o2){
            if (o1>o2){
                return 1;
            } else if (o1==o2) {
                return 0;
            }
            return -1;
        }
    }

    @Test
    public void MaxArrayDequeIntTest(){
        intComparator c=new intComparator();
        MaxArrayDeque mad=new MaxArrayDeque(c);
        mad.addFirst(4);
        mad.addFirst(2);
        mad.addFirst(3);
        mad.addFirst(4);
        int m=(int)mad.max(c);
        assertEquals(m,4);
    }
    @Test
    public void get(){
        intComparator c=new intComparator();
        MaxArrayDeque<Integer> a=new MaxArrayDeque<Integer>(c);
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
