package ru.webdev.collections;

import java.util.Arrays;

public class ArrayDynamic {

    private Object[] elements = new Object[0];

    public Object get(int index) {
        return elements[index];
    }

    public void add(Object element) {
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = element;
    }

    public Object remove(int index){
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
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

}
