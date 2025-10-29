package com.example.deviceWarrantyTracker.repository;

import com.example.deviceWarrantyTracker.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>
{
    //Lis<Device> findByWarrantyExpiresAtBefore(LocalDate date);
    List<Device>findByWarrantyExpiresAtBefore(LocalDate date);
}
