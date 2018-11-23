package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class FilesUpload {

	public void upload(UploadedFile fileUpload) {
			try {
                            String[] getType = fileUpload.getFileName().split("/");
                            if(getType[1].equalsIgnoreCase("jpeg")){
                                getType[1] = "jpg";
                            }
			File file = new File("file", "."+getType[1]);
                        
			FileUtils.copyInputStreamToFile(fileUpload.getFile(), file);
                        
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", "nerdzonia",
					"api_key","966118315853311", 
					"api_secret", "HRv2x14ZTrL-YtfzIsgyrmBIcDw"
					));
	
			Map<String, String> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", "Nerdzonia"));
			
			System.out.println(uploadResult.get("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
