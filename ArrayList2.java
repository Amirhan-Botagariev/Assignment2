import java.util.ArrayList;

public class ArrayList2 {
    private int capacity = 50;
    private int size = 0;
    private int[] ArrayList = new int[capacity];

    public void addAll(int index, ArrayList<Integer> toInsert){
        if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
        }
        
        int x = 0, y = 0;
        int[] ArrayList2 = new int[capacity];
        for (int i = 0; i < index; i++){
            ArrayList2[i] = ArrayList[i];
            x++;
        }
        for (int i = 0; i < toInsert.size(); i++){
            ArrayList2[x] = toInsert.get(y);
            x++;
            y++;
            size++;
        }
        y = index;
        while (ArrayList[y] != 0){
            ArrayList2[x] = ArrayList[y];
            y++;
            x++;
        }
        ArrayList = ArrayList2;
        reduceRedundant();
    }

    public void add(int item) {
        if (size == capacity){
            increaseSizeOfArrayList();
        }
        ArrayList[size++] = item;
    }
    private void increaseSizeOfArrayList(){
        capacity = 2 * capacity;
        int[] ArrayList2 = new int[capacity];
        for(int i = 0; i < size; i++){
            ArrayList2[i] = ArrayList[i];
        }
        ArrayList = ArrayList2;
    }

    private void reduceRedundant(){
        int k = size;
        capacity = k;
        int[] ArrayList2 = new int[capacity];
        for (int i = 0; i < k; i++){
            ArrayList2[i] = ArrayList[i];
        }
        ArrayList = ArrayList2;
    }




}
