public class MyLinkedList implements MyList{
    private static class Node{
        Object data;
        Node next;
        Node prev;

        public Node(Object data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object e){
        Node newNode = new Node(e);

        if (head == null && tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, Object item) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        Node newNode = new Node(item);

        if (index == 0){
            newNode.next = head;
            if (head != null){
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null){
                tail = newNode;
            }
        }
        else if (index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++){
                currentNode = currentNode.next;
            }
            Node nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.prev = currentNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    public boolean remove(Object item) {
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.data.equals(item)){
                if (currentNode == head){
                    head = head.next;
                    if (head != null){
                        head.prev = null;
                    }
                }
                else if (currentNode == tail){
                    tail = tail.prev;
                    if (tail != null){
                        tail.next = null;
                    }
                }else{
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    public void remove(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if (index == 0){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
        }
        else if (index == size - 1){
            tail = tail.prev;
            if (tail != null){
                tail.next = null;
            }
        }else{
            Node currentNode = head;
            for (int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public Object get(int index) {
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        Node currentNode = head;
        int currentIndex = 0;

        while (currentIndex<index){
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.data;
    }

    public int indexOf(Object o) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node currentNode = tail;
        int index = size - 1;
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }
            index--;
            currentNode = currentNode.prev;
        }
        return -1;
    }

    public void sort() {
        if (size <= 1) {
            return;
        }
        Node current = head.next;
        while (current != null) {
            Object data = current.data;
            Node previous = current.prev;
            while (previous != null && ((Comparable)previous.data).compareTo(data) > 0) {
                previous.next.data = previous.data;
                previous = previous.prev;
            }
            if (previous == null) {
                head.data = data;
            } else {
                previous.next.data = data;
            }
            current = current.next;
        }
    }


    public int size(){
        return size;
    }

    public boolean contains(Object e) {
        Node currentHead = head;
        int currentIndex = 0;
        int k = 0;
        while (currentIndex<size){
            if (currentHead.data.equals(e)) {
                k = 1;
                break;
            }
            currentIndex++;
            currentHead = currentHead.next;
        }
        return k == 1;
    }


}
