package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class FilesUpload {

	public String upload(UploadedFile fileUpload) {
		try {
			String[] getType = fileUpload.getContentType().split("/");
			if (getType[1].equalsIgnoreCase("jpeg")) {
				getType[1] = "jpg";
			}
                        
			File file = new File("file", "." + getType[1]);

			FileUtils.copyInputStreamToFile(fileUpload.getFile(), file);
                        
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "nerdzonia", "api_key",
					"966118315853311", "api_secret", "HRv2x14ZTrL-YtfzIsgyrmBIcDw"));
                        Map params = null;
                        UuidGenerator uuid = new UuidGenerator();
                        if(getType[0].equalsIgnoreCase("video")){
                            params =  ObjectUtils.asMap("public_id", "Home/video/"+fileUpload.getFileName()+uuid.Uuid(), "resource_type", "video");
                        }else {
                            params =  ObjectUtils.asMap("public_id", "Home/photo/"+fileUpload.getFileName()+uuid.Uuid());
                        }
    
			Map<String, String> uploadResult = cloudinary.uploader().upload(file, params);
                        return uploadResult.get("url");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
                        return null;
		}                
	}
}
