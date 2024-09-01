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
}
