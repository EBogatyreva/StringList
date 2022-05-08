package pro.sky.java.course2;

import java.util.Arrays;

public class StringListImpl implements StringListInterface {
    private final int INIT_SIZE = 16;//изначальная max емкость
    private final int CUT_RATE = 4;
    private String[] array = new String[INIT_SIZE];
    private int pointer = 0;

    @Override
    public String add(String item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (pointer == array.length - 1)
            throw new IndexOutOfBoundsException();
        array[index] = item;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        if (index < 0 || index > array.length - 1)
            throw new IndexOutOfBoundsException();
        array[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        Integer a = 0;
        for (int i = 0; i < pointer; i++) {
            if (!(array[i] == item)) a = 1;//!
            else if (array[i] == item)
                array[i] = array[i + 1];
        }

        if (a == 1) throw new IndexOutOfBoundsException();
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
        return item;
    }

    @Override
    public String remove(int index) {
        Integer a = 0;
        for (int i = index; i < pointer; i++) {
            if (array[index] == null) a = 1;
            else array[i] = array[i + 1];
        }
        if (a == 1) throw new IndexOutOfBoundsException();
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
        return String.valueOf(index);
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (array[index] == null) throw new IndexOutOfBoundsException();
        if (index > array.length - 1) throw new IndexOutOfBoundsException();
        return (String) array[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        return false;
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return pointer;
    }

    /*add method for scaling*/
    @Override
    public void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);//old massive copy to new
        array = (String[]) newArray;
    }

    //для себя
    public void printAll() {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.println(array[i]);
        }
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        if (item == null) {
            for (int i = 0; i < pointer; i++)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = 0; i < pointer; i++)
                if (item.equals(array[i]))
                    return i;
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        return lastIndexOfRange(item, 0, pointer);
    }

    private int lastIndexOfRange(Object o, int start, int end) {
        Object[] es = array;
        if (o == null) {
            for (int i = end - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        int modCount = 0;
        modCount++;
        final Object[] es = array;
        for (int to = pointer, i = pointer = 0; i < to; i++)
            es[i] = null;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, pointer);
    }


}
