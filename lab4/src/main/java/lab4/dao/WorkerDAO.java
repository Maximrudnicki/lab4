package lab4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lab4.models.Car;
import lab4.models.Worker;

@Component
public class WorkerDAO {

	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public WorkerDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Worker> index(){
		return jdbcTemplate.query("select * from workers", new BeanPropertyRowMapper<>(Worker.class));
	}
	
    public Worker show(int id) {
    	return jdbcTemplate.query("select * from workers where id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Worker.class))
				.stream().findAny().orElse(null);
    }

    public void save(Worker worker) {
    	jdbcTemplate.update("insert into workers(name, age) values(?,?)", worker.getName(), worker.getAge());
    }

    public void update(int id, Worker updatedWorker) {
    	jdbcTemplate.update("UPDATE workers SET name=?, age=? WHERE id=?", 
				updatedWorker.getName(), updatedWorker.getAge(), id);
    }

    public void delete(int id) {
    	jdbcTemplate.update("delete from cars where worker_id=?", id);
		jdbcTemplate.update("delete from workers where id=?", id);
	}

    public Worker showCars(int id) {
    	return jdbcTemplate.query("select * from cars where worker_id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Worker.class))
				.stream().findAny().orElse(null);
    }

    

}