package lab4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lab4.dao.WorkerDAO;
import lab4.models.Worker;


@Controller
@RequestMapping("/workers")
public class WorkersController {

private final WorkerDAO workerDAO;
	
	@Autowired
	public WorkersController(WorkerDAO workerDAO) {
		this.workerDAO = workerDAO;
	}
	
	
	@GetMapping("")
	public String workers(Model model) {
		model.addAttribute("workers", workerDAO.index());
		return "workers/workers";
	}
	
	@GetMapping("/{id}")
	public String showWorker(@PathVariable("id") int id, Model model) {
		model.addAttribute("worker", workerDAO.show(id));
		return "workers/showWorker";
	}
	
	@GetMapping("/new")
	public String newWorker(Model model) {
		model.addAttribute("worker", new Worker());
		return "workers/newWorker";
	}
	
	@GetMapping("/{id}/edit")
	public String editWorker(Model model, @PathVariable("id") int id) {
		model.addAttribute("worker", workerDAO.show(id));
		return "workers/editWorker";
	}
	
	@PostMapping()
	public String create(@ModelAttribute("worker")  Worker worker,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "workers/newWorker";
		}
		
		workerDAO.save(worker);
		return "redirect:/workers";
	}
	
	@PatchMapping("/{id}")
	public String update(@ModelAttribute("worker")  Worker worker, 
			BindingResult bindingResult, @PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return "workers/editWorker";
		}
		
		workerDAO.update(id, worker);
		return "redirect:/workers";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		workerDAO.delete(id);
		return "redirect:/workers";
	}
}
