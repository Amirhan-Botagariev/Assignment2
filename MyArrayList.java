public class MyArrayList implements MyList{
    private int sizeOfArrayList = 0;
    private int capacity = 5;
    private Object[] ArrayList = new Object[capacity];

    public int size(){
        return sizeOfArrayList;
    }

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

    public void clear() {
        ArrayList = new Object[5];
    }

    public Object get(int index) {
        return ArrayList[index];
    }

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

}
