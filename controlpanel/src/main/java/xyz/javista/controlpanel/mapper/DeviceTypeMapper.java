package xyz.javista.controlpanel.mapper;

import org.mapstruct.Mapper;
import xyz.javista.controlpanel.core.entity.DeviceType;

/**
 * Created by Luke on 2017-04-05.
 */
@Mapper(componentModel = "spring")
public interface DeviceTypeMapper {

    DeviceType toDto(xyz.javista.common.dto.DeviceType deviceType);

    xyz.javista.common.dto.DeviceType toEntity(DeviceType deviceType);
}
