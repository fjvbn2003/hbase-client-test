package hbase.CRUDMD5;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ScanDatasMD5 {
    private static final String TABLE_NAME = "mytable";
    private static final String FAMILY_NAME = "cf";
    private static final String QUALIFIER_NAME = "qual";
    private static final String REGEX_PATTERN = "new value[0-9]+";

    public static void ScanData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        // Create a scan object with the desired start and stop row keys
        Scan scan = new Scan(Bytes.toBytes("row30"), Bytes.toBytes("row50"));

        // add singleColumnValueFilter
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
                Bytes.toBytes(FAMILY_NAME),
                Bytes.toBytes(QUALIFIER_NAME),
                CompareFilter.CompareOp.EQUAL,
                new RegexStringComparator("new value3")
        );
        scan.setFilter(filter);
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
