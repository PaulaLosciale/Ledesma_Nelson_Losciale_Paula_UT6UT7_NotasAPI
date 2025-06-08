package com.appnelsonpaula.notasapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, ID, R extends JpaRepository<T, ID>> implements CrudService<T, ID> {
    protected final R repository;
    
    public AbstractCrudService(R repository) {
        this.repository = repository;
    }
    
    @Override
    public List<T> getAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }
    
    @Override
    public T save(T entity) {
        return repository.save(entity);
    }
    
    @Override
    public T update(ID id, T entity) {
        return repository.save(entity);
    }
    
    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}