package com.ProiectSI;

public class JavaUtilities {


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



