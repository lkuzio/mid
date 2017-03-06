package xyz.javista.devicemenager;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.javista.common.device.event.InputChangedEvent;
import xyz.javista.event.EventSender;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * Created by Luke on 2017-03-05.
 */
public class Reader extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    public static final int INPUTS = 0xFF;
    public static final int DEVICE_ADDRESS_1 = 0x21;
    public static final int DEVICE_PORTA_TYPE_REG = 0x00;
    public static final int DEVICE_PORTB_TYPE_REG = 0x01;
    public static final int DEVICE_PORTA_INPUT_REG = 0x12;
    public static final int DEVICE_PORTB_INPUT_REG = 0x13;

    private final EventSender eventSender;

    private I2CDevice i2CDevice = null;
    private I2CBus i2CBus = null;


    public Reader(EventSender eventSender) {
        this.eventSender = eventSender;

        try {
            i2CBus = I2CFactory.getInstance(I2CBus.BUS_1);
            i2CDevice = i2CBus.getDevice(DEVICE_ADDRESS_1);
            i2CDevice.write(DEVICE_PORTA_TYPE_REG, (byte) INPUTS);
            i2CDevice.write(DEVICE_PORTB_TYPE_REG, (byte) INPUTS);
        } catch (IOException | I2CFactory.UnsupportedBusNumberException e) {
            LOGGER.error("Something wrong happend during reader setup", e);
        }

    }

    @Override
    public void run() {
        List<String> tmp = Arrays.asList("00000000", "00000000");

        while (tmp.get(0) != "512") {

            try {
                String d1value = StringUtils.leftPad(Integer.toBinaryString(i2CDevice.read(DEVICE_PORTA_INPUT_REG)), 8, '0');
                List<InputChangedEvent> events = new ArrayList<>();
                if (!tmp.get(0).equals(d1value)) {
                    for (int i = 0; i < d1value.length(); i++) {
                        if (d1value.toCharArray()[i] != tmp.get(0).toCharArray()[i]) {
                            InputChangedEvent event = new InputChangedEvent();
                            event.setDeviceGPIO(Integer.toString(i));
                            event.setDeviceInternalPort("A");
                            event.setDevicePhysicalPort(Integer.toString(DEVICE_ADDRESS_1));
                            event.setValue(Integer.parseInt(Character.toString(d1value.toCharArray()[i])));
                            event.setTimeSinceLastUpdate(new Timestamp(100l));
                            events.add(event);
                        }
                    }

                    tmp.set(0, d1value);
                }
                eventSender.getEvents().addAll(events);
                events.clear();
            } catch (IOException e) {
                LOGGER.error("Something went wrong", e);
            }
        }
    }
}
