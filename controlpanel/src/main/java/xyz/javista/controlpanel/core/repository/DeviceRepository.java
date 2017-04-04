package xyz.javista.controlpanel.core.repository;


import org.springframework.data.repository.CrudRepository;
import xyz.javista.controlpanel.core.entity.Device;

import java.util.List;

/**
 * Created by Luke on 2017-03-22.
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findAll();

    Device findByDevicePhysicalPortAndDeviceInternalPortAndDeviceGPIO(String devicePhysicalPort, String deviceInternalPort, String deviceGPIO);

}
