package corbenic.basket;
import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Ocr{
    public static String read (String filename) throws TesseractException{
        Tesseract t = new Tesseract();
        t.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata");
        return t.doOCR(new File(filename));
    }

    public static String dump (File fp) throws TesseractException{
        Tesseract t = new Tesseract();
        t.setVariable("dpi", "300"); // Set DPI to 300
        // t.setDPI(300); // Set your desired DPI value (e.g., 300)
        t.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata");
        return t.doOCR(fp);

    }
}
