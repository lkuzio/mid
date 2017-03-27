package xyz.javista.controlpanel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.service.DeviceServiceImpl;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Luke on 2017-03-21.
 */
@RequestMapping(value = "/devices")
@RestController
public class DeviceController {

    @Autowired
    private DeviceServiceImpl deviceService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceDTO> findAllDevices() {
        return deviceService.findAllDevices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insert(@Valid @RequestBody DeviceDTO deviceDTO) {
        deviceService.add(deviceDTO);
    }


}
