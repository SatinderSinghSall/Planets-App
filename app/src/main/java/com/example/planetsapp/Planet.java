package com.example.planetsapp;

/*
    Model Class:
    > This class is acting as a 'Model Class'
      for ListView.

    > Model class consists of 'Attributes' also
      known as fields or properties which hold
      the data that we want to display for each
      item in a list.
      These attributes can be of various data types:
      such as - String, int, bool, etc.
*/

public class Planet
{
    // Attributes:
    private String PlanetName;
    private String MoonCount;
    private int PlanetImage;

    // Constructor:
    public Planet(String PlanetName, String MoonCount, int PlanetImage)
    {
        this.PlanetName = PlanetName;
        this.MoonCount = MoonCount;
        this.PlanetImage = PlanetImage;
    }

    // Getters and Setters:
    public String getPlanetName()
    {
        return PlanetName;
    }

    public void setPlanetName(String planetName)
    {
        PlanetName = planetName;
    }

    public String getMoonCount()
    {
        return MoonCount;
    }

    public void setMoonCount(String moonCount)
    {
        MoonCount = moonCount;
    }

    public int getPlanetImage()
    {
        return PlanetImage;
    }

    public void setPlanetImage(int planetImage)
    {
        PlanetImage = planetImage;
    }
}
