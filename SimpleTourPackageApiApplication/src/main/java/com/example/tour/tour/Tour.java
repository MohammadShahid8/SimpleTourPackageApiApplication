package com.example.tour.tour;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    private Long id;

    @NotBlank(message = "image URL is required")
    private String image;

    @NotBlank(message = "discountInPercentage is required")
    
    @Pattern(regexp = "^[0-9]{1,2}%$", message = "discountInPercentage must be like '17%'")
    private String discountInPercentage;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "duration is required")
    private String duration;

    @NotBlank(message = "actualPrice is required")
  
    private String actualPrice;

    @NotBlank(message = "discountedPrice is required")
    private String discountedPrice;

    @Column(name = "actual_price_value")
    @NotNull
    @Positive
    private Integer actualPriceValue;

    @Column(name = "discounted_price_value")
    @NotNull
    @Positive
    private Integer discountedPriceValue;

    public Tour() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscountInPercentage() {
        return discountInPercentage;
    }

    public void setDiscountInPercentage(String discountInPercentage) {
        this.discountInPercentage = discountInPercentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Integer getActualPriceValue() {
        return actualPriceValue;
    }

    public void setActualPriceValue(Integer actualPriceValue) {
        this.actualPriceValue = actualPriceValue;
    }

    public Integer getDiscountedPriceValue() {
        return discountedPriceValue;
    }

    public void setDiscountedPriceValue(Integer discountedPriceValue) {
        this.discountedPriceValue = discountedPriceValue;
    }
}
