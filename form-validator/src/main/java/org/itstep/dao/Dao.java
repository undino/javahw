package org.itstep.dao;


public interface Dao<T> {
    abstract public int save(T t);
}
