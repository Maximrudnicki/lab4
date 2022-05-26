package lab4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lab4.models.Car;
import lab4.models.Worker;

@Component
public class CarDAO {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CarDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Car> index(){
		return jdbcTemplate.query("select * from cars", new BeanPropertyRowMapper<>(Car.class));
	}
	
	public Car show(int car_id) {
    	return jdbcTemplate.query("select * from cars where car_id=?", new Object[] {car_id}, new BeanPropertyRowMapper<>(Car.class))
				.stream().findAny().orElse(null);
    }

    public void save(Car car) {
    	jdbcTemplate.update("insert into cars(model, color, worker_id) values(?,?,?)", car.getModel(), car.getColor(), car.getWorker_id());
    }

    public void update(int car_id, Car updatedCar) {
    	jdbcTemplate.update("UPDATE cars SET model=?, color=? WHERE car_id=?", 
    			updatedCar.getModel(), updatedCar.getColor(), car_id);
    }

    public void delete(int car_id) {
		jdbcTemplate.update("delete from cars where car_id=?", car_id);
	}
	
}
