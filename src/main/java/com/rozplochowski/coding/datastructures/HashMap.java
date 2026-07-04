package com.rozplochowski.coding.datastructures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K, V> implements Iterable<HashMap.Pair<K, V>> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private final double loadFactor;
    private int currentModifications;

    @SuppressWarnings("unchecked")
    public HashMap(int size, double loadFactor) {
        buckets = new LinkedList[size];
        this.loadFactor = loadFactor;
    }

    public HashMap(double loadFactor) {
        this(16, loadFactor);
    }

    public HashMap() {
        this(16, 0.75);
    }

    public void put(K key, V value) {
        if (shouldResize()) resize();

        var index = getBucketIndex(key);
        var bucket = buckets[index];

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }

        if (bucket.isEmpty()) {
            bucket.add(new Entry<>(key, value));
        } else {
            for (var entry : bucket) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    currentModifications++;
                    return;
                }
            }
        }

        currentModifications++;
        size++;
    }

    public V get(K key) {
        if (key == null) return null;
        var entry = find(key);
        return entry == null ? null : entry.value;
    }

    public boolean containsKey(K key) {
        if (key == null) return false;
        return find(key) != null;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new HashMapIterator();
    }

    private class HashMapIterator implements Iterator<Pair<K, V>> {
        private LinkedList<Entry<K, V>> bucket;
        private Iterator<Entry<K, V>> iterator;
        private int index;
        private int current;
        private final int modifications = currentModifications;

        private HashMapIterator() {
            for (var i = 0; i < buckets.length; i++) {
                if (buckets[i] != null && !buckets[i].isEmpty()) {
                    bucket = buckets[i];
                    index = i;
                    iterator = bucket.iterator();
                    break;
                }
            }

        }

        @Override
        public boolean hasNext() {
            if (currentModifications != modifications) throw new ConcurrentModificationException();

            return current < size;
        }

        @Override
        public Pair<K, V> next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();

            if (!iterator.hasNext()) {
                for (var i = index + 1; i < buckets.length; i++) {
                    if (buckets[i] != null && !buckets[i].isEmpty()) {
                        bucket = buckets[i];
                        index = i;
                        iterator = bucket.iterator();
                        break;
                    }
                }
            }

            current++;
            var entry = iterator.next();
            return new Pair<>(entry.key, entry.value);
        }

    }

    private Entry<K, V> find(K key) {
        var index = getBucketIndex(key);
        var bucket = buckets[index];

        if (bucket == null) return null;

        for (var entry : bucket) {
            if (entry.key.equals(key)) return entry;
        }

        return null;
    }

    public boolean remove(K key) {
        if (key == null) return false;

        var index = getBucketIndex(key);
        var bucket = buckets[index];

        if (bucket == null) return false;

        var iter = bucket.iterator();
        while (iter.hasNext()) {
            var entry = iter.next();
            if (entry.key.equals(key)) {
                iter.remove();
                size--;
                currentModifications++;
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        var hash = key.hashCode();
        return hash % buckets.length;
    }

    private boolean shouldResize() {
        return size > loadFactor * buckets.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        var newCapacity = (int) (buckets.length * 1.5);
        var temp = buckets;

        buckets = new LinkedList[newCapacity];

        for (var bucket : temp) {
            if (bucket != null) {
                for (var entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public record Pair<K, V>(K key, V value) {
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}


