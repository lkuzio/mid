package xyz.javista.eventprocessor;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.*;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;

import java.util.UUID;


/**
 * Created by Luke on 2017-03-09.
 */
public class DeviceEventTopology {

    public static final String ZOOKEEPER_ADDR = "192.168.2.8:2181";


    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        String topic = "device_event";
        BrokerHosts hosts = new ZkHosts(ZOOKEEPER_ADDR);

        SpoutConfig kafkaSpoutConfig = new SpoutConfig(hosts, topic, "/" + topic,
                UUID.randomUUID().toString());
        kafkaSpoutConfig.bufferSizeBytes = 1024 * 1024 * 4;
        kafkaSpoutConfig.fetchSizeBytes = 1024 * 1024 * 4;
        kafkaSpoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        KafkaSpout kafkaSpout = new KafkaSpout(kafkaSpoutConfig);

        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("kafkaSpout", kafkaSpout);
        topologyBuilder.setBolt("eventBolt", new EventBolt()).shuffleGrouping("kafkaSpout");


        Config conf = new Config();
        conf.setNumWorkers(2);
        conf.setMaxSpoutPending(5000);
        conf.setDebug(true);
        StormSubmitter.submitTopology("deviceEventTopology", conf, topologyBuilder.createTopology());
    }
}
