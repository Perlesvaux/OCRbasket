package corbenic.basket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MVCController{

    @GetMapping("/")
    public String showIndexPage(){
     return "jsformAsync";
    }

    @GetMapping("/fromfile")
    public String fromfile(){
     return "fromfile";
    }

    @GetMapping("/frompaste")
    public String frompaste(){
     return "frompaste";
    }
}
