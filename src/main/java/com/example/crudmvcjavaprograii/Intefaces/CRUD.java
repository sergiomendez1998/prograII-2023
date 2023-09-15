
package com.example.crudmvcjavaprograii.Intefaces;

import java.util.List;


public interface CRUD<T> {
    public List listar();
    public T list(int id);
    public boolean add(T entity);
    public boolean edit(T entity);
    public boolean eliminar(int id);
}
