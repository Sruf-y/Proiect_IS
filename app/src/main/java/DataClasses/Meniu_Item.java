package DataClasses;

import java.util.List;

public class Meniu_Item {
    private int image_id;
    private String name;
    private String category; 
    private double price;
    private boolean available;
    private String description;             
    private String nutritionDescription;   

 
    public Meniu_Item(int image_id, String name, String category, double price, boolean available,
                      List<String> ingredients, boolean isSpicy, boolean isVegetarian,
                      String description, String nutritionDescription) {
        this.image_id=image_id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
        this.description = description;
        this.nutritionDescription = nutritionDescription;
    }
    public Meniu_Item(){

    }
    public Meniu_Item(String nume){
        this.name=nume;
    }


    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNutritionDescription() {
        return nutritionDescription;
    }

    public void setNutritionDescription(String nutritionDescription) {
        this.nutritionDescription = nutritionDescription;
    }


    @Override
    public String toString() {
        return "Nume='" + name + "'\nPret=" + price;
    }
}
