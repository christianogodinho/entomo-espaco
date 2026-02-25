package com.entomo.demo.insect;

import com.entomo.demo.collection_item.entities.dto.CollectionItemRequest;
import com.entomo.demo.collection_item.entities.dto.CollectionItemResponse;
import com.entomo.demo.collection_item.entities.persistence.CollectionItem;
import com.entomo.demo.generic.GenericService;
import com.entomo.demo.insect.entities.dto.InsectRequest;
import com.entomo.demo.insect.entities.dto.InsectResponse;
import com.entomo.demo.insect.entities.persistence.Insect;
import com.entomo.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsectService extends GenericService<Insect, InsectRequest, InsectResponse> {

    @Autowired
    public InsectService(InsectRepository insectRepository) {super(insectRepository, Util.getMapper());}

    @Override
    public Insect mapToEntityFromRequest(InsectRequest insectRequest) {
        return super.modelMapper.map(insectRequest, Insect.class);
    }

    @Override
    public InsectResponse mapToResponse(Insect insect) {
        return this.modelMapper.map(insect, InsectResponse.class);
    }
}
