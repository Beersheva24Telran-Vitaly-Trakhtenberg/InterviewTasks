package telran.interview;

import java.util.HashMap;
import java.util.Map;

public class MyArray<T>
{
    private final Map<Integer, T> myMap;
    private final int size;

    public MyArray(int size)
    {
        if (size <= 0) {
            throw new IllegalArgumentException("Size cannot be zero or less");
        }
        this.size = size;
        myMap = new HashMap<>(size);
    }

    public void setAll(T value)
    {
        for (int i = 0; i < size; i++) {
            myMap.put(i, value);
        }
    }

    public void set(int index, T value)
    {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        myMap.put(index, value);
    }

    public T get(int index)
    {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return myMap.get(index);
    }
}