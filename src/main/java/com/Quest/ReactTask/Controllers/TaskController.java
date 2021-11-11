package com.Quest.ReactTask.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Quest.ReactTask.Entity.TaskEntity;
import com.Quest.ReactTask.Services.TaskServices;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TaskController {

	@Autowired
	TaskServices ts;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String display() {
		return "Welcome";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public TaskEntity savetask(@RequestBody TaskEntity t) {
		ts.saveall(t); 
		return t;
	}
	
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public List<TaskEntity> getalltasks(){
		return ts.getall();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteid(@PathVariable("id") int id) {
		ts.deletebyid(id);
		return "success";
	}
	@RequestMapping(value = "update/{id}/{tstatus}", method = RequestMethod.POST)
	public void update(@PathVariable("id") int id, @PathVariable("tstatus") String tstatus) {
		ts.saveupdated(id, tstatus); 
		
	}
	
}
