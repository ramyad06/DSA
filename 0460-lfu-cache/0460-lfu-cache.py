class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.freq = 1
        self.prev = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = Node(0, 0)  
        self.tail = Node(0, 0)  
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_node(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node

    def remove_node(self, node):
        prev = node.prev
        nxt = node.next
        prev.next = nxt
        nxt.prev = prev

    def remove_last(self):
        if self.head.next == self.tail:
            return None
        last = self.tail.prev
        self.remove_node(last)
        return last

    def is_empty(self):
        return self.head.next == self.tail


class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.key_map = {}        
        self.freq_map = {}      
        self.min_freq = 0

    def _update_freq(self, node):
        freq = node.freq
        self.freq_map[freq].remove_node(node)

        if freq == self.min_freq and self.freq_map[freq].is_empty():
            self.min_freq += 1

        node.freq += 1

        if node.freq not in self.freq_map:
            self.freq_map[node.freq] = DoublyLinkedList()

        self.freq_map[node.freq].add_node(node)

    def get(self, key: int) -> int:
        if key not in self.key_map:
            return -1

        node = self.key_map[key]
        self._update_freq(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return

        if key in self.key_map:
            node = self.key_map[key]
            node.value = value
            self._update_freq(node)
            return

        if len(self.key_map) >= self.capacity:
            lfu_list = self.freq_map[self.min_freq]
            node_to_remove = lfu_list.remove_last()
            del self.key_map[node_to_remove.key]

        new_node = Node(key, value)
        self.key_map[key] = new_node
        self.min_freq = 1

        if 1 not in self.freq_map:
            self.freq_map[1] = DoublyLinkedList()

        self.freq_map[1].add_node(new_node)