package telran.interview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray<T>
{
    private T[] my_array;

    public void setAll(T value)
    {
        Arrays.fill(my_array, value);
    }

    public void set(int index, T value)
    {
        if (index < 0 || index >= my_array.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        my_array[index] = value;
    }

    public T get(int index)
    {
        if (index < 0 || index >= my_array.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return my_array[index];
    }
    public MyArray(int size)
    {
        if (size <= 0) {
            throw new ArrayStoreException("Size cannot be zero or less");
        }
        my_array = (T[]) Array.newInstance(Object.class, size);
    }
}
