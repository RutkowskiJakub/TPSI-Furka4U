/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia;

import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.services.OffersService;
import wizut.tpsi.ogloszenia.web.OfferFilter;

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
    public String home(Model model, OfferFilter offerFilter) {
        List<CarManufacturer> carManufacturers = offersService.getCarManufacturers();
        //List<CarModel> carModels = offersService.getCarModels();
        List<CarModel> carModels;
        //List<Offer> offers = offersService.getOffers();
        List<Offer> offers;
        
        
//        if(offerFilter.getManufacturerId() == null && offerFilter.getModelId() == null){
//            offers = offersService.getOffers();
//            carModels = null;
//        }
        
        
        if (offerFilter.getManufacturerId() != null && offerFilter.getModelId() == null){
            offers = offersService.getOffersByManufacturer(offerFilter.getManufacturerId());
            carModels = offersService.getCarModels(offerFilter.getManufacturerId());
            System.out.println("Jestem w 1 ifie");
        } 
        
        else if (offerFilter.getManufacturerId() != null && offerFilter.getModelId() != null){
            offers = offersService.getOffersByModel(offerFilter.getModelId());
            System.out.println("offerFilter.getModelId() = " + offerFilter.getModelId());
            carModels = offersService.getCarModels(offerFilter.getManufacturerId());
            System.out.println("Jestem w 2 ifie");
        }
        
        else {
            offers = offersService.getOffers();
            carModels = null;
            System.out.println("Jestem w elsie");
        }
         
        model.addAttribute("carManufacturers", carManufacturers);
        model.addAttribute("carModels", carModels);
        model.addAttribute("offers", offers);
        
//        List<BodyStyle> bodyStyles = offersService.getBodyStyles();
//        model.addAttribute("bodyStyles", bodyStyles);
//        
//        List<FuelType> fuelTypes = offersService.getFuelTypes();
//        model.addAttribute("fuelTypes", fuelTypes);
//        
//        List<CarModel> carModels2 = offersService.getCarModels(2);
//        model.addAttribute("carModels2", carModels2);
//        
//        List<Offer> offersByModel = offersService.getOffersByModel(13);
//        model.addAttribute("offersByModel", offersByModel);
//        
//        List<Offer> offersByManufacturer = offersService.getOffersByManufacturer(3);
//        model.addAttribute("offersByManufacturer", offersByManufacturer);
//
//        List<Offer> offersById = offersService.getOffer(3);
//        model.addAttribute("offersById", offersById);
        
        return "offersList";
        }
    
    @GetMapping("/offer/{id}")
    public String offerDetails(Model model, @PathVariable("id") Integer id){
        Offer offer = offersService.getOffer(id);
        model.addAttribute("offer", offer);
        return "offerDetails";
    }
    
    @GetMapping("/newoffer")
    public String newOfferForm(Model model, Offer offer){
        List<CarModel> carModels = offersService.getCarModels();
        List<BodyStyle> bodyStyles = offersService.getBodyStyles();
        List<FuelType> fuelTypes = offersService.getFuelTypes();
        
        model.addAttribute("carModels", carModels);
        model.addAttribute("bodyStyles", bodyStyles);
        model.addAttribute("fuelTypes", fuelTypes);
        return "offerForm";
    }
    
    @PostMapping("/newoffer")
    public String saveNewOffer(Model model, @Valid Offer offer, BindingResult binding){
        if(binding.hasErrors()){
            List<CarModel> carModels = offersService.getCarModels();
            List<BodyStyle> bodyStyles = offersService.getBodyStyles();
            List<FuelType> fuelTypes = offersService.getFuelTypes();
            
            model.addAttribute("carModels", carModels);
            model.addAttribute("bodyStyles", bodyStyles);
            model.addAttribute("fuelTypes", fuelTypes);
            return "offerForm";
        }
        offer = offersService.createOffer(offer);
        
        return "redirect:/offer/" + offer.getId();
    }
    
    @RequestMapping("/deleteoffer/{id}")
    public String deleteOffer(Model model, @PathVariable("id") Integer id){
        Offer offer = offersService.deleteOffer(id);
        model.addAttribute("offer", offer);
        return "deleteOffer";
    }
}
