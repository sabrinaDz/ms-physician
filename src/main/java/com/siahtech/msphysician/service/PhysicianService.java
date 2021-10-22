package com.siahtech.msphysician.service;

import com.siahtech.msphysician.data.Physician;

import java.util.List;
import java.util.UUID;

public interface PhysicianService {

    Physician addPhysician(Physician physician);
    Physician getPhysicianById(UUID physicianId);
    List<Physician>listPhysicians();
    Physician updatePhysician(UUID physicianId,Physician physician);

}
