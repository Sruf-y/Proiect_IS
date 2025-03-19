package DataClasses;

import java.util.List;

public class Meniu_Item {
    private int id;
    private String name;
    private String category; 
    private double price;
    private boolean available;
    private List<String> ingredients;
    private boolean isSpicy;
    private boolean isVegetarian;
    private String description;             
    private String nutritionDescription;   

 
    public Meniu_Item(int id, String name, String category, double price, boolean available,
                      List<String> ingredients, boolean isSpicy, boolean isVegetarian,
                      String description, String nutritionDescription) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
        this.ingredients = ingredients;
        this.isSpicy = isSpicy;
        this.isVegetarian = isVegetarian;
        this.description = description;
        this.nutritionDescription = nutritionDescription;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
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
