package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int size;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        nextFirst = array.length-1;
        nextLast = 0;
        size = 0;
    }
    public void addFirst(T item) {
        if (size == array.length) {
            resize();
        }
        array[nextFirst] = item;
        //System.out.println("added"+array[nextFirst]);
        nextFirst = moveLoop(false,nextFirst);
        size++;
    }
    public void addLast(T item) {
        if (size == array.length) {
            resize();
        }
        array[nextLast] = item;
        nextLast = moveLoop(true,nextLast);
        size++;
    }
//    public boolean isEmpty(){
//        return size==0;
//    }
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        if(array.length>16&&size<array.length/4) {
            resizeShort();
        }
        T item = array[moveLoop(true,nextFirst)];
        array[moveLoop(true,nextFirst)] = null;
        nextFirst = moveLoop(true,nextFirst);
        size--;
        return item;
    }
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        if(array.length>16&&size<array.length/4) {
            resizeShort();
        }
        T item = array[moveLoop(false,nextLast)];
        array[moveLoop(false,nextLast)] = null;
        nextLast = moveLoop(false,nextLast);
        size--;
        return item;
    }

private void resize() {
    T[] newArray = (T[]) new Object[array.length*2];
    int p = moveLoop(true,nextFirst);
    for (int i=0;i<size;i++) {
        newArray[i] = this.array[p];
        p = moveLoop(true,p);
    }
    this.array = newArray;
    nextFirst = newArray.length-1;
    nextLast = size;
}

    private void resizeShort() {
        T[] newArray = (T[]) new Object[array.length/2];
        int p = moveLoop(true,nextFirst);
        for (int i = 0;i < size;i++){
            newArray[i] = this.array[p];
            p = moveLoop(true,p);
        }
        this.array = newArray;
        nextFirst = newArray.length-1;
        nextLast = size;
    }
    private int moveLoop(Boolean dir,int pos) {
        if(dir){
            if(pos < array.length-1) {
                pos++;
                return pos;
            }
            return 0;
        }
        else {
            if(pos > 0){
                pos--;
                return pos;
            }
            return array.length-1;
        }
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int pos = moveLoop(true,nextFirst);
        for (int i = 0;i<size;i++){
            System.out.print(array[pos]+" ");
            pos = moveLoop(true,pos);
        }
        System.out.println(" ");
    }
    public T get(int i) {
        int head = array.length-1-nextFirst;
        if (i<head) {
            return array[nextFirst+1+i];
        }
        else {
            return array[i-head];
        }
    }
    public boolean equals(Object o) {
        if(o instanceof Deque) {
//            int pos=moveLoop(true,nextFirst);
            if (((Deque<?>) o).size() != size) {
                return false;
            }
            for (int i=0;i<size;i++) {
                if(this.get(i).equals(((Deque<?>) o).get(i)) == false) {
                    return false;
                }
//                pos=moveLoop(true,pos);
            }
            return true;
        }
        return false;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizpos;
        public ArrayDequeIterator() {
            wizpos = 0;
        }
        public boolean hasNext() {
            return wizpos < size;
        }
        public T next() {
            T returnItem = get(wizpos);
            wizpos += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
}
