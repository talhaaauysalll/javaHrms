package kodlamaio.javahrms.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryAdapter implements ImageService{

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryAdapter(){
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvas3buuu",
                "api_key", "894454925758333",
                "api_secret", "YfH5P2u7wezD6mxgAeGH4g62Hxs"));
    }


    @Override
    public DataResult<Map> uploadImage(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String,String> uploadedResult = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadedResult.get("url").toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map>();
        }
    }


}
