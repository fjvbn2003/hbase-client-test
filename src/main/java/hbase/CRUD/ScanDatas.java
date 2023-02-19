package hbase.CRUD;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ScanDatas {
    public static void ScanData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf("mytable"));
        // Create a scan object with the desired start and stop row keys
        Scan scan = new Scan(Bytes.toBytes("row30"), Bytes.toBytes("row50"));

        // Execute the scan and process the results
        ResultScanner scanner = table.getScanner(scan);
        for (Result result = scanner.next(); result != null; result = scanner.next()) {
            for (Cell cell : result.listCells()) {
                String family = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
                String qualifier = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                String value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());

                System.out.println("rowkey: " + Bytes.toString(result.getRow()) + ", column: " + family + ":" + qualifier + ", value: " +value);
            }
        }
        System.out.println("SCAN row 30~50 datas to mytable");

        // Clean up resources
        scanner.close();
        table.close();
        connection.close();
    }
}
