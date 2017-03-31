package repository;

import com.progressoft.jpa.entities.Department;

public class Main {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepositoryImpl();
		Department dept1 = new Department();
		dept1.setDeptNo("d10");
		dept1.setName("inv");
//		repository.update(dept1);
		repository.delete("998");
	}
}
