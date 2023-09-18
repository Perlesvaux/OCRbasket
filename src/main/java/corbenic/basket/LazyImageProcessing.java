package corbenic.basket;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class LazyImageProcessing {
    public static String lazyOCR(BufferedImage chunk) throws TesseractException {
        String chunkResult = "";

        // Define the chunk size (adjust according to your memory capacity)
        // int chunkHeight = bi.getHeight()/10;

        // Initialize Tesseract
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());

        tesseract.setVariable("user_defined_dpi", "300"); // Set DPI to 300
        // tesseract.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata");

        // Process image in chunks
        for (int y = 0; y < chunk.getHeight()-chunk.getHeight()/7; y += chunk.getHeight()/7) {
            System.out.println("y: " + y + " vs. height: " + chunk.getHeight()); 
        // }
                
                // int chunkActualHeight = Math.min(chunkHeight, bi.getHeight() - y);

                // Extract a chunk of the image within bounds
                BufferedImage piece = chunk.getSubimage(0, y, chunk.getWidth(), chunk.getHeight()/7);

                try {
                    // Perform OCR on the chunk
                    String part = tesseract.doOCR(piece);
                    chunkResult += part;

                    // Process or aggregate the OCR result as needed
                    System.out.println("Chunk OCR Result: " + part);
                } catch (TesseractException e) {
                    // Handle OCR errors if necessary
                    chunkResult = "I AM ERROR";
                    e.printStackTrace();
                }
            }
        return chunkResult;
    }
}
