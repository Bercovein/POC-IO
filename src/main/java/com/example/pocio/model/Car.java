package com.example.pocio.model;

import com.example.pocio.model.interfaces.Properties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class Car implements Properties, Cloneable {

    private String model;
    private String brand;
    private Integer price;

    public int setPrice(Integer price){
        this.setPrice(price);
        return this.getPrice();
    }

    public int setPrice(Float price){
        this.setPrice(price.intValue());
        return this.getPrice();
    }

    public Float setPrice(Float price, Float percent){
        this.setPrice(price * percent);
        return this.getPrice().floatValue();
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
