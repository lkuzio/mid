package xyz.javista.event;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * Created by Luke on 2017-03-03.
 */
public class SimplePartitioner implements Partitioner {
    public SimplePartitioner (VerifiableProperties props) {

    }

    public int partition(Object key, int numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
            partition = Integer.parseInt( stringKey.substring(offset+1)) % numPartitions;
        }
        return partition;
    }

}
