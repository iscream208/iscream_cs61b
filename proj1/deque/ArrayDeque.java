package deque;

import net.sf.saxon.functions.ConstantFunction;

public class ArrayDeque<T> {
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int size;
    public void ArrayDeque(){
        array=(T[]) new Object[8];
        nextFirst=array.length-1;
        nextLast=0;
        size=0;
    }
    public void addFirst(T item){
        if (size==array.length){
            resize();
        }
        array[nextFirst]=item;
        nextFirst=moveLoop(false,nextFirst);
        size++;
    }
    public void addLast(T item){
        if (size==array.length){
            resize();
        }
        array[nextLast]=item;
        nextLast=moveLoop(true,nextLast);
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        if(array.length>16&&size<array.length/4){
            resizeShort();
        }
        T item=array[moveLoop(true,nextFirst)];
        array[moveLoop(true,nextFirst)]=null;
        nextFirst=moveLoop(true,nextFirst);
        size--;
        return item;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        if(array.length>16&&size<array.length/4){
            resizeShort();
        }
        T item=array[moveLoop(false,nextLast)];
        array[moveLoop(false,nextLast)]=null;
        nextLast=moveLoop(false,nextLast);
        size--;
        return item;
    }
    private void resize(){
        T[] newArray=(T[]) new Object[array.length*2];
        for(int i=0;i<nextLast;i++){
            newArray[i]=array[i];
        }
        for(int i=0;i<array.length-1-nextFirst;i++){
            newArray[newArray.length-i]=array[array.length-i];
        }
        nextFirst=newArray.length-1-(array.length-1-nextFirst);
        this.array=newArray;
    }
    private void resizeShort(){
        T[] newArray=(T[]) new Object[array.length/2];
        for(int i=0;i<nextLast;i++){
            newArray[i]=array[i];
        }
        for(int i=0;i<array.length-1-nextFirst;i++){
            newArray[newArray.length-i]=array[array.length-i];
        }
        nextFirst=newArray.length-1-(array.length-1-nextFirst);
        this.array=newArray;
    }
    private int moveLoop(Boolean dir,int pos){
        if(dir){
            if(pos< array.length-1){
                pos++;
                return pos;
            }
            return 0;
        }
        else {
            if(pos>0){
                pos--;
                return pos;
            }
            return array.length-1;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int pos=moveLoop(true,nextFirst);
        for (int i=0;i<size;i++){
            System.out.print(array[pos]+" ");
            pos=moveLoop(true,pos);
        }
        System.out.println(" ");
    }
    public T get(int i){
        int head=array.length-1-nextFirst;
        if (i<head){
            return array[nextFirst+1+i];
        }
        else {
            return array[i-head];
        }
    }
}
