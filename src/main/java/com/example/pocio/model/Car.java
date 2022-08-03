package com.example.pocio.model;

import com.example.pocio.model.interfaces.Properties;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public final class Car implements Properties, Cloneable
        ,Comparable<Car>
{

    private String model;
    private String brand;
    private Integer price;

    public void setPrice(Integer price){
        this.price = price;
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

    //El @Data ya lo incluye por defecto

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(price, car.price);
    }

//    @Override
//    public int hashCode() {
//        int hash = 1;
//        hash = hash * 17 + model.hashCode();
//        hash = hash * 31 + brand.hashCode();
//        return hash;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(model, brand, price);
    }

    @Override
    public int compareTo(Car o) {
        return this.price - o.getPrice();
    }

}
