package com.accolite.assignment.restapi;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao = EmployeeDAO.getInstance();
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> list() throws Exception{
		return ResponseEntity.ok(dao.listAll());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Employee> add(Employee employee) throws Exception {
		int newEmployeeId = dao.add(employee);
		URI uri = new URI("/emp/" + newEmployeeId);
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee>update(@RequestParam("id") int id, Employee employee) throws Exception{
		employee.setId(id);
		if (dao.update(employee)) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.ok(employee);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Integer>> delete(@RequestParam("id") int id)throws Exception {
		Map<String,Integer> mp = new HashMap();
		mp.put("Deleted", id);
		if (dao.delete(id)) {
			return ResponseEntity.ok(mp);					
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Employee> get(@RequestParam("id") int id) throws Exception {
		Employee employee = dao.get(id);
			return ResponseEntity.ok(employee);
	
	}
}
