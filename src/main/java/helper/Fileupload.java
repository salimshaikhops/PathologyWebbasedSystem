package helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Fileupload {
	//single \ will not work add another \
  public final static String upload_dir="D:\\PK\\restapi\\src\\main\\resources\\static\\image";
  //public final static upload_dir=new ClassPathResource("static/image").getFile().getAbsolutePath();
  
  public Fileupload() throws IOException
  
  {
	  
  }
  public static boolean uplodaFile(MultipartFile f)
  {
	  boolean f1=false;
	  try {
		  InputStream is=f.getInputStream();
		  byte data[]=new byte[is.available()];
		  is.read(data);
		  FileOutputStream fs=new FileOutputStream(upload_dir+"\\"+f.getOriginalFilename());
		  fs.write(data);
		  fs.close();
		  
		  
		  /*one line code for uploading file
		   * 
		   * Files.copy(f.getInputStream,upload_location,Mode[StandaredCopyOption.copyAtrribute/copyAtrributereplace]);
		   * Files.copy(f.getInputSTream,Paths.get(upload_dir+File.separator+f.getsFilename()),StandardCopyOption.REPLACE_EXITING)
		   * 
		   */
		  f1=true;
		  
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
	  
	  
	  
	return f1;
	  
  }
  
}
