/*package com.company.hellobanking.models;

import javax.persistence.*;

@Table(name = "AtmLocator", uniqueConstraints = @UniqueConstraint(columnNames = "zipcode"))

public class AtmLocator extends AbstractEntity{
    @Column(name = "zipcode")
    private int zipCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "state")
    private String stateName;

    public AtmLocator(){}

    public AtmLocator(int zipCode, String cityName, String stateName){
        super();
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.stateName = stateName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
*/