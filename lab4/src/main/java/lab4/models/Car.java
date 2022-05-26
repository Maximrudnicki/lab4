package lab4.models;


public class Car {

    private int car_id;

    private String model;

    private String color;

    private int worker_id;

    public Car() {
    }

    public Car(int car_id, String model, String color, int worker_id) {
    	this.car_id = car_id;
        this.model = model;
        this.color = color;
        this.worker_id = worker_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }
}