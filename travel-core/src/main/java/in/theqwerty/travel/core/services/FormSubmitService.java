package in.theqwerty.travel.core.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service("formSubmitService")
public class FormSubmitService{

	public ArrayList<String> fileUploader(List<File> fileUpload,
			List<String> fileUploadContentType, List<String> fileUploadFileName,ServletContext servletContext,String midPath,String identifier) {
		ArrayList<String> imageUrls = new ArrayList<String>();
		
		if(fileUpload.size()==0)
			return imageUrls;
		
		for(String str : fileUploadContentType)
			if(!(str.contains("image") && (str.contains("jpg")||str.contains("png")||
					str.contains("gif")||str.contains("jpeg")) )) {
				System.out.println("returning null content type problem");
				return null;
			}
		
		for(int i=0;i<fileUpload.size();i++){
			try
			{	
				String path="images" + File.separator + midPath + 
				File.separator + identifier + "_" + fileUploadFileName.get(i);
				String realPath=servletContext.getRealPath(path);
				System.out.println(path + "\n" + realPath);
				File file = new File(realPath);
				FileUtils.copyFile(fileUpload.get(i),file);
				
				//only forward slashes browser issues
				imageUrls.add(path.replace('\\', '/').toString());
				
			}catch (Exception e) {
				System.out.println("returning null image path problem");
				return null;
			}
		}
		return imageUrls;
	}
	
	public ArrayList<String> getListOutOfList(ArrayList<String> list) {
		ArrayList<String> listToReturn = new ArrayList<String>();
		for(String str : list)
			listToReturn.add(str);
		
		return listToReturn;
	}
	
	public void pathChecker() {
		String path="images" + File.separator +"hel/lo";
		System.out.println(path);
		
		System.out.println(path.replace('\\', '/').toString());
	}
	
}
