package xyz.javista.common.device.event;

/**
 * Created by Luke on 2017-04-04.
 */
public abstract class BaseChangeEvent {
    private String devicePhysicalPort;
    private String deviceInternalPort;
    private String deviceGPIO;
    private Integer value;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseChangeEvent)) return false;

        BaseChangeEvent that = (BaseChangeEvent) o;

        if (getDevicePhysicalPort() != null ? !getDevicePhysicalPort().equals(that.getDevicePhysicalPort()) : that.getDevicePhysicalPort() != null)
            return false;
        if (getDeviceInternalPort() != null ? !getDeviceInternalPort().equals(that.getDeviceInternalPort()) : that.getDeviceInternalPort() != null)
            return false;
        if (getDeviceGPIO() != null ? !getDeviceGPIO().equals(that.getDeviceGPIO()) : that.getDeviceGPIO() != null)
            return false;
        return getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getDevicePhysicalPort() != null ? getDevicePhysicalPort().hashCode() : 0;
        result = 31 * result + (getDeviceInternalPort() != null ? getDeviceInternalPort().hashCode() : 0);
        result = 31 * result + (getDeviceGPIO() != null ? getDeviceGPIO().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "devicePhysicalPort='" + devicePhysicalPort + '\'' +
                ", deviceInternalPort='" + deviceInternalPort + '\'' +
                ", deviceGPIO='" + deviceGPIO + '\'' +
                ", value=" + value;
    }
}
