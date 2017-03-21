package xyz.javista.controlpanel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.javista.common.dto.DeviceDTO;
import xyz.javista.common.mongo.entity.Device;

import java.util.List;

/**
 * Created by Luke on 2017-03-21.
 */
@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO toDto(Device device);

    Device toEntity(DeviceDTO deviceDTO);

    List<DeviceDTO> toDto(List<Device> all);

    List<Device> toEntity(List<DeviceDTO> deviceDTOs);

}
