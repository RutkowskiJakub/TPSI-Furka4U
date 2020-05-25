/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.jpa;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "offer")
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 255, min = 5)
    @NotNull
    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Min(1900)
    @NotNull
    @Column(name = "year")
    private Integer year;

    @Min(0)
    @NotNull
    @Column(name = "mileage")
    private Integer mileage;

    @Min(0)
    @Column(name = "engine_size")
    private BigDecimal engineSize;

    @Min(0)
    @Column(name = "engine_power")
    private Integer enginePower;
    
    @Min(1)
    @Max(5)
    @NotNull
    @Column(name = "doors")
    private Integer doors;

    @Size(max = 30, min = 3)
    @NotNull
    @Size(max = 30)
    @Column(name = "colour")
    private String colour;

    @NotNull
    @Lob
    @Size(max = 65535, min = 5)
    @Column(name = "description")
    private String description;

    @Min(0)
    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne
    private CarModel model;

    @NotNull
    @JoinColumn(name = "body_style_id", referencedColumnName = "id")
    @ManyToOne
    private BodyStyle bodyStyle;

    @NotNull
    @JoinColumn(name = "fuel_type_id", referencedColumnName = "id")
    @ManyToOne
    private FuelType fuelType;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public BigDecimal getEngineSize() {
        return engineSize;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getColour() {
        return colour;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public CarModel getModel() {
        return model;
    }

    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineSize(BigDecimal engineSize) {
        this.engineSize = engineSize;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public void setBodyStyle(BodyStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    
    public Offer(){
        
    }

    public Offer(Integer id, String title, Integer year, Integer mileage, BigDecimal engineSize, Integer enginePower, Integer doors, String colour, String description, Integer price, CarModel model, BodyStyle bodyStyle, FuelType fuelType) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.mileage = mileage;
        this.engineSize = engineSize;
        this.enginePower = enginePower;
        this.doors = doors;
        this.colour = colour;
        this.description = description;
        this.price = price;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.fuelType = fuelType;
    }
    
    
}
