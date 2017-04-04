package xyz.javista.controlpanel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.service.DeviceHardwareServiceImpl;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */

@RestController
@RequestMapping("/devices/hardware")
public class HardwareDeviceController {

    @Autowired
    private DeviceHardwareServiceImpl deviceHardwareService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceDTO> findHardvareDevices() {
        return deviceHardwareService.findHardwareDevices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertHardwareDevice(@RequestBody DeviceDTO deviceDTO) {
        deviceHardwareService.insert(deviceDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        deviceHardwareService.delete(id);
    }

    @RequestMapping(value="/unassigned", method = RequestMethod.GET)
    public List<DeviceDTO> findUnassigned(){
        return deviceHardwareService.findUnassigned();
    }

}
