package ru.webdev.collections;

import java.util.Arrays;

// добавлен параметр типа T
public class ArrayDynamic<T> {

    private Object[] elements = new Object[0];

    public T get(int index) {
        return (T) elements[index];
    }

    public void add(T element) {
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = element;
    }

    public T remove(int index){
        Object result = null;
        Object[] newArray = new Object[elements.length - 1];
        for (int i = 0, j = 0; i < elements.length; i++, j++){
            if(i == index){
                result = elements[i];
                j--;
            } else {
                newArray[j] = elements[i];
            }
        }
        elements = newArray;
        return (T) result;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

}
