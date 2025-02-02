package com.example.role_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.role_service.repository.entity.RoleEntity;
import com.example.role_service.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<List<RoleEntity>> getAllRoles(){
		return new ResponseEntity<List<RoleEntity>>(roleService.getAllRoles(),HttpStatus.OK);
	}
	
	@GetMapping("/{roleName}")
	public ResponseEntity<Optional<RoleEntity>> getRoleByName(@PathVariable String roleName){
		return new ResponseEntity<Optional<RoleEntity>>(roleService.findRoleByName(roleName),HttpStatus.OK);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<String>> getAllRoleNames(){
		return new ResponseEntity<List<String>>(roleService.getAllRoleNames(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{rId}")
	public ResponseEntity<Void> deleteRoleById(@PathVariable int rId){
		roleService.deleteRoleById(rId);
		return new ResponseEntity(HttpStatus.OK);
	}

}
