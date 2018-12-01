package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import model.Media;

public class FilesUpload {
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "xxxxx", "api_key",
			"xxxxxx", "api_secret", "xxxxx"));
	
	// Save a nem uploaded file on server
	public Map upload(UploadedFile fileUpload) {
		try {
			String[] getType = fileUpload.getContentType().split("/");
			if (getType[1].equalsIgnoreCase("jpeg")) {
				getType[1] = "jpg";
			}
                        
			File file = new File("file", "." + getType[1]);

			FileUtils.copyInputStreamToFile(fileUpload.getFile(), file);
            
                        Map params = null;
                        UuidGenerator uuid = new UuidGenerator();
                        if(getType[0].equalsIgnoreCase("video")){
                            params =  ObjectUtils.asMap("public_id", "Home/video/"+fileUpload.getFileName()+uuid.Uuid(), "resource_type", "video");
                        }else {
                            params =  ObjectUtils.asMap("public_id", "Home/photo/"+fileUpload.getFileName()+uuid.Uuid());
                        }
    
			Map<String, String> uploadResult = cloudinary.uploader().upload(file, params);
                        return uploadResult;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
                        return null;
		}                
	}
	
	// Get Uploaded file and overwrite in server for new file
	public Map atualizeFile(UploadedFile fileUpload, Media media) {
		try {
			String[] getType = fileUpload.getContentType().split("/");
			if (getType[1].equalsIgnoreCase("jpeg")) {
				getType[1] = "jpg";
			}
                        
			File file = new File("file", "." + getType[1]);

			FileUtils.copyInputStreamToFile(fileUpload.getFile(), file);
            
                        Map params = null;
                        UuidGenerator uuid = new UuidGenerator();
                        if(getType[0].equalsIgnoreCase("video")){
                            params =  ObjectUtils.asMap("public_id", "Home/video/"+media.getMediaName(), "resource_type", "video");
                        }else {
                            params =  ObjectUtils.asMap("public_id", "Home/photo/"+media.getMediaName()+uuid.Uuid());
                        }
    
			Map<String, String> uploadResult = cloudinary.uploader().upload(file, params);
                        return uploadResult;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}finally {
			
		}
	}
}
