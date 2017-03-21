package xyz.javista.common.dto;

/**
 * Created by Luke on 2017-03-21.
 */
public class DeviceDTO {

    private String id;
    private String devicePhysicalPort;
    private String deviceInternalPort;
    private String deviceGPIO;

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
}
