package hbase;
import hbase.CRUD.*;
import hbase.ADMIN.CreateTable;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

        // Create employee table
//        CreateTable ct = new CreateTable();
//        ct.crateEmployeeTable();


        ////////////////////////  CRUD //////////////////////////

        // ADD row0~99 data to mytable
//        PutDatas pd = new PutDatas();
//        pd.PutData();


        //DELETE row0~99 data from mytable
//        DeleteDatas dd = new DeleteDatas();
//        dd.DeleteData();


        // GET row 0~99 data from mytable
//        GetDatas gd =  new GetDatas();
//        gd.GetData();


        // UPDATE row 0~99 data from mytable
//        UpdateDatas ud =  new UpdateDatas();
//        ud.UpdateData();

        // SCAN row 30~50 data from mytable
        ScanDatas sd  = new ScanDatas();
        sd.ScanData();

    }
}
