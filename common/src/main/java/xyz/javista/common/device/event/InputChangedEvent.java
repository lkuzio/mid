package xyz.javista.common.device.event;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Luke on 2017-03-05.
 */
public class InputChangedEvent extends BaseChangeEvent implements Serializable{

    private UUID uuid;
    private Timestamp timeSinceLastUpdate;
    private Timestamp eventTime;

    public InputChangedEvent() {
        this.uuid = UUID.randomUUID();
        this.eventTime = new Timestamp(new Date().getTime());
    }

    public UUID getUuid() {
        return uuid;
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
        if (!(o instanceof InputChangedEvent)) return false;

        InputChangedEvent that = (InputChangedEvent) o;

        if (getUuid() != null ? !getUuid().equals(that.getUuid()) : that.getUuid() != null) return false;
        if (getTimeSinceLastUpdate() != null ? !getTimeSinceLastUpdate().equals(that.getTimeSinceLastUpdate()) : that.getTimeSinceLastUpdate() != null)
            return false;
        return getEventTime() != null ? getEventTime().equals(that.getEventTime()) : that.getEventTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getUuid() != null ? getUuid().hashCode() : 0;
        result = 31 * result + (getTimeSinceLastUpdate() != null ? getTimeSinceLastUpdate().hashCode() : 0);
        result = 31 * result + (getEventTime() != null ? getEventTime().hashCode() : 0);
        result = 31 * result + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InputChangedEvent{" +super.toString() +
                "uuid=" + uuid +
                ", timeSinceLastUpdate=" + timeSinceLastUpdate +
                ", eventTime=" + eventTime +
                '}';
    }
}
