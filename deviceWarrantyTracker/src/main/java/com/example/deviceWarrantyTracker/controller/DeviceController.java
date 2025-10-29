package com.example.deviceWarrantyTracker.controller;

import com.example.deviceWarrantyTracker.model.Device;
import com.example.deviceWarrantyTracker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController
{
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices()
    {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public Optional<Device> getDeviceById(@PathVariable Long id)
    {
        return  deviceService.getDeviceById(id);

    }

    @PostMapping
    public Device addDevice(@RequestBody Device device)
    {
        return deviceService.addDevice(device);
    }

    @PutMapping("/{id}")
    public Device updateDevice(@PathVariable Long id,@RequestBody Device device)
    {
        return deviceService.updateDevice(id,device);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDevice(@PathVariable Long id)
    {
        return deviceService.deleteDevice(id);
    }

    @GetMapping("/expiring")
    public List<Device> getDevicesExpiringSoon(@RequestParam int days)
    {
        return deviceService.getDevicesExpiringSoon(days);
    }











}
