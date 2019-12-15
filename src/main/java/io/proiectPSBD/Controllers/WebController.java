package io.proiectPSBD.Controllers;
import io.proiectPSBD.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @Autowired
    DoctorsRepository drepository;

    @RequestMapping(value= "/printall")
    public String printDoctor(Model model){
        model.addAttribute("doctors",drepository.findAll());
      //  model.addAttribute("branch", "Branch");
        return "doctors";
    }

    @RequestMapping(value="/branches")
    public String printBranches(Model model){
        model.addAttribute("branches",drepository.findAll());
        return "branches";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

}
