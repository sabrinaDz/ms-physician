package com.siahtech.msphysician.web;


import com.siahtech.msphysician.data.Physician;
import com.siahtech.msphysician.service.PhysicianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1//physicians")
public class PhysicianController {

   private final PhysicianService physicianService;

    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Physician>>listPhysicians(){
        return new ResponseEntity<>(physicianService.listPhysicians(),HttpStatus.OK);
    }

    @GetMapping("/{physicianId}")
    public ResponseEntity<Physician>getPhysicianById(@PathVariable("physicianId") UUID physicianId){
        return new ResponseEntity<>(physicianService.getPhysicianById(physicianId),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Physician>addNewPhysician(@RequestBody Physician physician){
        return new ResponseEntity<Physician>(physicianService.addPhysician(physician), HttpStatus.CREATED);
    }


    @PutMapping("/{physicianId}")
    public ResponseEntity<Physician>updatePhysician(@PathVariable("physicianId") UUID physicianId,Physician physician){
        return new ResponseEntity<>(physicianService.updatePhysician(physicianId,physician),HttpStatus.CREATED);
    }
}
