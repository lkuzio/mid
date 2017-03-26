package xyz.javista.controlpanel.core.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Luke on 2017-03-25.
 */
@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Device> devices;

    public Room() {
    }

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

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
