package InterviewProgramming.com.java.collection;

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
        return Math.abs(key.hashCode())%capacity;
    }

    void put(K key,V value)
    {
        int idx=getIndex(key);
        Node<K,V> head=bucket[idx];
        while (head!=null)
        {
            if(head.key.equals(key))
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
            if(head.key.equals(key))
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
                if(pre==null)
                    bucket[idx]=head.next;
                else pre.next=head.next;
            return;
        }
        pre=head;
        head=head.next;
    }

}
