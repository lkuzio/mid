package xyz.javista.controlpanel.core.service;

import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.common.dto.RoomDTO;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
public interface RoomService {
    RoomDTO assignDeviceToRoom(Long id, DeviceDTO deviceDTO);

    RoomDTO findRoom(Long id);

    void addRoom(RoomDTO roomDTO);

    List<RoomDTO> findAll();
}
