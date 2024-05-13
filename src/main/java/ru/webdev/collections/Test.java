package ru.webdev.collections;

public class Test {

    public static void main(String[] args) {

//        java.util.List<Object> objects = new ArrayList<? extends Object>();
//        java.util.HashSet<Number> hs = new java.util.HashSet<Integer>();
//        java.util.List<Object> values = new java.util.HashSet<Object>();
        java.util.Map<String, ? extends Number> hm = new java.util.HashMap<String, Integer>();
        java.util.HashSet<? super ClassCastException> set = new java.util.HashSet<Exception>();
//        java.util.List<String> list = new Vector<String>();

        }


}
