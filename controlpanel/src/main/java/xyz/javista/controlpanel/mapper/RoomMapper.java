package xyz.javista.controlpanel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.javista.common.dto.RoomDTO;
import xyz.javista.controlpanel.core.entity.Room;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
@Mapper(componentModel = "spring", uses = DeviceMapper.class)
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDTO toDTO(Room room);

    Room toEntity(RoomDTO roomDTO);

    List<RoomDTO> toDTO(List<Room> room);

    List<Room> toEntity(List<RoomDTO> roomDTO);

}
