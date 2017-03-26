package xyz.javista.controlpanel.core.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.javista.controlpanel.core.entity.Room;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();
}
