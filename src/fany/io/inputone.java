package fany.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


class inputone {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File fis1 = new File("E:/Desktop/1.txt");
		byte[] buff = readFile(fis1);
		System.out.print(new String(buff));
	}
	
	private static  byte[] readFile(File file) throws Exception{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			int byteRead =0;
			while(-1!=(byteRead=bis.read(buff,0,buff.length))){
				baos.write(buff,0,byteRead);
			}
			//System.out.println(buff.length);
		}catch(Exception ex){
			throw new Exception("¶ÁÈ¡"+file.getName()+"³ö´í!");
		}finally{
			bis.close();
			buff = null;
		}
		return baos.toByteArray();
	}

}
