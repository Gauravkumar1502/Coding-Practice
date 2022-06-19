package dsa.datastructures;

public class ArrayList {
    private int[] array;
    private int capacity;
    private int length;

    public enum Order {
        ASCENDING,
        DESCENDING
    }

    public ArrayList() {
        length = 0;
        capacity = 10;
        array = new int[capacity];
    }

    public ArrayList(int capacity) {
        length = 0;
        this.capacity = capacity;
        array = new int[capacity];
    }

    public ArrayList(int[] arr) {
        capacity = arr.length * 2;
        array = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        length = arr.length;
    }

    public void add(int element) {
        if (isFull()) {
            grow();
        }
        array[length] = element;
        length++;
    }

    public void add(int index, int element) {
        if (isFull()) {
            grow();
        }
        for (int i = length; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        length++;
    }

    public void addAll(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
        // OR
        /*
         * int newLength = length + arr.length;
         * if (newLength >= capacity) {
         * grow(arr.length);
         * }
         * 
         * int i = 0;
         * while (length < newLength) {
         * array[length++] = arr[i++];
         * }
         */
    }

    public void addAll(int index, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(index + i, arr[i]);
        }
        // OR
        /*
         * int newLength = length + arr.length;
         * if (newLength >= capacity) {
         * grow(arr.length);
         * }
         * for (int i = newLength - 1; i >= index + arr.length; i--) {
         * array[i] = array[i - arr.length];
         * }
         * for (int i = 0; i < arr.length; i++) {
         * array[index++] = arr[i];
         * }
         * length += arr.length;
         * }
         */
    }

    public void set(int index, int element) {
        array[index] = element;
    }

    public void sort() {
        sort(Order.ASCENDING);
    }

    public void sort(Order order) {
        if (order == Order.ASCENDING) {
            sortAscending();
        } else {
            sortDescending();
        }
    }

    private void sortDescending() {

    }

    private void sortAscending() {
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void clear() {
        length = 0;
        // (Optional) use this to reset the capacity to the default value
        capacity = 10;
        array = new int[capacity];
    }

    public int remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        int removed = array[index];
        for (int i = index; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        length--;
        return removed;
    }

    public void removeAll(int... elements) {
        for (int element : elements) {
            int index = indexOf(element);
            if (index != -1) {
                remove(index);
            }
        }
    }

    public ArrayList clone() {
        ArrayList arrayList = new ArrayList(capacity);
        for (int i = 0; i < length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    // exculding element at index to
    public int[] subList(int fromIndex, int to) {
        if (fromIndex > to) {
            throw new IllegalArgumentException("Starting index is greater than ending index");
        }
        if (fromIndex < 0 || fromIndex > length) {
            throw new IndexOutOfBoundsException();
        }
        if (to < 0 || to > length) {
            throw new IndexOutOfBoundsException();
        }
        int[] subList = new int[to - fromIndex];
        for (int i = fromIndex; i < to; i++) {
            subList[i - fromIndex] = array[i];
        }
        return subList;
    }

    public int[] toArray() {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    public boolean contains(int element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        return array[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(int fromIndex, int element) {
        for (int i = fromIndex; i < length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // excluding element at index to
    public int indexOf(int fromIndex, int to, int element) {
        for (int i = fromIndex; i < to; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void grow(int extra) {
        capacity += extra;
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }

    public int length() {
        return length;
    }

    public int capacity() {
        return capacity;
    }

    public String join(String joiner) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            sb.append(array[i]);
            sb.append(joiner);
        }
        sb.append(array[length - 1]);
        return sb.toString();
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(array[i] + ", ");
        }
        // remove last comma and space
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
