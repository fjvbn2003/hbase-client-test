package hbase.CRUDMD5;

import hbase.HBaseConnection;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;

public class GetDatasMD5 {
    public static void GetData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable2"));
        for(int i =0; i<100; i++){
            // get all data in a row
            String rowKey = MD5Hash.getMD5AsHex(Bytes.toBytes("row"+i));
            Get get1 = new Get(Bytes.toBytes(rowKey));
            Result result1 = table.get(get1);
            byte[] value1 = result1.getValue(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            System.out.println("Value1 of row"+i +": "+ Bytes.toString(value1));

            // get a specific data in a row
            Get get2 = new Get(Bytes.toBytes(rowKey));
            get2.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            Result result2 = table.get(get2);
            byte[] value2 = result2.getValue(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            System.out.println("Value2 of row"+i +": "+ Bytes.toString(value2));
        }
        System.out.println("GET row 0~99 datas to mytable2");
        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
