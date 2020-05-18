/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    
    @Autowired
    OffersService offersService;
    
//    @RequestMapping("/")
//    public String home(Model model) throws SQLException {
//
//        model.addAttribute("cManufacturer", offersService.getCarManufacturer(2));
//        model.addAttribute("cModel", offersService.getModel(3));
//
//        return "home";
//    }
    
    @GetMapping("/")
    public String home(Model model) {
        List<CarManufacturer> carManufacturers = offersService.getCarManufacturers();
        model.addAttribute("carManufacturers", carManufacturers);
        
        List<CarModel> carModels = offersService.getCarModels();
        model.addAttribute("carModels", carModels);
        
        List<BodyStyle> bodyStyles = offersService.getBodyStyles();
        model.addAttribute("bodyStyles", bodyStyles);
        
        List<FuelType> fuelTypes = offersService.getFuelTypes();
        model.addAttribute("fuelTypes", fuelTypes);
        
        List<CarModel> carModels2 = offersService.getCarModels(2);
        model.addAttribute("carModels2", carModels2);
        
        List<Offer> offers = offersService.getOffers();
        model.addAttribute("offers", offers);
        
        List<Offer> offersByModel = offersService.getOffersByModel(13);
        model.addAttribute("offersByModel", offersByModel);
        
//        List<Offer> offersByManufacturer = offersService.getOffersByManufacturer(3);
//        model.addAttribute("offersByManufacturer", offersByManufacturer);

        List<Offer> offersById = offersService.getOffer(3);
        model.addAttribute("offersById", offersById);
        
        return "offersList";
        
        
}
}
