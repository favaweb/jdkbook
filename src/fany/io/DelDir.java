package fany.io;

import java.io.File;
import java.io.IOException;

public class DelDir {

	/**
	 * 删除文件工具类
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DelDir dd = new DelDir();
		dd.del("E:\\Desktop\\spring_hibernate_2 - 副本");

	}
	
	public void del(String filepath) throws IOException{
		File f = new File(filepath);//定义文件路径
		//判断是文件还是目录
		if(f.exists() && f.isDirectory()){
			if(f.listFiles().length==0){
				f.delete();//目录没有文件就直接删除
			}else{
				//若有则把文件放进数组,并判断是否有下级目录
				File[] delFile = f.listFiles();
				for(int j=0; j<delFile.length;j++){
					if(delFile[j].isDirectory()){
						//递归调用del方法并取得子目录路径
						del(delFile[j].getAbsolutePath());
					}
					delFile[j].delete();//删除文件
				}
			}
			del(filepath);
		}
		
	}

}
