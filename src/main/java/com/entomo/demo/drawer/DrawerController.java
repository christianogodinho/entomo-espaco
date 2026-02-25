package com.entomo.demo.drawer;

import com.entomo.demo.drawer.entities.dto.DrawerRequest;
import com.entomo.demo.drawer.entities.dto.DrawerResponse;
import com.entomo.demo.generic.EntityList;
import com.entomo.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API + "/drawer")
public class DrawerController {

    private final DrawerService drawerService;

    @Autowired
    public DrawerController(DrawerService drawerService) {
        this.drawerService = drawerService;
    }

    @PostMapping("")
    public ResponseEntity<DrawerResponse> createDrawer(@RequestBody DrawerRequest drawerRequest){
        return new ResponseEntity<>(drawerService.create(drawerRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<EntityList<DrawerResponse>> getAllDrawers(){
        return ResponseEntity.ok(new EntityList<>(drawerService.getAll()));
    }
}
