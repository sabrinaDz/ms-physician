package com.siahtech.msphysician.repository;

import com.siahtech.msphysician.data.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhysicianRepository extends JpaRepository<UUID, Physician> {

    Physician findByPositionId(UUID positionId);
    Physician findByDepartmentId(UUID departmentId);
}
