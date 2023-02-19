package hbase.CRUDMD5;

import hbase.HBaseConnection;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;

public class DeleteDatasMD5 {
    public static void DeleteData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable2"));
        for(int i =0; i<100; i++){// Delete a single row
            String rowKey = MD5Hash.getMD5AsHex(Bytes.toBytes(("row"+i)));
            System.out.println("row key to be deleted : "+ rowKey);
            Delete delete = new Delete(Bytes.toBytes(rowKey));
            table.delete(delete);
        }
        System.out.println("DELETE row 0~99 datas to mytable2");
        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
