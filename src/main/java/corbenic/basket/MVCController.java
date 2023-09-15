package corbenic.basket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MVCController{

    @GetMapping("/")
    public String showIndexPage(){
     return "jsformAsync";
    }

    @GetMapping("/home")
    public String homepage(){
     return "homepage";
    }

    @GetMapping("/homer")
    public String homeSecond(){
     return "homepageSecond";
    }
}
