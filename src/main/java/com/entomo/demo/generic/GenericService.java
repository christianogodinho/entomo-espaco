package com.entomo.demo.generic;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class GenericService<EntityT extends GenericEntity<EntityT>, RequestT, ResponseT> {

    protected final GenericRepository<EntityT> repository;

    protected final ModelMapper modelMapper;

    public GenericService(GenericRepository<EntityT> repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public abstract EntityT mapToEntityFromRequest(RequestT request);

    public abstract ResponseT mapToResponse(EntityT entity);

    public Page<EntityT> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<ResponseT> getAll(){
        return repository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ResponseT get(Integer id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com id: " + id));
        return this.mapToResponse(entity);
    }

    @Transactional
    public ResponseT update(Integer id, RequestT updatedRequest){

        var dbDomain = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com id: " + id)); // Makes sure that entity exists in DB
        dbDomain = mapToEntityFromRequest(updatedRequest);
        dbDomain.setId(id);
        dbDomain = repository.save(dbDomain);

        return mapToResponse(repository.save(dbDomain));
    }

    @Transactional
    public ResponseT create(RequestT entityRequest){
        EntityT entity = mapToEntityFromRequest(entityRequest);
        entity = repository.save(entity);
        return mapToResponse(entity);
    }

    @Transactional
    public List<ResponseT> createMany(List<RequestT> requestList){

        List<EntityT> entities = requestList.stream()
                .map(this::mapToEntityFromRequest)
                .toList();

        entities = repository.saveAll(entities);

        return entities.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public ResponseT patch(Integer id, Map<String, Object> updates) {
        EntityT dbEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com id: " + id));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            Field field = ReflectionUtils.findField(dbEntity.getClass(), entry.getKey());
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, dbEntity, entry.getValue());
            }
        }

        EntityT updatedEntity = repository.save(dbEntity);
        return mapToResponse(updatedEntity);
    }

    @Transactional
    public ResponseT delete(Integer id) {
        ResponseT existing = get(id);
        repository.deleteById(id);
        return existing;
    }

    @Transactional
    public void deleteAll(){
        repository.deleteAll();
    }
}
