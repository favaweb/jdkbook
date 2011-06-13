package fany.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	/**
	 * �����ļ�������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new CopyFile().copy("E:\\Desktop\\spring_hibernate_2 - ����\\readme.txt", "E:\\Desktop\\�½��ļ���\\readme.txt", 2);
	}
	/**
	 * �����ļ�����
	 * @param source_name Դ�ļ�ȫ·��
	 * @param dest_name Ŀ���ļ�ȫ·��
	 * @param type	���Ŀ���ļ����ڵĻ�,�Ƿ񸲸�(1������,2��������)
	 * @return ����0˵������Ŀ���ļ�,������
	 */
	public int copy(String source_name, String dest_name,int type) throws IOException{
		File source_file = new File(source_name);
		File dest_file = new File(dest_name);
		
		FileInputStream source = null;
		FileOutputStream destination =null;
		byte[] buffer;
		int bytes_read;
		int result=0;
		
		try {
			if(!source_file.exists() || !source_file.isFile())
				throw new RuntimeException("Դ�ļ�������!");
			if(!source_file.canRead())
				throw new RuntimeException("Դ�ļ����ɶ�!");
			if(dest_file.exists()){
				if(dest_file.isFile()){
					if(type==1){//����
						dest_file.delete();
						result = 1;
					}else{//������
						System.out.println(1);
						result = 2;
						return result;
					}
				}else{
					throw new RuntimeException("Ŀ����Ŀ¼�������ļ�");
				}
			}else{
				File parentdir = new File(dest_file.getParent());
				if(!parentdir.exists())
					throw new RuntimeException("Ŀ��·��������");
				if(!parentdir.canWrite())
					throw new RuntimeException("Ŀ��·������д");
			}
			
			//�����ļ�
			source = new FileInputStream(source_file);
			destination = new FileOutputStream(dest_file);
			buffer = new byte[1024];
			while(true){
				bytes_read = source.read(buffer);
				if(bytes_read == -1){
					System.out.print(1);
					break;
				}
				destination.write(buffer, 0, bytes_read);
			}	
		}finally{
			if(source != null){
				try{
					source.close();
				}catch(IOException e){}
			}
			if(destination != null){
				try {
					destination.close();
				} catch (Exception e) {}
			}
		}
		return result;
	}

}
