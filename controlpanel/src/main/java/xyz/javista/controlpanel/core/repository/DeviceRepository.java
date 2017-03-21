package xyz.javista.controlpanel.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.javista.common.mongo.entity.Device;

/**
 * Created by Luke on 2017-03-20.
 */
public interface DeviceRepository extends MongoRepository<Device, String> {

    public Device findByDevicePhysicalPort(String deviceInternalPort);
}
