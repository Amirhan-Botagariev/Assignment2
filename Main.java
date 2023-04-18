public class Main {
    public static void main(String[] args) {
        //ArrayList
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(56);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(100);
        arrayList.add(1000);
        arrayList.add(585);
        arrayList.add(5, 1);
        arrayList.remove((Object) 56);
        arrayList.remove(0);
        arrayList.get(5);
        arrayList.indexOf(100);
        arrayList.lastIndexOf(585);
        System.out.println(arrayList.contains(56));
        System.out.println(arrayList.size());
        arrayList.sort();
        arrayList.clear();



        //Linked List
        MyLinkedList LinkedList = new MyLinkedList();
        LinkedList.add(3);
        LinkedList.add(4);
        LinkedList.add(5);
        LinkedList.size();
        System.out.println(LinkedList.get(0));
        LinkedList.add(1, 10);
        LinkedList.remove((Object) 10);
        LinkedList.remove(0);
        System.out.println(LinkedList.indexOf(4));
        System.out.println(LinkedList.lastIndexOf(5));
        LinkedList.indexOf(100);
        LinkedList.contains(5);
        LinkedList.add(100);
        LinkedList.add(10);
        LinkedList.sort();
        LinkedList.size();
        LinkedList.clear();
    }
}
