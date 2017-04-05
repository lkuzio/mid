package xyz.javista.controlpanel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.controlpanel.core.entity.Device;
import xyz.javista.controlpanel.core.entity.mongo.DeviceHardware;

import java.util.List;

/**
 * Created by Luke on 2017-03-21.
 */
@Mapper(componentModel = "spring", uses = {RoomMapper.class, DeviceTypeMapper.class})
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO fromMongoEntity(DeviceHardware device);

    DeviceHardware toMongoEntity(DeviceDTO deviceDTO);

    List<DeviceDTO> fromMongoEntity(List<DeviceHardware> all);

    List<DeviceHardware> toMongoEntity(List<DeviceDTO> deviceDTOs);

    DeviceDTO toDto(Device device);

    Device toEntity(DeviceDTO deviceDTO);

    List<DeviceDTO> toDto(List<Device> devices);

    List<Device> toEntity(List<DeviceDTO> deviceDTO);

}
