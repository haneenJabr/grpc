package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.progressoft.jpa.entities.Department;

public class DepartmentRepositoryImpl implements DepartmentRepository {
	private EntityManager entityManager = EntityManagerProvider.getInstance();
	
	public DepartmentRepositoryImpl() {

	}

	public void add(Department department) {
		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();
	}

	public void delete(String deptId) {
		
		entityManager.getTransaction().begin();
		entityManager.remove(get(deptId));
		entityManager.getTransaction().commit();
	}

	public Department get(String deptId) {
	
		Department department = entityManager.find(Department.class, deptId);
	
		return department;
	}

	public Department update(Department department) {
		entityManager.getTransaction().begin();
		Department savedDepartment = entityManager.merge(department);
		entityManager.getTransaction().commit();
		return savedDepartment;
	}

	public List<Department> listAllDepartments() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select obj from Department obj");
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

}
