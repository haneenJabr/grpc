package usecase;

import com.progressoft.jpa.entities.DepartmentBean;

public interface DepartmentUseCase {

	public void add(DepartmentBean department);

	public void delete(String deptId);

	public DepartmentBean update(DepartmentBean department);

	public DepartmentBean get(String deptId);
}
