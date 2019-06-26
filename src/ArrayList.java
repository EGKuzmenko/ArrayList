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
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] newM = (T[]) new Object[this.size];
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
        if (index < 0 || index >= this.size)
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
                remove(item);
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
    public T get(final int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        return m[index];
    }

    @Override
    public T set(final int index,final T element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        final T prevElement = m[index];
        m[index] = element;
        return prevElement;
    }

    @Override
    public void add(final int index, final T element) {
        if (index < 0 || index >= this.size) {
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
    public T remove(final int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        final T element = m[index];
        if (index != this.size - 1)
            System.arraycopy(m, index + 1, m, index, this.size - index - 1);
        m[--size] = null;
        return element;
    }

    @Override
    public int indexOf(final Object o) {
        for (int i = 0; i < this.size; i++) {
            if (m[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Object o) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (m[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator();
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        return null;
    }

    private class ElementsIterator implements ListIterator<T> {

        private static final int LAST_IS_NOT_SET = -1;

        private int index;

        private int lastIndex = LAST_IS_NOT_SET;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return ArrayList.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastIndex = index++;
            return ArrayList.this.m[lastIndex];
        }

        @Override
        public boolean hasPrevious() {
            return index != 0;
        }

        @Override
        public T previous() {
            if (hasPrevious() || ArrayList.this.size() == 0) {
                throw new NoSuchElementException();
            }
            final int prevIndex = previousIndex();
            lastIndex = prevIndex;
            index--;
            return ArrayList.this.m[lastIndex];
        }

        @Override
        public int nextIndex() {
            return ArrayList.this.size() == index ? ArrayList.this.size() : index;
        }

        @Override
        public int previousIndex() {
            if (index == 0) return LAST_IS_NOT_SET;
            return index - 1;
        }

        @Override
        public void remove() {
            if (lastIndex == LAST_IS_NOT_SET){
                throw new IllegalStateException();
            }
            ArrayList.this.remove(lastIndex);
            index--;
            lastIndex = LAST_IS_NOT_SET;
        }

        @Override
        public void set(final T t) {
            if (lastIndex == LAST_IS_NOT_SET) {
                throw new IllegalStateException();
            }
            ArrayList.this.set(lastIndex, t);
        }

        @Override
        public void add(final T t) {
            ArrayList.this.add(index, t);
            index++;
            lastIndex = LAST_IS_NOT_SET;
        }

    }
}
