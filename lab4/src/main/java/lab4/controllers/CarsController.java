package lab4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lab4.dao.CarDAO;
import lab4.models.Car;

@Controller
@RequestMapping("/cars")
public class CarsController {

	private final CarDAO carDAO;
	
	@Autowired
	public CarsController(CarDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	@GetMapping("")
	public String cars(Model model) {
		model.addAttribute("cars", carDAO.index());
		return "cars/cars";
	}
	
	@GetMapping("/{car_id}")
	public String showCar(@PathVariable("car_id") int car_id, Model model) {
		model.addAttribute("car", carDAO.show(car_id));
		return "cars/showCar";
	}
	
	@GetMapping("/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		return "cars/newCar";
	}
	
	@GetMapping("/{car_id}/edit")
	public String editCar(Model model, @PathVariable("car_id") int car_id) {
		model.addAttribute("car", carDAO.show(car_id));
		return "cars/editCar";
	}
	
	@PostMapping()
	public String create(@ModelAttribute("car")  Car car,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "cars/newCar";
		}
		
		carDAO.save(car);
		return "redirect:/cars";
	}
	
	@PatchMapping("/{car_id}")
	public String update(@ModelAttribute("car")  Car car, 
			BindingResult bindingResult, @PathVariable("car_id") int car_id) {
		if (bindingResult.hasErrors()) {
			return "cars/editCar";
		}
		
		carDAO.update(car_id, car);
		return "redirect:/cars";
	}
	
	@DeleteMapping("/{car_id}")
	public String delete(@PathVariable("car_id") int car_id) {
		carDAO.delete(car_id);
		return "redirect:/cars";
	}
}
