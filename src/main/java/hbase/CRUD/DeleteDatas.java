package hbase.CRUD;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class DeleteDatas {
    public static void DeleteData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable"));
        for(int i =0; i<100; i++){// Delete a single row
            Delete delete = new Delete(Bytes.toBytes("row"+i));
            table.delete(delete);
        }
        System.out.println("DELETE row 0~99 datas to mytable");
        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
