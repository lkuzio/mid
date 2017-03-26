package xyz.javista.common.dto;

import java.util.List;

/**
 * Created by Luke on 2017-03-26.
 */
public class RoomDTO {

    private Long id;
    private String name;
    private List<DeviceDTO> devices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDTO> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RoomDTO roomDTO = (RoomDTO) o;

        if (id != null ? !id.equals(roomDTO.id) : roomDTO.id != null)
            return false;
        if (!name.equals(roomDTO.name))
            return false;
        return devices != null ? devices.equals(roomDTO.devices) : roomDTO.devices == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", devices=" + devices +
                '}';
    }
}
