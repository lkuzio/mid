package xyz.javista.common.dto;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

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
        if (!(o instanceof DeviceDTO)) return false;
        DeviceDTO deviceDTO = (DeviceDTO) o;
        return Objects.equals(getId(), deviceDTO.getId()) &&
                Objects.equals(getDevicePhysicalPort(), deviceDTO.getDevicePhysicalPort()) &&
                Objects.equals(getDeviceInternalPort(), deviceDTO.getDeviceInternalPort()) &&
                Objects.equals(getDeviceGPIO(), deviceDTO.getDeviceGPIO()) &&
                Objects.equals(getDeviceName(), deviceDTO.getDeviceName()) &&
                Objects.equals(getRoomId(), deviceDTO.getRoomId()) &&
                getDeviceType() == deviceDTO.getDeviceType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDevicePhysicalPort(), getDeviceInternalPort(), getDeviceGPIO(), getDeviceName(), getRoomId(), getDeviceType());
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
