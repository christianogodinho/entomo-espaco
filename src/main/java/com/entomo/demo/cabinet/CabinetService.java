package com.entomo.demo.cabinet;

import com.entomo.demo.cabinet.entities.dto.CabinetRequest;
import com.entomo.demo.cabinet.entities.dto.CabinetResponse;
import com.entomo.demo.cabinet.entities.persistence.Cabinet;
import com.entomo.demo.generic.GenericService;
import com.entomo.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CabinetService extends GenericService<Cabinet, CabinetRequest, CabinetResponse> {

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository) {
        super(cabinetRepository, Util.getMapper());
    }

    @Override
    public Cabinet mapToEntityFromRequest(CabinetRequest cabinetRequest){

        return super.modelMapper.map(cabinetRequest, Cabinet.class);
    }

    @Override
    public CabinetResponse mapToResponse(Cabinet cabinet){
        return this.modelMapper.map(cabinet, CabinetResponse.class);
    }
}
