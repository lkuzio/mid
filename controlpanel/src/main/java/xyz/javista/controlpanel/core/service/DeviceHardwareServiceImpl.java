package xyz.javista.controlpanel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.entity.mongo.DeviceHardware;
import xyz.javista.controlpanel.core.repository.DeviceHardwareRepository;
import xyz.javista.controlpanel.core.repository.DeviceRepository;
import xyz.javista.controlpanel.mapper.DeviceMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Luke on 2017-03-26.
 */
@Service
public class DeviceHardwareServiceImpl implements DeviceHardwareService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceHardwareRepository deviceHardwareRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<DeviceDTO> findHardwareDevices() {
        return deviceMapper.fromMongoEntity(deviceHardwareRepository.findAll());

    }

    @Override
    public void insert(DeviceDTO deviceDTO) {
        DeviceHardware device = deviceHardwareRepository.findByDevicePhysicalPortAndDeviceInternalPortAndDeviceGPIO(deviceDTO.getDevicePhysicalPort(), deviceDTO.getDeviceInternalPort(), deviceDTO.getDeviceGPIO());
        if (device != null) {
            deviceDTO.setId(device.getId());
            deviceHardwareRepository.save(deviceMapper.toMongoEntity(deviceDTO));
        }
        deviceHardwareRepository.save(deviceMapper.toMongoEntity(deviceDTO));
    }

    @Override
    public void delete(String id) {
        deviceHardwareRepository.delete(id);
    }

    @Override
    public List<DeviceDTO> findUnassigned() {
        List<DeviceHardware> hardwareDevices = deviceHardwareRepository.findAll();
        return deviceMapper.fromMongoEntity(hardwareDevices.stream()
                .filter(deviceHardware -> !isDefined(deviceHardware)).collect(Collectors.toList()));
    }

    private boolean isDefined(DeviceHardware deviceHardware) {
        return deviceRepository.findByDevicePhysicalPortAndDeviceInternalPortAndDeviceGPIO(
                deviceHardware.getDevicePhysicalPort(),
                deviceHardware.getDeviceInternalPort(),
                deviceHardware.getDeviceGPIO()) != null;
    }
}
