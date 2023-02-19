package hbase;
import hbase.CRUD.PutDatas;
import hbase.ADMIN.CreateTable;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

        // Create employee table
        CreateTable ct = new CreateTable();
        ct.crateEmployeeTable();

        // ADD row0~99 data to mytable
        /*
        PutDatas pd = new PutDatas();
        pd.PutData();
         */
    }
}
