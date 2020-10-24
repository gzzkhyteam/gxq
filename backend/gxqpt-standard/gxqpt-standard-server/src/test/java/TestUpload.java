import com.hengyunsoft.utils.Result;
import com.hengyunsoft.utils.UploadFileUtil;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class TestUpload {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\测试中文_gbk.txt");
        ByteArrayOutputStream bos = null;
        BufferedInputStream in = null;

        bos = new ByteArrayOutputStream((int) file.length());
        in = new BufferedInputStream(new FileInputStream(file));
        int buf_size = 1024;
        byte[] buffer = new byte[buf_size];
        int len = 0;
        while (-1 != (len = in.read(buffer, 0, buf_size))) {
            bos.write(buffer, 0, len);
        }

        Result s = UploadFileUtil.uploadFile("http://127.0.0.1:10086/api/file/p/file/simple", "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI0NWtqNjM1MiIsImFwcE5hbWUiOiLkupHnm5jnrqHnkIbns7vnu58iLCJleHAiOjE1MjUwMTAzMDB9.jEfSEQ2oQmQz9J6IhVzazTKDET8FuuHdSTahd7MRGeLI_lauR2rw18r3TVyl-DDggVaRy96I2bmZm3PzIBmR0ma7cwylehaIM3fKCfIk8Gp4DlvBef17O19WhSp-ZPGWS4al5HJoDgf7j6VsjFgmYaV2ux8lfjJBZpMhPg4oFHY",
                1L, file.getName(), bos.toByteArray());
        System.out.println(s);
    }
}
