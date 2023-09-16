package corbenic.basket;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
// import java.io.File;
// import java.io.IOException;
// import java.io.FileReader;
// import java.io.BufferedReader;
import java.io.*;
import org.springframework.util.FileCopyUtils;
import net.sourceforge.tess4j.TesseractException;
// import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class Basket{

    @Autowired
    BasketService uploader;

    // @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/upload")
    public String uploadingFile(@RequestBody MultipartFile file) throws IllegalStateException, IOException, TesseractException{

    //This one works great by binding it to a form named "file"
    //public String uploadingFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException, TesseractException{


        //This one works great with plain text files!
        // byte[] fileBytes   = file.getBytes();
        // String fileContent = new String(fileBytes, "UTF-8");
        // return fileContent;


        //This one should work for images:
        File temp =  File.createTempFile("temp", ".png"); //Just a convention. The extension doesn't matter.
        String result = "";
        try{
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(temp));
            result = Ocr.dump(
                        Scaling.process(temp)
                        // temp
                    );
            // result = Ocr.dump(temp);

        return result;
        } catch(IOException e) {
            result =  "mission failed :p";
        return result;
        } finally {
            temp.delete();
        }







        // try(BufferedReader fp = new BufferedReader(file.getInputStream())){

        // }
        // uploader.uploading(file);
        // return "file: " + file.getOriginalFilename() + " has been uploaded :D!";



    }
}

