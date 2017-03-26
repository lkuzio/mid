package xyz.javista.controlpanel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.repository.DeviceRepository;
import xyz.javista.controlpanel.mapper.DeviceMapper;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<DeviceDTO> findAllDevices() {
        return deviceMapper.toDto(deviceRepository.findAll());
    }


    @Override
    public void add(DeviceDTO deviceDTO) {
        deviceRepository.save(deviceMapper.toEntity(deviceDTO));
    }
}
