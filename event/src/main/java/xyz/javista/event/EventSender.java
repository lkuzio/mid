package xyz.javista.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.javista.common.device.event.InputChangedEvent;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Luke on 2017-03-05.
 */

public class EventSender extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(EventSender.class);

    private Producer<String, String> producer;
    private Queue<InputChangedEvent> events;

    public EventSender() {
        Properties props = new Properties();
        props.put("metadata.broker.list", "192.168.2.8:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "xyz.javista.event.SimplePartitioner");
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);
        events = new ConcurrentLinkedQueue<InputChangedEvent>();
       }

    public Queue<InputChangedEvent> getEvents() {
        return events;
    }

    public void setEvents(Queue<InputChangedEvent> events) {
        this.events = events;
    }

    @Override
    public void run() {
        while(true) {
            if(!events.isEmpty()) {
                ObjectMapper objectMapper = new ObjectMapper();
                KeyedMessage<String, String> data = null;
                try {
                    data = new KeyedMessage<String, String>("device_event", UUID.randomUUID().toString(), objectMapper.writeValueAsString(events.poll()));
                } catch (JsonProcessingException e) {
                    LOGGER.error("Something wrong happend during serialization", e);
                }
                producer.send(data);
            }
        }
    }
}
