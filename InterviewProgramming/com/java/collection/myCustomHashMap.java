package InterviewProgramming.com.java.collection;

import InterviewProgramming.com.interview.codes.Practice;

import java.util.Objects;

public class myCustomHashMap<K,V> {

    static class Node<K,V>
    {
        K key;
        V value;
        Node<K,V> next;
        Node(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
    }

    int capacity=16;
    Node<K,V>[] bucket;

    myCustomHashMap()
    {
        bucket=new Node[capacity];
    }

    int getIndex(K key)
    {
        return Math.floorMod(key.hashCode(),capacity);
    }

    void put(K key,V value)
    {
        int idx=getIndex(key);
        Node<K,V> head=bucket[idx];
        while (head!=null)
        {
            if(Objects.equals(head.key,key))
            {
                head.value=value;
                return;
            }
            head=head.next;
        }
        Node<K,V> n=new Node<>(key,value);
        n.next=bucket[idx];
        bucket[idx]=n;
    }

    V get(K key)
    {
        int idx=getIndex(key);
        Node<K,V> head=bucket[idx];
        while (head!=null)
        {
            if(Objects.equals(head.key,key))
                return head.value;
            else head=head.next;
        }
        return null;
    }

    void remove(K key)
    {
        int idx=getIndex(key);
        Node<K,V> head=bucket[idx];
        Node<K,V> pre=null;
        while (head!=null)
        {
            if(head.key.equals(key))
            {
                if(pre==null)
                    bucket[idx]=head.next;
                else pre.next=head.next;
                return;
            }
            pre=head;
            head=head.next;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb=new StringBuilder("{");
        for(int i=0;i<capacity;i++)
        {
            Node<K,V> node=bucket[i];
            while (node!=null)
            {
                sb.append(node.key)
                        .append("=")
                        .append(node.value);
                node=node.next;
                if(node!=null)
                    sb.append("->");
                if(node==null)
                    sb.append(",");
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        myCustomHashMap<Integer,String> map=new myCustomHashMap();

        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(4,"a");

        System.out.println(map);
    }

}
