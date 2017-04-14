package xyz.javista.controlpanel.core.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Luke on 2017-03-20.
 */
@Entity(name = "devices")
public class Device implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String devicePhysicalPort;

    @Column
    private String deviceInternalPort;

    @Column
    private String deviceGPIO;

    @Column
    private String deviceName;

    @Column(name = "room_id")
    private Long roomId;

    @Column
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
