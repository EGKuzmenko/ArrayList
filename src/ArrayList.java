import java.util.*;

public class ArrayList<T> implements List<T> {

    private T[] m;

    private int size;

    public ArrayList(final int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        m =(T[]) new Object[initialCapacity];
        size = 0;
    }

    public ArrayList() {
        m =(T[]) new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (int i = 0; i < this.size; i++) {
            if (m[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        final T[] newM =(T[]) new Object[this.size];
        System.arraycopy(m, 0, newM, 0, this.size);
        return newM;
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        if (a == null) {
            throw new NullPointerException();
        }

        if (a.length < this.size) {
            return (T1[]) Arrays.copyOf(m, this.size(), a.getClass());
        }

        System.arraycopy(m, 0, a, 0, this.size);

        if (a.length > this.size) {
            a[this.size] = null;
        }
        return a;
    }

    @Override
    public boolean add(final T t) {
        if (m.length == this.size) {
            final T[] oldM = m;
            m = (T[]) new Object[this.size * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
        }
        m[this.size++] = t;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < this.size; i++) {
            if (m[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        for (final T item : c) {
            this.add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        if (c == null)
            throw new NullPointerException();

        for (final T item : c) {
            add(index, item);
        }

        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        for (final Object item : c) {
            if (this.contains(item)) {
                remove(item);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        for (final Object item : this) {
            if (!c.contains(item)) {
                this.remove(item);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        m =(T[]) new Object[1];
        size = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(final int index, final T element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (m.length == this.size) {
            final T[] oldM = m;
            m =(T[]) new Object[this.size * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
        }

        System.arraycopy(m, index, m, index + 1, this.size - index);
        m[index] = element;
        size++;

    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        final T element = m[index];
        if (index != this.size - 1)
            System.arraycopy(m, index + 1, m, index, this.size - index - 1);
        size--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
