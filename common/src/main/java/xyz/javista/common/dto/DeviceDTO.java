package xyz.javista.common.dto;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by Luke on 2017-03-21.
 */

@Validated
public class DeviceDTO {

    private String id;
    @NotNull
    private String devicePhysicalPort;
    @NotNull
    private String deviceInternalPort;
    @NotNull
    private String deviceGPIO;
    private String deviceName;
    private Long roomId;
    private DeviceType deviceType;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDTO deviceDTO = (DeviceDTO) o;

        if (id != null ? !id.equals(deviceDTO.id) : deviceDTO.id != null) return false;
        if (!devicePhysicalPort.equals(deviceDTO.devicePhysicalPort)) return false;
        if (!deviceInternalPort.equals(deviceDTO.deviceInternalPort)) return false;
        if (!deviceGPIO.equals(deviceDTO.deviceGPIO)) return false;
        if (deviceName != null ? !deviceName.equals(deviceDTO.deviceName) : deviceDTO.deviceName != null) return false;
        if (roomId != null ? !roomId.equals(deviceDTO.roomId) : deviceDTO.roomId != null) return false;
        return deviceType == deviceDTO.deviceType;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + devicePhysicalPort.hashCode();
        result = 31 * result + deviceInternalPort.hashCode();
        result = 31 * result + deviceGPIO.hashCode();
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "id='" + id + '\'' +
                ", devicePhysicalPort='" + devicePhysicalPort + '\'' +
                ", deviceInternalPort='" + deviceInternalPort + '\'' +
                ", deviceGPIO='" + deviceGPIO + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", roomId=" + roomId +
                ", deviceType=" + deviceType +
                '}';
    }
}
