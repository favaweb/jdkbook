package fany.io;

import java.io.File;
import java.io.IOException;

public class DelDir {

	/**
	 * ɾ���ļ�������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DelDir dd = new DelDir();
		dd.del("E:\\Desktop\\spring_hibernate_2 - ����");

	}
	
	public void del(String filepath) throws IOException{
		File f = new File(filepath);//�����ļ�·��
		//�ж����ļ�����Ŀ¼
		if(f.exists() && f.isDirectory()){
			if(f.listFiles().length==0){
				f.delete();//Ŀ¼û���ļ���ֱ��ɾ��
			}else{
				//��������ļ��Ž�����,���ж��Ƿ����¼�Ŀ¼
				File[] delFile = f.listFiles();
				for(int j=0; j<delFile.length;j++){
					if(delFile[j].isDirectory()){
						//�ݹ����del������ȡ����Ŀ¼·��
						del(delFile[j].getAbsolutePath());
					}
					delFile[j].delete();//ɾ���ļ�
				}
			}
			del(filepath);
		}
		
	}

}
