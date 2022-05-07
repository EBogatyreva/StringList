package pro.sky.java.course2;

import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);

        StringListImpl stringList = new StringListImpl();
        System.out.println(stringList.add("1"));
        System.out.println(stringList.add("5"));
        System.out.println(stringList.contains("1"));
        System.out.println(stringList.get(1));
        stringList.printAll();
        stringList.clear();
        System.out.println(stringList.size());
        System.out.println("_______________");

        System.out.println(stringList.add("10"));
        System.out.println(stringList.add("20"));
        stringList.equals(arrayList);
        stringList.remove(0);
        System.out.println(stringList.size());
        System.out.println("_______________");

        System.out.println(stringList.add("100"));
        System.out.println(stringList.size());
        stringList.printAll();

        System.out.println(stringList.toArray());

        System.out.println(stringList.isEmpty());
        System.out.println(stringList.lastIndexOf("100"));
        System.out.println(stringList.indexOf("0"));
        System.out.println(stringList.remove("5"));
    }
}
