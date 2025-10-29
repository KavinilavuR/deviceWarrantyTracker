package com.example.deviceWarrantyTracker.service;

import com.example.deviceWarrantyTracker.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService
{
    List<Device> getAllDevices();
    Optional<Device> getDeviceById(Long id);
    Device addDevice(Device device);
    Device updateDevice(Long id,Device updatedDevice);
    String deleteDevice(Long id);
    List<Device> getDevicesExpiringSoon(int days);
}
