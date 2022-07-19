package com.skillstorm.project2.controllers;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceController() {
        System.out.println("Device controller");
    }

    //get all device
    @GetMapping("/device")
    public List<Device> getAllDevice(){
        return deviceRepository.findAll();
    }
}
