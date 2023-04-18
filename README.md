# There are 4 classes: Main, MyArrayList, MyLinkedList, MyList

## MyArrayList and MyLinkedList are implemented from interface MyList which has 11 methods:
### $\S1.$ size()
### $\S2.$ contains(Object o)
### $\S3.$ add(T item)
### $\S4.$ add(int index, T item)
### $\S5.$ remove(T item)
### $\S6.$ remove(int index)
### $\S7.$ clear()
### $\S8.$ get(int index)
### $\S9.$ indexOf(Object o)
### $\S10.$ lastIndexOf(Object o)
### $\S11.$ sort()

## First of all i need to tell about fields and other stuff in my classes

# MyArrayList
```java
private int sizeOfArrayList = 0;
private int capacity = 5;
private Object[] ArrayList = new Object[capacity];
```
## @sizeOfArraylist will represent the size of ArrayList
## @capacity will represent max capacity which could be in ArrayList
## @ArrayList will represent ArrayList as an array of Objects

# MyLinkedList
```java
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
```
## Class Node represent a node in LinkedList, it has its own field data,next,prev and a constructor which will save the element in a node
## field size in class MyLinkedList reprensents number of elemenents in LinkedList
## MyLinkedList has its own constructor which represents empty LinkedList

# $\S1.$ Method size()
## ArrayList
```java
public int size(){
        return sizeOfArrayList;
    }
```
### It just return variable which represents size of an ArrayList

## LinkedList
```java
public int size(){
        return size;
    }
```
### The same definition like in ArrayList

# $\S2.$ Method contains(Object o)
## ArrayList
```java
public boolean contains(Object o){
        int k = 0;
        for (int i = 0; i< sizeOfArrayList; i++) {
            if (ArrayList[i].equals(o)) {
                k = 1;
                break;
            }
        }
        return k != 0;
    }
```
### 1. It initializes an integer variable k to 0. This variable will be used to keep track of whether the object is found in the ArrayList or not.
### 2. It uses a for loop to iterate through the ArrayList. The loop runs from 0 to sizeOfArrayList - 1, where sizeOfArrayList is the current size of the ArrayList.
### 3. For each element in the ArrayList, it uses the equals() method to compare it with the input object "o". If the two objects are equal, it sets the value of k to 1 and breaks out of the loop.
### 4. After the loop, it checks the value of k. If k is equal to 1, it means the input object "o" was found in the ArrayList, so it returns true. Otherwise, it means the object was not found, so it returns false.
## LinkedList
```java
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
```
### 1. It initializes a node "currentHead" which equals to head and currentIndex and k which equals to 0
### 2. It uses a while loop to iterate through the linked list. The loop runs until the currentIndex is less than the size of the linked list. For each Node in the linked list, it uses the equals() method to compare the Node's data with the input object "e". If the two objects are equal, it sets the value of k to 1 and breaks out of the loop. At the end of each iteration variable currentIndex increments.
### 3. After the loop, it checks the value of k. If k is equal to 1, it means the input object "e" was found in the linked list, so it returns true. Otherwise, it means the object was not found, so it returns false.

# $\S3.$ Method add(T item)
## ArrayList
```java
public void add(Object item) {
        if (sizeOfArrayList == capacity){
            increaseSizeOfArrayList();
        }
        ArrayList[sizeOfArrayList++] = item;
    }
private void increaseSizeOfArrayList(){
        capacity = 2 * capacity;
        Object[] ArrayList2 = new Object[capacity];
        for(int i = 0; i < sizeOfArrayList; i++){
            ArrayList2[i] = ArrayList[i];
        }
        ArrayList = ArrayList2;
    }
```    
### 1. It uses two methods add(Object item) and increaseSizeOfArrayList(). Firstly it checks whether size of an ArrayList equals to its capacity. If yes, therefore, it calls method increaseSizeOfArrayList(). Otherwise, it increments sizeOfArrayList then add object to the array.
### 2. If method increaseSizeOfArrayList() was called. variable capacity increases by 2 times. Then it creates new ArrayList2 with a new capacity.
### 3. It uses a for loop to iterate through ArrayList to copy all elements of ArrayList to ArrayList2
### 4. Then ArrayList will be equal to ArrayList2, means that it will have more capacity
### 5. And after that it increments sizeOfArrayList then add object to the array.

## Linked List
```java
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
```
### 1. It creates a new Node "newNode" with the input object "e" as its data.
### 2. It checks if both head and tail of the linked list are null. If they are, it means the linked list is empty, so it sets head to the newNode. Otherwise, it sets the next reference of the current tail Node to the newNode, and sets the previous reference of the newNode to the current tail Node. This effectively adds the newNode to the end of the linked list.
### 3. It sets tail to the newNode, since the newNode is now the last Node in the linked list.
### 4. It increments the size of the linked list 

# $\S4.$ Method add(int index, T item)
## ArrayList
```java
public void add(int index, Object item) {
        if(index > sizeOfArrayList){
            System.out.println("Index out of bounds");
        }else{
            sizeOfArrayList++;
            Object[] ArrayList2 = new Object[capacity];
            for(int i = 0; i<index; i++){
                ArrayList2[i] = ArrayList[i];
            }
            ArrayList2[index] = item;
            index++;
            for(int i = index; i<sizeOfArrayList; i++){
                ArrayList2[i] = ArrayList[i-1];
            }
            ArrayList = ArrayList2;
        }
    }
```
### 1. It checks whether index is more that size of an arraylist. If yes, then it outputs "Index out of bounds". Otherwise, in increments a size, then creates new ArrayList2
### 2. It uses for loop and copy of elements which index is less than index to ArrayList2 from ArrayList
### 3. It adds an item to arraylist2
### 4. It uses again a for loop but it starts from index.
### 5. Then ArrayList will be equal to an ArrayList2

## Linked List
```java
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
```
### 1. It checks for the right index.
### 2. It creates a new node "newNode" and then checks for 3 different situations. When index = 0, index = size, and other.
### 3. If the input index is 0, it inserts the new node at the beginning of the linked list by setting its next reference to the current head node and updating the head node to point to the new node. It also sets the previous reference of the old head node to point to the new node. If the tail is null, it sets it to the new node since it is the only node in the list.
### 4. If the input index is equal to the size of the linked list, it inserts the new node at the end of the linked list by setting the next reference of the current tail node to the new node and updating the tail node to point to the new node. It also sets the previous reference of the new node to point to the current tail node.
### 5. If the input index is neither 0 nor equal to the size of the linked list, it iterates through the linked list using a for loop to find the node before the specified index. It then sets the next reference of the previous node to point to the new node and sets the previous reference of the new node to point to the previous node. It also sets the next reference of the new node to point to the next node and sets the previous reference of the next node to point to the new node.
### 6. Finally, it increments the size of the linked list to reflect the addition of the new node.

# $\S5.$ Method remove(T item)
## ArrayList
```java
public boolean remove(Object item) {
        if (contains(item)){
            int index = 0;
            Object[] ArrayList2 = new Object[capacity];
            for(int i = 0; i<sizeOfArrayList; i++){
                if (!ArrayList[i].equals(item)){
                    ArrayList2[index] = ArrayList[i];
                    index++;
                }
            }
            ArrayList = ArrayList2;
            sizeOfArrayList--;
            return true;
        }else{
            return false;
        }
    }
```
### 1. First of all, we use method contains(item) to be sure that item in arraylist. If yes, it creates index = 0 and a new arraylist2.
### 2. Then, it uses a for loop to find the index of the element we need to delete from out arraylist
### 3. When we found index, we use continue to prevent from adding that element to arraylist
### 4. Then, ArrayList will be equal to ArrayList2 without element that we need to delete, it decrement size and returns true
### 5. If we didn't find out element in ArrayList we return false.

## LinkedList
```java
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
```
### 1. The method starts by iterating over the doubly linked list, beginning at the head node. It checks whether the data stored in the current node is equal to the input item using the equals() method. If a match is found, the node is removed from the list.
### 2. If the node to be removed is the head node, the head pointer is updated to point to the next node in the list. If the node to be removed is the tail node, the tail pointer is updated to point to the previous node in the list. If the node to be removed is neither the head nor the tail node, the previous node's next pointer is set to the current node's next pointer, and the next node's previous pointer is set to the current node's previous pointer.
### 3. Finally, the method decrements the size of the doubly linked list and returns true if an item was removed successfully. If no match is found, the method returns false.

# $\S6.$ Method remove(int index)
## ArrayList
```java
public void remove(int index) {
        if (index < 0 || index >= sizeOfArrayList){
            throw new IndexOutOfBoundsException("Index out of array's bounds" + index);
        }else{
            int indexInArray = 0;
            Object[] ArrayList2 = new Object[capacity];
            for(int i = 0; i<sizeOfArrayList; i++){
                if (i == index){
                    continue;
                }
                ArrayList2[indexInArray] = ArrayList[i];
                indexInArray++;
            }
            sizeOfArrayList--;
            ArrayList = ArrayList2;
        }
    }
```
### 1. We checks for valid index
### 2. Then it uses a for loop. And when we found our index. we use continue to prevent if from adding to our new arraylist
### 3. Then, it decrement size and ArrayList = ArraList2

## Linked List
```java
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
        else if (index == size){
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
```
### 1. Firstly, we check for valid index
### 2. If the index is zero, the head of the list is set to the next node, and the previous pointer of the new head is set to null. This effectively removes the first item in the list.
### 3. If the index is equal to the size of the list, the tail of the list is set to the previous node, and the next pointer of the new tail is set to null. This effectively removes the last item in the list.
### 4. If the index is neither zero nor equal to the size of the list, the method uses a loop to traverse the list until it reaches the node at the specified index.
### 5. Once the node at the specified index is found, its previous node's next pointer is set to its next node, and its next node's previous pointer is set to its previous node and the size of the list is decremented

# $\S7.$ Method clear()
## ArrayList
```java
public void clear() {
        ArrayList = new Object[5];
    }
```
### 1. We say that ArrayList will be a new array

## Linked List
```java
public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
```
### 1. We say that head, tail will be null, and size = 0, which in turn will cause all the nodes to be eligible for garbage collection

# $\S8.$ Method get(int index)
## ArrayList
```java
public Object get(int index) {
        return ArrayList[index];
    }
```
### 1. It will return an element from array

## Linked List
```java
public Object get(int index) {
        if (index<0 || index > size){
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
```
### 1. It checks for valid index
### 2. It creates new node "currentNode" and currentIndex = 0
### 3. It uses a while loop to find a right node
### 4. Then it return a field data which containg element

# $\S9.$ Method indexOf(Object o)
## ArrayList
```java
public int indexOf(Object o) {
        int index = -1;
        for(int i = 0; i<sizeOfArrayList; i++){
            if (ArrayList[i].equals(o)){
                index = i;
                break;
            }
        }
        return index;
    }
```
### 1. It uses for loop to find ArrayList[i] which equals to element and return its index
### 2. If it can't find it return index which equals -1
## Linked List
```java
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
```
### 1. It created node "currentNode" which equals to head and index = 0
### 2. It uses while loop to find right index and going to the next node. If it found it return index. Otherwise it return -1
# $\S10.$ Method lastIndexOf(Object o)
## ArrayList
```java
public int lastIndexOf(Object o) {
        int index = -1;
        for(int i = sizeOfArrayList - 1; i >= 0; i--){
            if (ArrayList[i].equals(o)){
                index = i;
                break;
            }
        }
        return index;
    }
```
### 1. It's like previous method but it starts from the end of an array

## Linked List
```java
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
```
### 1. It's like previous method but it starts from the tail of Linked List
# $\S11.$ Method sort()
## ArrayList
```java
public void sort() {
        for(int i = 1; i<sizeOfArrayList;i++){
            Object key = ArrayList[i];
            int j = i -1;
            while (j >= 0 && ((Comparable) ArrayList[j]).compareTo(key) > 0){
                ArrayList[j+1] = ArrayList[j];
                j = j -1;
            }
            ArrayList[j+1] = key;
        }
    }
```
### 1. A loop is initiated that iterates through the arraylist from index 1 to sizeOfArrayList-1. For each iteration of the loop, the current element at the i-th index is stored in a variable called "key".
### 2. A variable j is initialized to i-1. This variable will be used to traverse the sub-array to the left of the key element. 
### 3. A while loop is initiated that runs as long as j is greater than or equal to 0 and the element at the j-th index is greater than the key element. Inside the while loop, the element at the j-th index is shifted one position to the right (i.e., ArrayList[j+1] = ArrayList[j]). The value of j is then decremented by 1.
### 4. After the while loop ends, the key element is inserted into its correct position in the sub-array. The value of j has already been decremented by 1, so the key element is inserted at index j+1.
### 5. Steps 2-6 are repeated until the loop has iterated through the entire arraylist.

## LinkedList
```java
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
```
### 1. The method first checks if the size of the list is less than or equal to 1. If so, the list is already sorted, and the method simply returns without doing anything.
### 2. If the size of the list is greater than 1, the method initializes a "current" variable to point to the second node in the list, since the first node is already considered sorted.
### 3. The method then iterates over the remaining nodes of the list. For each node, the data of the node is extracted and compared with the data of the nodes that come before it in the sorted part of the list. The "previous" variable is initialized to point to the node immediately before the current node.
### 4. The method then enters a loop that moves backward through the sorted part of the list, comparing the data of each node with the data of the current node. If the data of a node in the sorted part of the list is greater than the data of the current node, the data of that node is moved to the next node, creating a space for the current node to be inserted.
### 5. This process continues until a node is reached whose data is less than or equal to the data of the current node, or until the beginning of the sorted part of the list is reached. At this point, the current node is inserted into the list immediately after the previous node.
### 6. If the previous variable is null, then the current node is the smallest node in the list, and it becomes the new head of the list. Otherwise, the current node is inserted into the correct position in the list by updating the data of the node that comes after previous.
### 7. The loop then continues with the next node in the list until all nodes have been processed.


    
    
    
