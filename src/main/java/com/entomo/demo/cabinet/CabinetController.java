package com.entomo.demo.cabinet;

import com.entomo.demo.cabinet.entities.dto.CabinetRequest;
import com.entomo.demo.cabinet.entities.dto.CabinetResponse;
import com.entomo.demo.cabinet.entities.persistence.Cabinet;
import com.entomo.demo.generic.EntityList;
import com.entomo.demo.util.Constants;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

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

    @GetMapping("/{id}")
    public ResponseEntity<CabinetResponse> getSingleCabinet(@PathVariable Integer id){
        return ResponseEntity.ok(cabinetService.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CabinetResponse> deleteCabinet(@PathVariable Integer id){
        return ResponseEntity.ok(cabinetService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CabinetResponse> updateCabinet(@PathVariable Integer id, @RequestBody CabinetRequest request){
        return ResponseEntity.ok(cabinetService.update(id, request));
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<CabinetResponse> patchCabinet(@PathVariable Integer id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(cabinetService.patch(id, updates));
    }
}
