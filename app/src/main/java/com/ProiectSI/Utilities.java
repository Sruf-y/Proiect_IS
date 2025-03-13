package com.ProiectSI;

public class Utilities{


    public Boolean FloatToBoolean(float a){
        return a!=0;
    }
    public Boolean IntToBoolean(int a){
        return a!=0;
    }
    public int BooleanToInt(Boolean a)
    {
        return Integer.parseInt(a.toString());
    }
}
