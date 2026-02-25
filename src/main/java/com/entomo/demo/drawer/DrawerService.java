package com.entomo.demo.drawer;

import com.entomo.demo.drawer.entities.dto.DrawerRequest;
import com.entomo.demo.drawer.entities.dto.DrawerResponse;
import com.entomo.demo.drawer.entities.persistence.Drawer;
import com.entomo.demo.generic.GenericService;
import com.entomo.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawerService extends GenericService<Drawer, DrawerRequest, DrawerResponse> {

    @Autowired
    public DrawerService(DrawerRepository drawerRepository) {super(drawerRepository, Util.getMapper());}

    @Override
    public Drawer mapToEntityFromRequest(DrawerRequest drawerRequest) {
        return super.modelMapper.map(drawerRequest, Drawer.class);
    }

    @Override
    public DrawerResponse mapToResponse(Drawer drawer) {

        return this.modelMapper.map(drawer, DrawerResponse.class);
    }
}
