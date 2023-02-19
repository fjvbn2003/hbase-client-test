package hbase.CRUD;
import java.io.IOException;
import hbase.HBaseConnection;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
public class PutDatas {
    public static void PutData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable"));
        for(int i =0; i<100; i++){
            // Create a put request
            Put put = new Put(Bytes.toBytes("row"+i));
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("qual1"), Bytes.toBytes("value"+i));
            // Add the put request to the table
            table.put(put);
        }

        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
