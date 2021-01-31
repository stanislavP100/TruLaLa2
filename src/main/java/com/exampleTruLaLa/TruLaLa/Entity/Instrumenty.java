package com.exampleTruLaLa.TruLaLa.Entity;


import javax.persistence.*;

@Entity
@Table(name="instrument", catalog = "truladb")
public class Instrumenty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  Long id;

    @Column(name="name")
    private  String name;

    @Column(name="price")
    private  Float price;

    @Column(name="imagePath")
    private  String imagePath;

    private String categoty ="instrument";

    @Column
    private  String description;

    @Column
    private String pidCategory;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPidCategory() {
        return pidCategory;
    }

    public void setPidCategory(String pidCategory) {
        this.pidCategory = pidCategory;
    }

    public Instrumenty(String name, Float price, String imagePath, String category) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;

    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public static String getClassName(){
        return "Instrumenty";
    }

    public Instrumenty() {}

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Instrumenty(Long id, String name, Float price, String imagePath) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.imagePath=imagePath;

    }

    public Instrumenty(Instrumenty good)
    {
        this.id=good.id;
        this.name=good.name;
        this.price=good.price;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price =  price;
    }

    @Override
    public String toString() {
        return "Instrumenty {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
