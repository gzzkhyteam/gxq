import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class FileApi {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Administrator/Desktop/jyc.txt");
		InputStream input = new FileInputStream(file);
//		File file1 = new File("C:/Users/Administrator/Desktop/jyc.txt");
		OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\jyc1.txt",false);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		String str = reader.readLine();
		String upStr = null;
		while (str != null) {
			
			if(str.length() > 3 && !str.equals(upStr)){
				writer.write(str + "\r");
				upStr = str;
			}
			str = reader.readLine();
		}
		
		writer.close();
		reader.close();
	}
}
