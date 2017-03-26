package xyz.javista.controlpanel.core.service;

import xyz.javista.common.dto.DeviceDTO;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
public interface DeviceService {
    List<DeviceDTO> findAllDevices();

    void add(DeviceDTO deviceDTO);
}
