package com.mdsolutions.coding.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JDK8Features {

	public static void main(String[] args) {
		List<Employee> employeeList = getEmployeeList();
		
		findMaleAndFemaleEmplpyees(employeeList);
		findNamesOfAllDepartments(employeeList);
		findHighestPaidEmployee(employeeList);
		findHighestPaidByEmployeeInDept(employeeList);
		findAllEmployeesJoinedAfter2015(employeeList);
		findTheNumberOfEmployeesInEachDept(employeeList);
		findAvgSalaryOfEachDept(employeeList);
		seperateEmployeesByAgeOrPartitionByAge(employeeList);
	}

	private static void seperateEmployeesByAgeOrPartitionByAge(List<Employee> employeeList) {
		System.out.println("=======seperateEmployeesByAgeOrPartitionByAge==========");
		employeeList.stream().collect(Collectors.partitioningBy( emp -> emp.getAge() >25))
		.forEach((isAgeLessThan25, emp) -> {
			if(isAgeLessThan25) {
				System.out.println("Employees with age lessthan 25");
			}else {
				System.out.println("Employees with age greaterThan 25");
			}
			System.out.println(emp.size());
			System.out.println(emp);
		});
		System.out.println("=======seperateEmployeesByAgeOrPartitionByAge==========");
	}

	private static void findAvgSalaryOfEachDept(List<Employee> employeeList) {
		System.out.println("=======findAvgSalaryOfEachDept==========");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)) ).forEach((dept, avgSal) -> System.out.println(dept+"::"+avgSal));
		System.out.println("=======findAvgSalaryOfEachDept==========");

	}

	private static void findTheNumberOfEmployeesInEachDept(List<Employee> employeeList) {
		System.out.println("=======findTheNumberOfEmployeesInEachDept==========");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((dept, count) -> System.out.println(dept+"::"+count));
		System.out.println("=======findTheNumberOfEmployeesInEachDept==========");
	}

	private static void findAllEmployeesJoinedAfter2015(List<Employee> employeeList) {
		System.out.println("=======findAllEmployeesJoinedAfter2015==========");
		employeeList.stream().filter( (emp) -> emp.getYearOfJoining()>2015).map(Employee::getName). forEach( e->System.out.println(e));
		System.out.println("=======findAllEmployeesJoinedAfter2015==========");
	}

	private static void findHighestPaidByEmployeeInDept(List<Employee> employeeList) {
		System.out.println("=======findHighestPaidByEmployeeInDept==========");
		Map<String, Optional<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))) ) ;
		map.forEach((m, empMap) -> {
			System.out.println(m+"---->"+empMap.orElse(new Employee()));
		});
		System.out.println("=======findHighestPaidByEmployeeInDept==========");
	}

	private static void findHighestPaidEmployee(List<Employee> employeeList) {
		System.out.println("=======findHighestPaidEmployee==========");
		Optional<Employee> optionalEmployee = employeeList.stream().collect( Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		Employee emp = optionalEmployee.get();
		System.out.println(emp);
		System.out.println("=======findHighestPaidEmployee==========");
	}

	private static void findNamesOfAllDepartments(List<Employee> employeeList) {
		System.out.println("=======findNamesOfAllDepartments==========");
//		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((deptName, employeeList) -> System.out.println(deptName));
		employeeList.stream().map(Employee::getDepartment).distinct().sorted((o1, o2) -> o2.compareTo(o1 ) ) .forEach((deptName) -> System.out.println(deptName));
		System.out.println("=======findNamesOfAllDepartments==========");
	}

	private static void findMaleAndFemaleEmplpyees(List<Employee> employeeList) {
		System.out.println("=======findMaleAndFemaleEmplpyees==========");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
		.forEach((gender, count) -> System.out.println(gender+":"+count));
		System.out.println("=======findMaleAndFemaleEmplpyees==========");
	}

	private static List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		return employeeList;
	}

}
