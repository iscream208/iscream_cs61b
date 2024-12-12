package bstmap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V extends Comparable<V>> implements Map61B<K,V>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V value;
        private Node left,right;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    public BSTMap(){

    }

    public void clear(){
//        root.key=null;
//        root.value=null;
//        root.left=null;
//        root.right=null;
        root=null;
        this.size=0;
    }

    public boolean containsKey(K targetKey){
//        return get(targetKey)!=null;
        return getNode(targetKey)!=null;
    }
    public Node getNode(K targetKey){
        return getNode(root,targetKey);
    }
    private Node getNode(Node n,K targetKey){
        if(n==null) return null;
        if (targetKey.compareTo(n.key)==0) return n;
        else if (targetKey.compareTo(n.key)>0) return getNode(n,targetKey);
        else return getNode(n,targetKey);
    }

    public V get(K targetKey){
        return get(root,targetKey);
    }

    private V get(Node n, K targetKey){
        if (n==null) return null;
        if (targetKey.compareTo(n.key)==0) return n.value;
        else if (targetKey.compareTo(n.key)>0) return get(n.right,targetKey);
        else return get(n.left,targetKey);
    }

    public int size(){
        return size;
    }

    public void put(K key,V value){
        Node putNode = new Node(key,value);
        put(putNode,root);
    }
    public void put(Node putNode,Node node){
        if (this.root==null) {
            this.root=new Node(putNode.key,putNode.value);
            size+=1;
            return;}
        if (putNode.key.compareTo(node.key)<0){
            if (node.left==null) {
                node.left=putNode;
                size+=1;
                return;
            }
            put(putNode,node.left);
        }
        if (putNode.key.compareTo(node.key)>0){
            if (node.right==null) {
                node.right=putNode;
                size+=1;
                return;
            }
            put(putNode,node.right);
        }
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    public V remove(K key) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }
    public V remove(K key,V value) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    public Iterator<K> iterator() {
//        return new MyIterator();
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

//    // 内部迭代器类
//    private class MyIterator implements Iterator<K> {
//        private int currentIndex = 0;
//
//
//        public boolean hasNext() {
//            return currentIndex < size;
//        }
//
//        public K next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException("");
//            }
//            return elements[currentIndex++];
//        }
//
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//    }
}
