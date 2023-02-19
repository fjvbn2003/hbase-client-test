package hbase.CRUD;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class GetDatas {
    public static void GetData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable"));
        for(int i =0; i<100; i++){
            // get all data in a row
            Get get1 = new Get(Bytes.toBytes("row"+i));
            Result result1 = table.get(get1);
            byte[] value1 = result1.getValue(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            System.out.println("Value1 of row"+i +": "+ Bytes.toString(value1));

            // get a specific data in a row
            Get get2 = new Get(Bytes.toBytes("row"+i));
            get2.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            Result result2 = table.get(get2);
            byte[] value2 = result2.getValue(Bytes.toBytes("cf"), Bytes.toBytes("qual"));
            System.out.println("Value2 of row"+i +": "+ Bytes.toString(value2));
        }
        System.out.println("GET row 0~99 datas to mytable");
        // Close the table and connection
        table.close();
        hBaseConnection.close();
    }
}
