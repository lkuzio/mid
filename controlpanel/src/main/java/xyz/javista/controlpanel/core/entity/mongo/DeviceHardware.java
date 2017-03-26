package xyz.javista.controlpanel.core.entity.mongo;


import org.springframework.data.annotation.Id;

/**
 * Created by Luke on 2017-03-20.
 */
public class DeviceHardware {

    @Id
    private String id;

    private String devicePhysicalPort;
    private String deviceInternalPort;
    private String deviceGPIO;

    public DeviceHardware() {
    }

    public DeviceHardware(String id, String devicePhysicalPort, String deviceInternalPort, String deviceGPIO) {
        this.id = id;
        this.devicePhysicalPort = devicePhysicalPort;
        this.deviceInternalPort = deviceInternalPort;
        this.deviceGPIO = deviceGPIO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevicePhysicalPort() {
        return devicePhysicalPort;
    }

    public void setDevicePhysicalPort(String devicePhysicalPort) {
        this.devicePhysicalPort = devicePhysicalPort;
    }

    public String getDeviceInternalPort() {
        return deviceInternalPort;
    }

    public void setDeviceInternalPort(String deviceInternalPort) {
        this.deviceInternalPort = deviceInternalPort;
    }

    public String getDeviceGPIO() {
        return deviceGPIO;
    }

    public void setDeviceGPIO(String deviceGPIO) {
        this.deviceGPIO = deviceGPIO;
    }

    @Override
    public String toString() {
        return "DeviceHardware{" +
                "id='" + id + '\'' +
                ", devicePhysicalPort='" + devicePhysicalPort + '\'' +
                ", deviceInternalPort='" + deviceInternalPort + '\'' +
                ", deviceGPIO='" + deviceGPIO + '\'' +
                '}';
    }
}
