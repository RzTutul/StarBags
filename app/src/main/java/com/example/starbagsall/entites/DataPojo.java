package com.example.starbagsall.entites;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "StarBagData")
public class DataPojo {
    @PrimaryKey(autoGenerate = true)
    long id;
    double handleValue;
    public double dcutValue;
    double wcutValue;
    double gsm40Value;
    double gsm50Value;
    double gsm60Value;
    double gsm70Value;
    double gsm80Value;
    double autoSealingValue;
    double netSwingValue;
    double noColorValue;
    double color1Value;
    double color2Value;
    double color3Value;
    double color4Value;
    double screenPrint;
    double profitValue;


    @Ignore
    public DataPojo(long id, double handleValue, double dcutValue, double wcutValue, double gsm40Value, double gsm50Value, double gsm60Value, double gsm70Value, double gsm80Value, double autoSealingValue, double netSwingValue, double noColorValue, double color1Value, double color2Value, double color3Value, double color4Value, double screenPrint,double profitValue) {
        this.id = id;
        this.handleValue = handleValue;
        this.dcutValue = dcutValue;
        this.wcutValue = wcutValue;
        this.gsm40Value = gsm40Value;
        this.gsm50Value = gsm50Value;
        this.gsm60Value = gsm60Value;
        this.gsm70Value = gsm70Value;
        this.gsm80Value = gsm80Value;
        this.autoSealingValue = autoSealingValue;
        this.netSwingValue = netSwingValue;
        this.noColorValue = noColorValue;
        this.color1Value = color1Value;
        this.color2Value = color2Value;
        this.color3Value = color3Value;
        this.color4Value = color4Value;
        this.screenPrint = screenPrint;
        this.profitValue = profitValue;
    }

    public DataPojo(double handleValue, double dcutValue, double wcutValue, double gsm40Value, double gsm50Value, double gsm60Value, double gsm70Value, double gsm80Value, double autoSealingValue, double netSwingValue, double noColorValue, double color1Value, double color2Value, double color3Value, double color4Value, double screenPrint,double profitValue) {
        this.handleValue = handleValue;
        this.dcutValue = dcutValue;
        this.wcutValue = wcutValue;
        this.gsm40Value = gsm40Value;
        this.gsm50Value = gsm50Value;
        this.gsm60Value = gsm60Value;
        this.gsm70Value = gsm70Value;
        this.gsm80Value = gsm80Value;
        this.autoSealingValue = autoSealingValue;
        this.netSwingValue = netSwingValue;
        this.noColorValue = noColorValue;
        this.color1Value = color1Value;
        this.color2Value = color2Value;
        this.color3Value = color3Value;
        this.color4Value = color4Value;
        this.screenPrint = screenPrint;
        this.profitValue = profitValue;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHandleValue() {
        return handleValue;
    }

    public void setHandleValue(double handleValue) {
        this.handleValue = handleValue;
    }

    public double getdCutValue() {
        return dcutValue;
    }

    public void setdCutValue(double dCutValue) {
        this.dcutValue = dCutValue;
    }

    public double getWcutValue() {
        return wcutValue;
    }

    public void setWcutValue(double wcutValue) {
        this.wcutValue = wcutValue;
    }

    public double getGsm40Value() {
        return gsm40Value;
    }

    public void setGsm40Value(double gsm40Value) {
        this.gsm40Value = gsm40Value;
    }

    public double getGsm50Value() {
        return gsm50Value;
    }

    public void setGsm50Value(double gsm50Value) {
        this.gsm50Value = gsm50Value;
    }

    public double getGsm60Value() {
        return gsm60Value;
    }

    public void setGsm60Value(double gsm60Value) {
        this.gsm60Value = gsm60Value;
    }

    public double getGsm70Value() {
        return gsm70Value;
    }

    public void setGsm70Value(double gsm70Value) {
        this.gsm70Value = gsm70Value;
    }

    public double getGsm80Value() {
        return gsm80Value;
    }

    public void setGsm80Value(double gsm80Value) {
        this.gsm80Value = gsm80Value;
    }

    public double getAutoSealingValue() {
        return autoSealingValue;
    }

    public void setAutoSealingValue(double autoSealingValue) {
        this.autoSealingValue = autoSealingValue;
    }

    public double getNetSwingValue() {
        return netSwingValue;
    }

    public void setNetSwingValue(double netSwingValue) {
        this.netSwingValue = netSwingValue;
    }

    public double getNoColorValue() {
        return noColorValue;
    }

    public void setNoColorValue(double noColorValue) {
        this.noColorValue = noColorValue;
    }

    public double getColor1Value() {
        return color1Value;
    }

    public void setColor1Value(double color1Value) {
        this.color1Value = color1Value;
    }

    public double getColor2Value() {
        return color2Value;
    }

    public void setColor2Value(double color2Value) {
        this.color2Value = color2Value;
    }

    public double getColor3Value() {
        return color3Value;
    }

    public void setColor3Value(double color3Value) {
        this.color3Value = color3Value;
    }

    public double getColor4Value() {
        return color4Value;
    }

    public void setColor4Value(double color4Value) {
        this.color4Value = color4Value;
    }

    public double getScreenPrint() {
        return screenPrint;
    }

    public void setScreenPrint(double screenPrint) {
        this.screenPrint = screenPrint;
    }

    public double getDcutValue() {
        return dcutValue;
    }

    public void setDcutValue(double dcutValue) {
        this.dcutValue = dcutValue;
    }

    public double getProfitValue() {
        return profitValue;
    }

    public void setProfitValue(double profitValue) {
        this.profitValue = profitValue;
    }
}
