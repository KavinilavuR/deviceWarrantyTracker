package com.example.deviceWarrantyTracker.service.impl;

import com.example.deviceWarrantyTracker.model.Device;
import com.example.deviceWarrantyTracker.repository.DeviceRepository;
import com.example.deviceWarrantyTracker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService
{
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public Device addDevice(Device device)
    {
        return deviceRepository.save(device);

    }

    @Override
    public Device updateDevice(Long id,Device updatedDevice)
    {
        return deviceRepository.findById(id).map(device -> {
            device.setName(updatedDevice.getName());
            device.setSerial(updatedDevice.getSerial());
            device.setPurchaseDate(updatedDevice.getPurchaseDate());
            device.setWarrantyMonths(updatedDevice.getWarrantyMonths());
            device.setVendor(updatedDevice.getVendor());
            device.calculateExpiryDate();
            return deviceRepository.save(device);

        }).orElseThrow(() -> new RuntimeException("Device not found"));


    }

    @Override
    public String deleteDevice(Long id)
    {
        deviceRepository.deleteById(id);
        return "Data Deleted";
    }

    @Override
    public List<Device> getDevicesExpiringSoon(int days)
    {
        LocalDate targetDate = LocalDate.now().plusDays(days);
        return deviceRepository.findByWarrantyExpiresAtBefore(targetDate);
    }
    
    
    

}
