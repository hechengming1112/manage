package admin.com.student.test.collection;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * 基于jdk1.8
 *
 * @param <E>
 */

public class ArrayListDemo<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    /**
     * 元素数组
     */
    transient Object[] elementData;

    /**
     * 已使用的数组大小
     */
    private int size;


    /**
     * 共享的空数组对象
     * <p>
     * 在{@link #ArrayListDemo(int)} 或 {@link #ArrayListDemo(Collection)} 构造方法中
     * 如果传入的初始化大小或集合为0时，将{@link #elementData} 指向它
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 默认初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 共享的空数组对象，用于{@link #ArrayListDemo()} 构造方法
     * <p>
     * 通过使用该静态变量 和{@link #EMPTY_ELEMENTDATA} 区分开来，在第一次添加元素时。
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public ArrayListDemo() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public ArrayListDemo(int initialCapacity) {
        //初始化对象大于0时，创建object数组
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        }
        //初始化等于0时，使用 EMPTY_ELEMENTDATA 对象
        else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;

        }
        //初始化对象小于0时，抛出 IllegalArgumentException 异常
        else {
            throw new IllegalArgumentException("Illegal  Capacity:" + initialCapacity);
        }

    }

    public ArrayListDemo(Collection<? extends E> c) {
        //将 c 转化为Object数组
        elementData = c.toArray();
        //如果数组大小大于0
        if ((size = elementData.length) > 0) {
            //如果集合元素不是object[]类型，则会创建新的 object[] 数组，并将 elementData 赋值到其中，最后赋值给 elementData
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }

        }
        //如果数组大小等于0 使用 EMPTY_ELEMENTDATA
        else {
            this.elementData = EMPTY_ELEMENTDATA;
        }

    }

    /**
     * 添加数据
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 根据下标插入
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);

        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;

    }

    /**
     * 添加集合元素
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] array = c.toArray();
        int numNew = array.length;
        ensureCapacityInternal(size + numNew);
        System.arraycopy(array, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] array = c.toArray();
        int numNew = array.length;
        ensureCapacityInternal(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        }
        System.arraycopy(array, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;

    }

    /**
     * 根据下标删除
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //防止数组越界
        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;

        return oldValue;

    }

    /**
     * 删除对象
     *
     * @param o 对传进来的对象进行区分处理
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 针对集合进行删除
     *
     * @param c
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        //判空，是的话抛出空指针异常
        Objects.requireNonNull(c);
        return batchRemove(c, false);

    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementDate = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++) {
                if (c.contains(elementDate[r]) == complement) {
                    elementDate[w++] = elementDate[r];
                }
            }

        } finally {

            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; i++) {
                    elementDate[i] = null;
                }
                modCount += size - w;
                size = w;
                modified = true;
            }

        }
        return modified;

    }

    /**
     * 更新数据
     *
     * @param index
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;

    }

    /**
     * @param index
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }


    public void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }


    private void rangeCheckForAdd(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public String outOfBoundsMsg(int index) {
        return "index: " + index + ", size:" + size;
    }


    /**
     * 扩容机制
     */

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /*
     判断当前数组是否是默认构造方法生成的空数组，
     如果是的话minCapacity=10,反之则根据原来的值传入下一个方法去完成下一步的扩容判断*/
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //计算最大值
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    //minCapacity表示修改后的数组容量，minCapacity = size + 1

    private void ensureCapacityInternal(int minCapacity) {
        //判断是是否要扩容
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));

    }

    //判断当前ArrayList是否要扩容

    private void ensureExplicitCapacity(int minCapacity) {
        // 快速报错机制
        modCount++;
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }





    /*
     * java容器的快速报错机制 ConcurrentModificationException
     * */

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor;         //下一个要返回的索引
        int lastRet = -1;   //返回最后一个元素的索引
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayListDemo.this.elementData;
            if (i > elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();

            try {
                ArrayListDemo.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;

            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }

        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayListDemo.this.size;
            int i = cursor;
            if (i > size) {
                return;
            }
            final Object[] elementData = ArrayListDemo.this.elementData;
            if (i > elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            cursor = i;
            lastRet = i - 1;
            checkForComodification();

        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /*@Override
    public E remove(int index){
        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved=  size - index -1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;

    }*/







    /*@Override
    public boolean add(E e){
        //增加数组修改次数
        modCount++;
        //添加元素
        add(e,elementData,size);
        //返回添加成功
        return true;
    }
    public void add(E e,Object[] elementData,int s){
        //如果容量不够，进行扩容
        if (s == elementData.length){
            elementData=grow();
            //设置到末尾
            elementData[size] = e;
            //数量加一
            size=s+1;
        }
    }*/


  /*  @Override
    public void add(int index, E element) {
        //校验位置是否在数组范围内
        rangeCheckForAdd(index);
        //增加数组修改次数
        modCount++;
        //如果数组大小不够，进行扩容
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
            //将index+1 位置的开始的元素，进行往后挪
            System.arraycopy(elementData,index,elementData,index+1,s - index);


        //设置到指定位置
        elementData[index] = element;
        //数组大小加一
        size = s+1;

    }

    public void rangeCheckForAdd(int index){
        if (index>size || index<0){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    private static String outOfBoundsMsg(int index){
      return "index" + index;
    }*/

    /*
     * 数组扩容
     * @return
     * jdk1.7
     *
    public Object[] grow(){
        //要求扩容后至少比原有大1。因为是最小扩容的要求，实际是允许比它大
        return elementData;
    }*/


    @Override
    public int size() {
        return size;
    }


}
