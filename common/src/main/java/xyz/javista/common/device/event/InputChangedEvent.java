package xyz.javista.common.device.event;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Luke on 2017-03-05.
 */
public class InputChangedEvent implements Serializable {

    private UUID uuid;
    private String devicePhysicalPort;
    private String deviceInternalPort;
    private String deviceGPIO;
    private Integer value;
    private Timestamp timeSinceLastUpdate;
    private Timestamp eventTime;

    public InputChangedEvent() {
        this.uuid = UUID.randomUUID();
        this.eventTime = new Timestamp(new Date().getTime());
    }

    public UUID getUuid() {
        return uuid;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Timestamp getTimeSinceLastUpdate() {
        return timeSinceLastUpdate;
    }

    public void setTimeSinceLastUpdate(Timestamp timeSinceLastUpdate) {
        this.timeSinceLastUpdate = timeSinceLastUpdate;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputChangedEvent that = (InputChangedEvent) o;

        if (!uuid.equals(that.uuid)) return false;
        if (!devicePhysicalPort.equals(that.devicePhysicalPort)) return false;
        if (!deviceInternalPort.equals(that.deviceInternalPort)) return false;
        if (!deviceGPIO.equals(that.deviceGPIO)) return false;
        if (!value.equals(that.value)) return false;
        if (!timeSinceLastUpdate.equals(that.timeSinceLastUpdate)) return false;
        return eventTime.equals(that.eventTime);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + devicePhysicalPort.hashCode();
        result = 31 * result + deviceInternalPort.hashCode();
        result = 31 * result + deviceGPIO.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + timeSinceLastUpdate.hashCode();
        result = 31 * result + eventTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InputChangedEvent{" +
                "uuid=" + uuid +
                ", devicePhysicalPort='" + devicePhysicalPort + '\'' +
                ", deviceInternalPort='" + deviceInternalPort + '\'' +
                ", deviceGPIO='" + deviceGPIO + '\'' +
                ", value=" + value +
                ", timeSinceLastUpdate=" + timeSinceLastUpdate +
                ", eventTime=" + eventTime +
                '}';
    }
}
