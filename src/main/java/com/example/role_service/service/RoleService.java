package com.example.role_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.role_service.repository.RoleRepository;
import com.example.role_service.repository.entity.RoleEntity;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<RoleEntity> getAllRoles(){
		return roleRepository.findAll();
	}
	
	public Optional<RoleEntity> findRoleByName(String roleName){
		return roleRepository.findByRoleName(roleName);
	}
	
	public List<String> getAllRoleNames(){
		return roleRepository.findAll()
                .stream()
                .map(RoleEntity::getRoleName)
                .collect(Collectors.toList());
	}
	
	public void deleteRoleById(int roleId) {
        roleRepository.deleteById(roleId);
    }

}
