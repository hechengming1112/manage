package admin.com.student.test.map;

/**
 * @param <K>
 * @param <V>
 * @author 和诚明
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    //数组的默认初始化长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;

    private float defaultLoadFactor;

    //Map当中entry的数量
    private int entryUseSize;

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    public static void main(String[] args) {
    }
}
