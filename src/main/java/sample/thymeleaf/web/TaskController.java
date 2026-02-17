package sample.thymeleaf.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import sample.common.dao.entity.Task;
import sample.common.service.TaskService;

@Controller
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/tasks")
	public String tasks(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null)return "redirect:/login";
		
		List<Task> tasks = taskService.findByUsername(loginUser);
		model.addAttribute("tasks",tasks);
		
		return "tasks/list";
	}
	
	@GetMapping("/tasks/new")
	public String newTask(Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:/login";
		
		model.addAttribute("task", new Task());
		return "tasks/form-new";
	}
	
	@PostMapping("/tasks")
	public String create(@ModelAttribute Task task, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:/login";
		
		task.setUsername(loginUser);
		
		taskService.create(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/edit/{id}")
	public String edit(@PathVariable Long id, Model model, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:/login";
		
		Task task =taskService.findById(id);
		model.addAttribute("task",task);
		
		return "tasks/form-edit";
	}
	
	@PostMapping("/tasks/update/{id}")
	public String update(@PathVariable Long id,@ModelAttribute Task task, HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:/login";
		
		task.setId(id);
		task.setUsername(loginUser);
		
		taskService.update(task);
		return "redirect:/tasks";
	}
	
	@PostMapping("/tasks/delete/{id}")
	public String delete(@PathVariable Long id,HttpSession session) {
		String loginUser = (String)session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:/login";
		
		taskService.delete(id);
		return "redirect:/tasks";
	}
}
