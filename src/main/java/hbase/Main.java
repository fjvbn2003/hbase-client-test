package hbase;
import hbase.CRUD.*;
import hbase.ADMIN.CreateTable;
import hbase.CRUDMD5.*;
import hbase.MAPREDUCE.WordCountMapper;
import hbase.MAPREDUCE.WordCountReducer;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

        //////////////////////// Create employee table ///////////////
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
//        ScanDatasMD5 sd  = new ScanDatasMD5();
//        sd.ScanData();



//        //////////////////////// SUBMIT JOB ///////////////
//        // Create a new JobConf
//        Configuration conf = new Configuration();
//        // Set the resource manager address for YARN (Hadoop 2.x)
//        conf.set("yarn.resourcemanager.address", "latte01:8040");
//
//        JobConf job = new JobConf(conf);
//        job.setJobName("MyJob");
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//
//        job.setMapperClass( WordCountMapper.class);
//        job.setReducerClass(WordCountReducer.class);
//
//        job.setInputFormat(TextInputFormat.class);
//        job.setOutputFormat(TextOutputFormat.class);
//
//        FileInputFormat.setInputPaths(job, new Path("hdfs://latte01:9000/tmp/simple.txt"));
//        FileOutputFormat.setOutputPath(job, new Path("hdfs://latte01:9000/tmp/out8"));
//
//        JobClient client = new JobClient(job);
//        RunningJob runningJob = client.submitJob(job);
//
//        // Print job information
//        System.out.println("Job ID: " + runningJob.getID());
//        System.out.println("Job name: " + runningJob.getJobName());
//        System.out.println("Job status: " + runningJob.getJobState());
//        System.out.println("Job counters: " + runningJob.getCounters());



    }
}
