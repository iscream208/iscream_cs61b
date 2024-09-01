package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    Comparator<T> com;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        com=c;
    }
    public T max(){
        int size=this.size();
        int i=0;
        T maxItem=(T)this.get(0);
        if (size==0) {
            return null;
        }
        while (i<size){
            T presentItem=(T)this.get(i);
            if (com.compare(maxItem,presentItem)<0){
                maxItem=presentItem;
            }
            i+=1;
        }
        return maxItem;
    }

    public T max(Comparator<T> c){
        int size=this.size();
        int i=0;
        T maxItem=(T)this.get(0);
        if (size==0) {
            return null;
        }
        while (i<size){
            T presentItem=(T)this.get(i);
            if (c.compare(maxItem,presentItem)<0){
                maxItem=presentItem;
            }
            i+=1;
        }
        return maxItem;
    }
}
