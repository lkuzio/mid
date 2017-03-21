package xyz.javista.controlpanel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.repository.DeviceRepository;
import xyz.javista.controlpanel.mapper.DeviceMapper;

import java.util.List;

/**
 * Created by Luke on 2017-03-21.
 */
@RequestMapping(value = "/devices")
@RestController
public class DeviceController {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceRepository deviceRepository;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceDTO> devices() {
        return deviceMapper.toDto(deviceRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insert(@RequestBody DeviceDTO device) {
        deviceRepository.save(deviceMapper.toEntity(device));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void insert(@PathVariable("id") String id) {
        deviceRepository.delete(id);
    }

}
