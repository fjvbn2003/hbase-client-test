package hbase.CRUDMD5;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;
public class PutDatasMD5 {
    public static void PutData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable2"));
        for(int i =0; i<100; i++){
            // Create a put request
            String rowKey = MD5Hash.getMD5AsHex(Bytes.toBytes("row"+i));
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("qual"), Bytes.toBytes("value"+i));
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("rowkey"), Bytes.toBytes("row"+i));
            // Add the put request to the table
            table.put(put);
        }
        System.out.println("PUT row 0~99 datas to mytable2");
        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
