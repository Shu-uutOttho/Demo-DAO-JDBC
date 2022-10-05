package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();		
		
		System.out.println("=== Test 1: Department findById ====");
		Department departmnent = departmentDao.findById(3);
		System.out.println(departmnent);
		
		System.out.println("\n=== Test 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d  : list) {
			System.out.println(d);
			}
		System.out.println("\n=== Test 3: Department insert ====");
		Department newDepartment= new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("New Department inserted: "+ newDepartment.getId());
		
		
		System.out.println("\n=== Test 4: Department update ====");
		Department department2 = departmentDao.findById(1);
		department2.setName("Food");
		departmentDao.update(department2);
		System.out.println("Update completed");
		
		
		System.out.println("\n=== Test 5: Department Delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
