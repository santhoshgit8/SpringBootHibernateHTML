package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@Service
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	EmployeeDao employeeDaoImpl;

	@Override
	public List<Employee> getAllData() {
		return employeeDaoImpl.getAllData();
	}

	@Override
	public void saveData(Employee employee) {
		employeeDaoImpl.saveData(employee);
	}

	@Override
	public void updateData(Employee employee) {
		employeeDaoImpl.updateData(employee);
	}

	@Override
	public void deleteDataById(int empId) {
		employeeDaoImpl.deleteDataById(empId);
	}

	@Override
	public Employee getDataById(int empId) {
		return employeeDaoImpl.getDataById(empId);
	}
}
