package hbase.CRUDMD5;

import hbase.HBaseConnection;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;

public class ScanDatasMD5 {
    private static final String TABLE_NAME = "mytable2";
    private static final String FAMILY_NAME = "cf";
    private static final String QUALIFIER_NAME = "qual";
    private static final String REGEX_PATTERN = "new value[0-9]+";
    private static final String START_ROW_KEY = "row30";
    private static final String STOP_ROW_KEY = "row50";

    public static void ScanData() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();

        // Get a handle to the table
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        // Create a scan object with the desired start and stop row keys
        byte[] startRowKey = Bytes.toBytes(MD5Hash.getMD5AsHex(Bytes.toBytes(START_ROW_KEY)));
        byte[] stopRowKey = Bytes.toBytes(MD5Hash.getMD5AsHex(Bytes.toBytes(STOP_ROW_KEY)));
        Scan scan = new Scan(startRowKey, stopRowKey);

//         add singleColumnValueFilter
//        SingleColumnValueFilter filter = new SingleColumnValueFilter(
//                Bytes.toBytes(FAMILY_NAME),
//                Bytes.toBytes(QUALIFIER_NAME),
//                CompareFilter.CompareOp.EQUAL,
//                new RegexStringComparator("value")
//        );
//        scan.setFilter(filter);
        // Execute the scan and process the results
        ResultScanner scanner = table.getScanner(scan);

        for (Result result = scanner.next(); result != null; result = scanner.next()) {
            for (Cell cell : result.listCells()) {
                String family = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
                String qualifier = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                String value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                String rowKey = Bytes.toString(result.getRow());
                System.out.println("rowkey: " + rowKey + ", column: " + family + ":" + qualifier + ", value: " +value);
            }
        }
        System.out.println("SCAN row " + START_ROW_KEY+ " ~ "+ STOP_ROW_KEY+ " from mytable2");

        // Clean up resources
        scanner.close();
        table.close();
        connection.close();
    }
}
