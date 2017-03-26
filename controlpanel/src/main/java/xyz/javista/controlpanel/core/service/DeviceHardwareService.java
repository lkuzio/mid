package xyz.javista.controlpanel.core.service;

import xyz.javista.common.dto.DeviceDTO;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
public interface DeviceHardwareService {
    List<DeviceDTO> findHardwareDevices();

    void insert(DeviceDTO deviceDTO);

    void delete(String id);
}
