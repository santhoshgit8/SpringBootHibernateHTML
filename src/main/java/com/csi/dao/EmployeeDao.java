package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllData();

	public void saveData(Employee employee);

	public void updateData(Employee employee);

	public void deleteDataById(int empId);

	public Employee getDataById(int empId);
}
