package xyz.javista.controlpanel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.common.dto.RoomDTO;
import xyz.javista.controlpanel.core.entity.Device;
import xyz.javista.controlpanel.core.repository.DeviceRepository;
import xyz.javista.controlpanel.core.repository.RoomRepository;
import xyz.javista.controlpanel.mapper.DeviceMapper;
import xyz.javista.controlpanel.mapper.RoomMapper;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDTO assignDeviceToRoom(Long id, DeviceDTO deviceDTO) {
        Device device = deviceMapper.toEntity(deviceDTO);
        device.setRoomId(id);
        deviceRepository.save(device);
        return roomMapper.toDTO(roomRepository.findOne(id));
    }

    @Override
    public RoomDTO findRoom(Long id) {
        return roomMapper.toDTO(roomRepository.findOne(id));
    }

    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomRepository.save(roomMapper.toEntity(roomDTO));
    }

    @Override
    public List<RoomDTO> findAll() {
        return roomMapper.toDTO(roomRepository.findAll());
    }
}
