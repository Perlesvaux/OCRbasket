package corbenic.basket;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileCopyUtils;
import net.sourceforge.tess4j.TesseractException;
import java.io.*;

@RestController
public class Basket{

    @PostMapping("/upload")
    public String uploadingFile(@RequestBody MultipartFile file) throws IllegalStateException, IOException, TesseractException{

        File temp =  File.createTempFile("temp", ".png"); //Just a convention. The extension doesn't matter.
        String result = "";
        try{
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(temp));
            // result = Ocr.dump(Scaling.process(temp));
            // result = LazyImageProcessing.lazyOCR(Scaling.process(temp));
            result = Ocr.curate(Scaling.process(temp));
        return result;
        } catch(IOException e) {
            result =  "mission failed :p";
        return result;
        } finally {
            temp.delete();
        }
    }
}

