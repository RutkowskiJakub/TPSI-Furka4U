/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    
    @Autowired
    OffersService service;
    
    @RequestMapping("/")
    public String home(Model model) throws SQLException {

        model.addAttribute("Producent", service.getCarManufacturer(2));
        model.addAttribute("Produkt", service.getModel(3));

        return "home";
    }
    
}
