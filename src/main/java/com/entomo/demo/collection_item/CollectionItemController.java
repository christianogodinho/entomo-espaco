package com.entomo.demo.collection_item;

import com.entomo.demo.collection_item.entities.dto.CollectionItemRequest;
import com.entomo.demo.collection_item.entities.dto.CollectionItemResponse;
import com.entomo.demo.generic.EntityList;
import com.entomo.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API + "/collection_item")
public class CollectionItemController {

    private final CollectionItemService collectionItemService;

    @Autowired
    public CollectionItemController(CollectionItemService collectionItemService) {
        this.collectionItemService = collectionItemService;
    }

    @PostMapping("")
    public ResponseEntity<CollectionItemResponse> createCollectionItem(@RequestBody CollectionItemRequest collectionItemRequest){
        return new ResponseEntity<>(collectionItemService.create(collectionItemRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<EntityList<CollectionItemResponse>> getAllCollectionItems(){
        return ResponseEntity.ok(new EntityList<>(collectionItemService.getAll()));
    }
}
