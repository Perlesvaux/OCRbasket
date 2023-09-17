package corbenic.basket;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Scaling{
    public static BufferedImage process(File img) throws IOException{

        //Loading image
        BufferedImage original = ImageIO.read(img);

        //Creating new image with desired DPI
        BufferedImage resized = new BufferedImage(
                original.getWidth()  * 300 / 25, 
                original.getHeight() * 300 / 25, //72
                BufferedImage.TYPE_INT_RGB
                );
        
        
        Graphics2D g = resized.createGraphics();
        g.drawImage(
                original,
                0,0,
                resized.getWidth(),
                resized.getHeight(),
                null
                );

        g.dispose();
        return resized;



    }
}
