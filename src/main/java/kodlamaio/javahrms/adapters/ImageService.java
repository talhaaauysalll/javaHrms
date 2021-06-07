package kodlamaio.javahrms.adapters;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {
    DataResult<Map> uploadImage(MultipartFile imageFile);
}
