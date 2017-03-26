package xyz.javista.controlpanel.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.javista.controlpanel.core.entity.mongo.DeviceHardware;

/**
 * Created by Luke on 2017-03-20.
 */
public interface DeviceHardwareRepository extends MongoRepository<DeviceHardware, String> {

    public DeviceHardware findByDevicePhysicalPort(String deviceInternalPort);

    public DeviceHardware findByDevicePhysicalPortAndDeviceInternalPortAndDeviceGPIO(String devicePhysicalPort, String deviceInternalPort, String deviceGPIO);

}
