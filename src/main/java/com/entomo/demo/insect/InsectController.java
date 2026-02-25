package com.entomo.demo.insect;

import com.entomo.demo.generic.EntityList;
import com.entomo.demo.insect.entities.dto.InsectRequest;
import com.entomo.demo.insect.entities.dto.InsectResponse;
import com.entomo.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API + "/insect")
public class InsectController {

    private final InsectService insectService;

    @Autowired
    public InsectController(InsectService insectService) {
        this.insectService = insectService;
    }

    @PostMapping("")
    public ResponseEntity<InsectResponse> createInsect(@RequestBody InsectRequest insectRequest){
        return new ResponseEntity<>(insectService.create(insectRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<EntityList<InsectResponse>> getAllInsects(){
        return ResponseEntity.ok(new EntityList<>(insectService.getAll()));
    }
}
