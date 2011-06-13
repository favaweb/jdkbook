package fany.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirectory {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new CopyDirectory().copyDirectiory("E:\\Desktop\\spring_hibernate_2 - 副本", "E:\\Desktop\\新建文件夹");
	}
	
	public void copyDirectiory(String file1,String file2) throws IOException{
		if(!new File(file2).exists())
			new File(file2).mkdir();//创建目标文件夹
		File[] file = new File(file1).listFiles();
		System.out.print(file.length);
		for(int i=0;i<file.length;i++){
			System.out.println(file[i].getName());
			if(file[i].isFile()){
				FileInputStream input = new FileInputStream(file[i]);
				FileOutputStream output = new FileOutputStream(file2+"/"+file[i].getName());
				byte[] b = new byte[1024*5];
				int len;
				while((len=input.read(b))!=-1)
					output.write(b, 0, len);
				output.flush();
				output.close();
				input.close();
			}
			if(file[i].isDirectory())
				copyDirectiory(file1+"/"+file[i].getName(), file2+"/"+file[i].getName());
		}
	}

}
