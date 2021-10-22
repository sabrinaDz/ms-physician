package com.siahtech.msphysician.service;


import com.siahtech.msphysician.data.Physician;
import com.siahtech.msphysician.exception.ResourceNotFoundException;
import com.siahtech.msphysician.repository.PhysicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhysicianServiceImpl implements PhysicianService{

    private final String RESOUCE_NOT_FOUND_MESSAGE="physician doesnt not exit, id= ";
    private final PhysicianRepository physicianRepository;


    public PhysicianServiceImpl(PhysicianRepository physicianRepository) {
        this.physicianRepository = physicianRepository;
    }

    @Override
    public Physician addPhysician(Physician physician) {
        return this.physicianRepository.save(physician);
    }

    @Override
    public Physician getPhysicianById(UUID physicianId) {
        return physicianRepository.findById(physicianId).orElse(null);
    }

    @Override
    public List<Physician> listPhysicians() {
        return physicianRepository.findAll();
    }

    @Override
    public Physician updatePhysician(UUID physicianId, Physician physician) {
          Physician physicianToUpdate=physicianRepository.findById(physicianId).orElseThrow(()->new ResourceNotFoundException(RESOUCE_NOT_FOUND_MESSAGE+physicianId));
          physicianToUpdate.setFirstName(physician.getFirstName());
          physicianToUpdate.setLastName(physician.getLastName());
          physicianToUpdate.setEmail(physician.getEmail());
          physicianToUpdate.setTel(physician.getTel());
          physicianToUpdate.setDepartmentId(physician.getId());
          physicianToUpdate.setPositionId(physician.getPositionId());
          physicianToUpdate.setDepartmentId(physician.getDepartmentId());
          physicianToUpdate.setId(physicianId);
          return physicianToUpdate;
    }
}
