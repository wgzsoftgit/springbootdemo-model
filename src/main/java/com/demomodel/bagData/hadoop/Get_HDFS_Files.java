package com.demomodel.bagData.hadoop;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/**
 * 列出hdfs根目录下所有文件和目录（仅根目录一层）
 * 在 hdfs 中新建文件并写入中英文数据
 * 读取文件数据并打印至控制台显示
 * @author wgz
 * @date 创建时间：2020年6月30日 下午5:40:35
 */
public class Get_HDFS_Files {

    public static void hdfsFileTest() throws IOException {
        String uri = "hdfs://192.168.220.129:9000/";
        org.apache.hadoop.conf.Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);

        // 列出hdfs根目录下所有文件和目录（仅根目录一层）
// 目录HdfsLocatedFileStatus{path=hdfs://192.168.220.129:9000/hbase; isDirectory=true; modification_time=1586581687412; access_time=0; owner=root; group=supergroup; permission=rwxr-xr-x; isSymlink=false; hasAcl=false; isEncrypted=false; isErasureCoded=false}
// 目录HdfsLocatedFileStatus{path=hdfs://192.168.220.129:9000/test; isDirectory=true; modification_time=1593510108224; access_time=0; owner=root; group=supergroup; permission=rwxr-xr-x; isSymlink=false; hasAcl=false; isEncrypted=false; isErasureCoded=false}
        FileStatus[] status = fs.listStatus(new Path("/"));
        for (FileStatus sta : status) {
            System.err.println("目录"+sta);
        }

        // 在 hdfs 中新建文件并写入中英文数据
        FSDataOutputStream os = fs.create((new Path("/test/test.log")));
        os.write("hello hadoop ! 非常棒。".getBytes());
        os.flush();
        os.close();

        // 读取文件数据并打印至控制台显示
        InputStream is = fs.open(new Path("/test/test.log"));
        IOUtils.copyBytes(is, System.out, 1024, true);
    }

    public static void main(String[] args) throws IOException {
        hdfsFileTest();
    }
}
//https://blog.csdn.net/qq_24452475/java/article/details/79874630