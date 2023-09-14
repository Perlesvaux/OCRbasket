package corbenic.basket;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BasketService{

    public void uploading(MultipartFile file) throws IllegalStateException, IOException{
        file.transferTo(new File("/home/chico/Downloads/" + file.getOriginalFilename()));
    }
}
