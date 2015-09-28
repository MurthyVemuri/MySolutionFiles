import java.util.Map;


   
class Entry<K, V> implements Map.Entry<K, V>{
    final K key;
    V value;
    Entry<K,V> next;
    final int hash;
    
    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }

    @Override
    public K getKey() {
        // TODO Auto-generated method stub
        return key;
    }

    @Override
    public V getValue() {
        // TODO Auto-generated method stub
        return value;
    }

    @Override
    public V setValue(V newvalue) {
        // TODO Auto-generated method stub
        V oldValue = value;
        value = newvalue;
        return oldValue;
    }
    
    public final int hashCode(){
       return (key==null ? 0 : key.hashCode()) ^ 
               (value==null ? 0 : value.hashCode());
    }
        
}


class HashTable<K, V> {
    @SuppressWarnings("rawtypes")
    private Entry[] table;
    private int size;
    private int capacity;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public HashTable(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
        size = 0;
    }
    
    public HashTable(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public int size(){
        return size;
    }
    
    private int hash(Object key){
        return key.hashCode() % capacity;
    }
    
    @SuppressWarnings("unchecked")
	public V get(Object key){
        if (key == null) return getForNullKey();
//        int hash = hash(key);
        for (Entry<K,V> e = table[hash(key)]; e!= null; e = e.next){
            Object k;
            if ((k = e.key) == key || key.equals(k))
                return e.value;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
	private V getForNullKey() {
        for (Entry<K,V> e = table[0]; e!= null; e = e.next){
            if (e.key == null)
                return e.value;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
	public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);
        for (Entry<K,V> e = table[hash]; e != null; e = e.next) {
            Object k;
            if ((k = e.key) == key || key.equals(k)){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        
        addEntry(hash, key, value);
        return null;
    }
    
    @SuppressWarnings("unchecked")
	private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e!= null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
    addEntry(0, null, value);
    return null;
    }
    
    void addEntry(int hash, K key, V value) {
        @SuppressWarnings("unchecked")
		Entry<K,V> e = table[hash];
        table[hash] = new Entry<>(hash, key, value,e);
    }
}    


public class HashTableGenericTest {
       public static void main (String[] args){
            HashTable<Integer,String> ht  = new HashTable<Integer,String>();
            ht.put(1,"Murthy");
            ht.put(12,"L.Murthy");
            ht.put(11,"N.Murthy");
            ht.put(13,"V.Murthy");

            System.out.println(ht.get(1) );
            System.out.println(ht.get(12) );
            System.out.println(ht.get(11) );
            System.out.println(ht.get(13) );
       }
}