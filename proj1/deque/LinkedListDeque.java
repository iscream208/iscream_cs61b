package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>,Iterable<T>{
    private class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode p,T i,IntNode n){
            prev=p;
            item=i;
            next=n;
        }
    }

    private IntNode first;
    private int size;
    private IntNode sentinel;
    //public IntNode last;

    public LinkedListDeque(){
        sentinel=new IntNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
        //last=sentinel;
    }
    public void addLast(T x){
        IntNode last=sentinel.prev;
        IntNode i=new IntNode(last,x,sentinel);
        last.next=i;
        last=i;
        sentinel.prev=last;
        size++;
    }
    public void addFirst(T x){
        IntNode i=new IntNode(sentinel,x,sentinel.next);
        sentinel.next.prev=i;
        sentinel.next=i;
        size++;
    }
//    public boolean isEmpty(){
//        return size==0;
//    }
    public int size(){
        return size;
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        else{
            IntNode i=sentinel.next;
            sentinel.next=i.next;
            i.next.prev=sentinel;
            size--;
            return i.item;
        }
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        else{
            IntNode last=sentinel.prev;
            IntNode i=last;
            i.prev.next=sentinel;
            sentinel.prev=i.prev;
            size--;
            return i.item;
        }
    }
    public T get(int index){
        if(index>size-1||index<0){
            return null;
        }
        IntNode p=sentinel.next;
        while (index>0){
            p=p.next;
            index--;
        }
        return p.item;
    }
    public T getRecursive(int index){
        if(index>size-1||index<0){
            return null;
        }
        return getRecursiveHelper(index,sentinel.next);
    }
    private T getRecursiveHelper(int index,IntNode p){
        if(index==0){
            return p.item;
        }
        else {
            return getRecursiveHelper(index-1,p.next);
        }
    }
    public void printDeque(){
        IntNode p=sentinel.next;
        while (p!=sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
        System.out.println(' ');
    }
    public boolean equals(Object o){
        if(o instanceof LinkedListDeque){
            for(int i=0;i<size;i++){
                if(this.get(i)!=((LinkedListDeque<?>) o).get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    private class LinkedListDequeIterator implements Iterator<T> {
        private int wizPos;
        public LinkedListDequeIterator(){
            wizPos=0;
        }
        public boolean hasNext(){
            return wizPos<size;
        }
        public T next(){
            T returnItem=get(wizPos);
        wizPos+=1   ;
            return returnItem;
        }
    }
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }
}
