package repository;

import java.util.List;

import com.progressoft.jpa.entities.Department;

public interface DepartmentRepository {

	public void add(Department department);

	public void delete(String deptId);

	public Department update(Department department);

	public Department get(String deptId);
	
	public List<Department> listAllDepartments();
}
