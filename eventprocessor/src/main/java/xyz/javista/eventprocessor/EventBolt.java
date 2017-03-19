package xyz.javista.eventprocessor;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Luke on 2017-03-09.
 */
public class EventBolt implements IRichBolt {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventBolt.class);

    private OutputCollector outputCollector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String event = tuple.getString(0);
        LOGGER.info(String.format("[%s],[%s]", event, tuple.getMessageId().toString()));

        outputCollector.ack(tuple);
    }

    @Override
    public void cleanup() {
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("devEvent"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
