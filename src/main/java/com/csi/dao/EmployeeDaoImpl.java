package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public List<Employee> getAllData() {
		Session session = factory.openSession();
		List<Employee> elist = session.createQuery("from Employee").list();
		return elist;
	}

	@Override
	public void saveData(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
	}

	@Override
	public void updateData(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> elist = session.createQuery("from Employee").list();
		for (Employee e : elist) {
			if (e.getEmpId() == employee.getEmpId()) {
				e.setEmpName(employee.getEmpName());
				e.setEmpSalary(employee.getEmpSalary());
				session.update(e);
				transaction.commit();
			}
		}
	}

	@Override
	public void deleteDataById(int empId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> elist = session.createQuery("from Employee").list();
		Employee employee = new Employee();
		for (Employee e : elist) {
			if (e.getEmpId() == empId) {
				session.delete(e);
				transaction.commit();
			}
		}
	}

	@Override
	public Employee getDataById(int empId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> elist = session.createQuery("from Employee").list();
		Employee employee = new Employee();
		for (Employee e : elist) {
			if (e.getEmpId() == empId) {
				employee.setEmpId(e.getEmpId());
				employee.setEmpName(e.getEmpName());
				employee.setEmpSalary(e.getEmpSalary());
			}
		}
		return employee;
	}
}
