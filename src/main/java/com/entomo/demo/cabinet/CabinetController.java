package com.entomo.demo.cabinet;

import com.entomo.demo.cabinet.entities.dto.CabinetRequest;
import com.entomo.demo.cabinet.entities.dto.CabinetResponse;
import com.entomo.demo.generic.EntityList;
import com.entomo.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping(Constants.API + "/cabinet")
public class CabinetController{

    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @PostMapping("")
    public ResponseEntity<CabinetResponse> createCabinet(@RequestBody CabinetRequest cabinetRequest) {
        return new ResponseEntity<>(cabinetService.create(cabinetRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<EntityList<CabinetResponse>> getAllCabinets() {
        return ResponseEntity.ok(new EntityList<>(cabinetService.getAll()));
    }
}
