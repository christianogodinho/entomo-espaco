package com.entomo.demo.collection_item;

import com.entomo.demo.collection_item.entities.dto.CollectionItemRequest;
import com.entomo.demo.collection_item.entities.dto.CollectionItemResponse;
import com.entomo.demo.collection_item.entities.persistence.CollectionItem;
import com.entomo.demo.generic.GenericService;
import com.entomo.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionItemService extends GenericService<CollectionItem, CollectionItemRequest, CollectionItemResponse> {

    @Autowired
    public CollectionItemService(CollectionItemRepository collectionItemRepository) {super(collectionItemRepository, Util.getMapper());}

    @Override
    public CollectionItem mapToEntityFromRequest(CollectionItemRequest collectionItemRequest) {
        return super.modelMapper.map(collectionItemRequest, CollectionItem.class);
    }

    @Override
    public CollectionItemResponse mapToResponse(CollectionItem collectionItem) {
        return this.modelMapper.map(collectionItem, CollectionItemResponse.class);
    }

}
