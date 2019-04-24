package fi.devolon.demo.controller;


import fi.devolon.demo.service.UICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UIController {


    UICompanyService companyService;


    @GetMapping("/")
    public String home(Model model){
        return "index";
    }


    @PostMapping(value = "/all-companies")
    public String allCompanies(HttpServletRequest request, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "limit",defaultValue = "30") int limit, RedirectAttributes redirectAttributes,Model model) throws IOException {
        boolean result=companyService.getAllCompanies(request,model,redirectAttributes,page,limit);
        if (result) {
            return "all-companies";
        }else {
            return "redirect:/";
        }
    }

}
