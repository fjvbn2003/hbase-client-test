package hbase;
import hbase.CRUD.*;
import hbase.ADMIN.CreateTable;
import hbase.CRUDMD5.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

        // Create employee table
//        CreateTable ct = new CreateTable();
//        ct.crateEmployeeTable();


        ////////////////////////  CRUD (normal) //////////////////////////

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
//        ScanDatas sd  = new ScanDatas();
//        sd.ScanData();


        ////////////////////////  CRUD (md5) //////////////////////////
        // ADD row0~99 data to mytable2
//        PutDatasMD5 pd = new PutDatasMD5();
//        pd.PutData();


        //DELETE row0~99 data from mytable2
//        DeleteDatasMD5 dd = new DeleteDatasMD5();
//        dd.DeleteData();


        // GET row 0~99 data from mytable2
//        GetDatasMD5 gd =  new GetDatasMD5();
//        gd.GetData();


        // UPDATE row 0~99 data from mytable2
//        UpdateDatasMD5 ud =  new UpdateDatasMD5();
//        ud.UpdateData();

        // SCAN row 30~50 data from mytable2
        ScanDatasMD5 sd  = new ScanDatasMD5();
        sd.ScanData();


        //check md5
//        String rowKey = Bytes.toString(DigestUtils.md5("row85"));
//        System.out.println(DigestUtils.md5("row85"));
//        System.out.println(rowKey);
//        System.out.println(MD5Hash.getMD5AsHex(Bytes.toBytes("row85")));
    }
}
