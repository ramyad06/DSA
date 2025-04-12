class LFUCache {
    final int capacity;
    int cursize;
    int minfreq;
    Map<Integer,DLLNode> cache;
    Map<Integer,DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cursize = 0;
        this.minfreq = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null){
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }else{
            cursize++;
            if(cursize>capacity){
                DoubleLinkedList minFreqList = frequencyMap.get(minfreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                cursize--;
            }
            minfreq = 1;
            DLLNode newNode = new DLLNode(key,value);
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key,newNode);
        }
    }
    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minfreq && curList.listSize == 0){
            minfreq++;
        }
        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency,new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency,newList);
    }
}
class DLLNode {
    int key, val, frequency;
    DLLNode prev, next;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoubleLinkedList {
    DLLNode head, tail;
    int listSize;

    public DoubleLinkedList() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        listSize = 0;
    }

    public void addNode(DLLNode node) {
        DLLNode nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
        listSize++;
    }

    public void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listSize--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */