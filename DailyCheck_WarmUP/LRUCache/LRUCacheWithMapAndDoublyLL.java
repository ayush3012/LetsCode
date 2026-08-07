package DailyCheck_WarmUP.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithMapAndDoublyLL<K,V> {

    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> pre;
        Node<K,V> next;

        Node(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
    }

    private final int capacity;

    private final Map<K,Node<K,V>> cache;

    private final Node<K,V> head;

    private final Node<K,V> tail;

    public LRUCacheWithMapAndDoublyLL(int capacity)
    {
        if(capacity<=0)
            throw new IllegalArgumentException("capacity should be positive");

        this.capacity=capacity;
        cache=new HashMap<>((int)(capacity/0.75f)+1);  // it will avoid resizing
        this.head=new Node<>(null,null);
        this.tail=new Node<>(null,null);

        head.next=tail;
        tail.pre=head;
    }

    public V get(K key){
        Node<K,V> node=cache.get(key);

        if(node==null)
            return null;

        moveToHead(node);

        return node.value;
    }

    public void put(K key,V value)
    {
        Node<K,V> existingNode=cache.get(key);

        if(existingNode!=null)
        {
            existingNode.value=value;
            moveToHead(existingNode);
            return;
        }

        Node<K,V> newNode=new Node<>(key,value);

        cache.put(key,newNode);

        addToHead(newNode);

        if(cache.size()>capacity)
        {
            Node<K,V> lruNode=removeTail();
            cache.remove(lruNode.key);
        }
    }

    public V remove(K key)
    {
        Node<K,V> node=cache.remove(key);

        if(node==null)
            return null;

        removeNode(node);
        return node.value;
    }
    private void moveToHead(Node<K,V> node)
    {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K,V> node)
    {
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }

    private void removeNode(Node<K,V> node)
    {
        if (node == head || node == tail)
            return;
        node.pre.next=node.next;
        node.next.pre=node.pre;

        node.pre=null;
        node.next=null;
    }

    private Node<K,V> removeTail()
    {
        Node<K,V> lruNode=tail.pre;
        removeNode(lruNode);
        return lruNode;
    }

    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        Node<K,V> current=head.next;

        while (current!=tail)
        {
            sb.append("[")
                    .append(current.key)
                    .append("=")
                    .append(current.value)
                    .append("]");

            if (current.next != tail) {
                sb.append(" -> ");
            }
            current=current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCacheWithMapAndDoublyLL<Integer,String> cache=new LRUCacheWithMapAndDoublyLL<>(3);

        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");

        System.out.println(cache);

        cache.get(1);

        System.out.println(cache);

        cache.put(4,"D");

        System.out.println(cache);

        System.out.println(cache.get(2));
    }
}
