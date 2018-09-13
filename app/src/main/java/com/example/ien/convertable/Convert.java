package com.example.ien.convertable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Convert {
    @SerializedName("RUB_EUR")
    @Expose
    private Double rUBEUR;
    @SerializedName("EUR_RUB")
    @Expose
    private Double eURRUB;

    @SerializedName("RUB_USD")
    @Expose
    private Double rUBUSD;
    @SerializedName("USD_RUB")
    @Expose
    private Double uSDRUB;


    @SerializedName("USD_EUR")
    @Expose
    private Double uSDEUR;
    @SerializedName("EUR_USD")
    @Expose
    private Double eURUSD;

    public Double getRUBEUR() {
        return rUBEUR;
    }

    public void setRUBEUR(Double rUBEUR) {
        this.rUBEUR = rUBEUR;
    }

    public Double getEURRUB() {
        return eURRUB;
    }

    public void setEURRUB(Double eURRUB) {
        this.eURRUB = eURRUB;
    }


    public Double getRUBUSD() {
        return rUBUSD;
    }

    public void setRUBUSD(Double rUBUSD) {
        this.rUBUSD = rUBUSD;
    }

    public Double getUSDRUB() {
        return uSDRUB;
    }

    public void setUSDRUB(Double uSDRUB) {
        this.uSDRUB = uSDRUB;
    }

    public Double getUSDEUR() {
        return uSDEUR;
    }

    public void setUSDEUR(Double rUBEUR) {
        this.rUBEUR = uSDEUR;
    }

    public Double getEURUSD() {
        return eURUSD;
    }

    public void setEURUSD(Double eURRUB) {
        this.eURUSD = eURRUB;
    }

}
