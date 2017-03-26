package xyz.javista.controlpanel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.common.dto.RoomDTO;
import xyz.javista.controlpanel.core.service.RoomService;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
@RequestMapping(value = "/rooms")
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RoomDTO> findAll() {
        return roomService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRoom(@RequestBody RoomDTO roomDTO) {
        roomService.addRoom(roomDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public RoomDTO getRoom(@PathVariable(name = "id") Long id) {
        return roomService.findRoom(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/devices")
    public RoomDTO assignDeviceToRoom(@PathVariable(name = "id") Long id,
                                      @RequestBody DeviceDTO deviceDTO) {
        return roomService.assignDeviceToRoom(id, deviceDTO);
    }
}
