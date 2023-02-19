package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBaseConnection {
    private Configuration config;
    private Connection connection;

    public HBaseConnection(String zookeeperQuorum, String zookeeperClientPort) throws IOException {
        config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", zookeeperQuorum);
        config.set("hbase.zookeeper.property.clientPort", zookeeperClientPort);
        connection = ConnectionFactory.createConnection(config);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws IOException {
        connection.close();
    }
}