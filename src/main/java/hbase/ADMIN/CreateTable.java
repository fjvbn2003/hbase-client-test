package hbase.ADMIN;

import hbase.HBaseConnection;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class CreateTable {

    private static final String TABLE_NAME = "employees";
    private static final String FAMILY_NAME = "info";
    public static void crateEmployeeTable() throws IOException {
        HBaseConnection hBaseConnection = new HBaseConnection("latte01,latte02,latte03", "2181");
        Connection connection = hBaseConnection.getConnection();
        Admin admin = connection.getAdmin();

        TableName tableName = TableName.valueOf(TABLE_NAME);
        if (admin.tableExists(tableName)) {
            System.out.println("Table " + TABLE_NAME + " already exists.");
        } else {
            ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(FAMILY_NAME)).build();
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(tableName).setColumnFamily(columnFamilyDescriptor).build();
            admin.createTable(tableDescriptor);
            System.out.println("Table " + TABLE_NAME + " created.");
        }
        admin.close();
        connection.close();
    }
}
