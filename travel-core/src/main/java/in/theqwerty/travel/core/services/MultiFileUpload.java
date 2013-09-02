package in.theqwerty.travel.core.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service("multiFileUpload")
public class MultiFileUpload{

	public ArrayList<String> fileUploader(List<File> fileUpload,
			List<String> fileUploadContentType, List<String> fileUploadFileName,ServletContext servletContext,String midPath) {
		ArrayList<String> imageUrls = new ArrayList<String>();
		for(String str : fileUploadContentType)
			if(!(str.equals("image/jpg")||str.equals("image/png")||
					str.equals("image/gif")||str.equals("image/jpeg"))) {
				System.out.println("returning null content type problem");
				return null;
			}
		
		for(int i=0;i<fileUpload.size();i++){
			try
			{	
				String path="images" + File.separator + midPath + 
				File.separator + fileUploadFileName.get(i);
				String realPath=servletContext.getRealPath(path);
				System.out.println(path + "\n" + realPath);
				File file = new File(realPath);
				FileUtils.copyFile(fileUpload.get(i),file);
				imageUrls.add(path);
			}catch (Exception e) {
				System.out.println("returning null image path problem");
				return null;
			}
		}
		return imageUrls;
	}
}
