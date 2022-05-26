package lab4.models;

import java.util.List;

public class Worker {

    private int id;

    private String name;

    private int age;

    
    private List<Car> cars;
    
    public Worker() {
    	
    }

    public Worker(int id, String name, int age) {
    	this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	/*
	 * public void addCar(Car car) { car.setWorker_id(this); cars.add(car); }
	 * 
	 * public void removeCar(Car car) { cars.remove(car); }
	 */

}