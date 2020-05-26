class MyHashMap {
    class HashNode{
      final int key;
      int value;
      HashNode next;
      public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
    final int SIZE = 10001;
    HashNode[] array;
    
    public MyHashMap() { array = new HashNode[SIZE];}
    
    public void put(int key, int value) {
        int index = hash(key); 
        HashNode head = array[index];
        HashNode node = head;
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode new_node = new HashNode(key, value);
        new_node.next = head;
        array[index] = new_node;
    }
    public int get(int key) {
        int index = hash(key);
        HashNode node = array[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }
    public void remove(int key) {
        int index = hash(key);
        HashNode node = array[index];
        while (node != null) {
            if (node.key == key) {
                node.value = -1;
                return;
            }
            node = node.next;
        }
    }
    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
