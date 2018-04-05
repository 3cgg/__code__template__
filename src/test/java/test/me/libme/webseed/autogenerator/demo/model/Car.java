package test.me.libme.webseed.autogenerator.demo.model;

import me.libme.module.spring.jpahibernate._m.JBaseModel;

import java.util.Date;

public class Car extends JBaseModel {

    private String name;

    private String color;

    private String log;

    private double weight;

    private Date produceTime;

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
