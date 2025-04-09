package DataClasses;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Meniu_Item implements Parcelable {
    private int image_id =-1;
    private String name="DefaultName";
    private Categorie category=Categorie.aperitiv;
    private double price=0.00;
    private boolean available=true;
    private String description="DefaultDescription";
    private String nutritionDescription="DefaultNotritionDescription";

 
    public Meniu_Item(int image_id, String name, Categorie category, double price, boolean available,
                      String description, String nutritionDescription) {

        if(image_id!=-1)
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


    protected Meniu_Item(Parcel in) {
        image_id = in.readInt();
        name = in.readString();
        price = in.readDouble();
        available = in.readByte() != 0;
        description = in.readString();
        nutritionDescription = in.readString();
    }

    public static final Creator<Meniu_Item> CREATOR = new Creator<Meniu_Item>() {
        @Override
        public Meniu_Item createFromParcel(Parcel in) {
            return new Meniu_Item(in);
        }

        @Override
        public Meniu_Item[] newArray(int size) {
            return new Meniu_Item[size];
        }
    };

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

    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
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

    public final Meniu_Item Parse(String textline){


        Meniu_Item aux = null;
        try{
            String[] pieces = textline.split("/");

            aux=new Meniu_Item(Integer.parseInt(pieces[0]),pieces[1],Categorie.valueOf(pieces[2].toLowerCase()),Double.parseDouble(pieces[3]),Boolean.getBoolean(pieces[4]),pieces[5],pieces[6]);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return aux;
    }


    public final ArrayList<Meniu_Item> ParseArrayList(String textline) {
        ArrayList<Meniu_Item> lista = new ArrayList<>();

        try {
            String[] objects = textline.split(";");
            for (String object : objects) {
                String[] pieces = object.split("/");

                if (pieces.length == 7) {

                    Meniu_Item aux = new Meniu_Item(Integer.parseInt(pieces[0]), pieces[1], Categorie.valueOf(pieces[2].toLowerCase()), Double.parseDouble(pieces[3]), Boolean.getBoolean(pieces[4]), pieces[5], pieces[6]);

                    lista.add(aux);

                }
                else if(pieces.length == 6)
                {
                    Meniu_Item aux = new Meniu_Item(-1, pieces[0], Categorie.valueOf(pieces[1].toLowerCase()), Double.parseDouble(pieces[2]), Boolean.getBoolean(pieces[3]), pieces[4], pieces[5]);
                    lista.add(aux);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Log.i("ERRORS","Eroare parse list");
        }
        return lista;
    }




    @Override
    public String toString() {
        return "Nume='" + name + "'\nPret=" + price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(image_id);
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeByte((byte) (available ? 1 : 0));
        parcel.writeString(description);
        parcel.writeString(nutritionDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Meniu_Item meniuItem = (Meniu_Item) o;
        return image_id == meniuItem.image_id && Double.compare(price, meniuItem.price) == 0 && available == meniuItem.available && Objects.equals(name, meniuItem.name) && category == meniuItem.category && Objects.equals(description, meniuItem.description) && Objects.equals(nutritionDescription, meniuItem.nutritionDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image_id, name, category, price, available, description, nutritionDescription);
    }
}
