package com.exampleTruLaLa.TruLaLa;


import javax.persistence.*;

@Entity
@Table(name = "electroTools", catalog = "truladb")

public class ElectroTools {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  Long id;

    @Column(name="name")
    private  String name;

    @Column(name="price")
    private  Float price;

    public ElectroTools() {
    }

    public ElectroTools (Long id, String name, Float price){

        this.id=id;
        this.name=name;
        this.price=price;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ElectroTools{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
