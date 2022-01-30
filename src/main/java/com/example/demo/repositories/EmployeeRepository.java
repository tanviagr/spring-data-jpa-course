package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeId(Integer employeeId);
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByEmployeeNameAndLeftJobFalse(String employeeName);

    //JPQL
//    from the entity Employee, pass the first param to the function in the where condition
//    ?1 and ?2 is binding by position. We can also bind parameters by name
    @Query("from Employee where id = ?1")
    public Employee getEmployeeById(Integer employeeId);

    @Query("SELECT e FROM Employee e WHERE e.employeeName LIKE %?1% ORDER BY e.salary ASC")
    public List<Employee> getEmployeeByName(String employeeName);

    @Query("SELECT e FROM Employee e WHERE e.employeeName LIKE %?1% AND e.leftJob is FALSE ORDER BY e.salary ASC")
    public List<Employee> getEmployeeByNameActive(String employeeName);

    @Query("SELECT e FROM Employee e WHERE e.employeeName LIKE %?1% AND e.leftJob is ?2 ORDER BY e.salary ASC")
    public List<Employee> getEmployeeByNameAndStatus(String employeeName, Boolean leftJob);

    @Query("SELECT e FROM Employee e WHERE e.department IS ?1 ORDER BY e.salary, e.employeeName")
    public List<Employee> getEmployeeByDept(String department);

    @Query("SELECT e FROM Employee e WHERE e.department IN ?1 ORDER BY e.salary, e.employeeName")
    public List<Employee> getEmployeeByDepts(List<String> department);

    @Query("SELECT e FROM Employee e WHERE e.salary > :baseSalary ORDER BY e.salary, e.employeeName")
    public List<Employee> getEmployeeBySalary(@Param("baseSalary") Float baseSalary);

    @Query("SELECT e FROM Employee e WHERE e.age BETWEEN :startAge AND :endAge")
    public List<Employee> getEmployeesBetweenAges(@Param("startAge") Integer startAge, @Param("endAge") Integer endAge);

//    if we only want to expose a subset of columns, we cannot do it by selecting
//    e.col1, e.col2 because the return type will still be Employee - which has some required fields.
//    we can either create a POJO class that has the fields we want to return or return Object class.
    @Query("SELECT e.employeeName, e.department FROM Employee e WHERE e.age BETWEEN :startAge AND :endAge")
    public List<Object> getEmployeesNamesDeptsBetweenAges(@Param("startAge") Integer startAge, @Param("endAge") Integer endAge);

//    drawback of JPQL - nested queries, multiple joins cannot be written in JPQL
//    when we use native queries they get executed directly against our DB table. Instead of querying the entity,
//    we wuery the table and that means that we can access all columns of the table without any restriction, which
//    is a drawback.

    @Query(value = "SELECT * FROM employees e WHERE e.age BETWEEN :startAge AND :endAge",
    nativeQuery = true)
    public List<Object> getEmployeesNamesDeptsBetweenAgesNative(@Param("startAge") Integer startAge,
                                                                @Param("endAge") Integer endAge);

    @Query(value = "select get_total_employees()", nativeQuery = true)
    public Integer NqGetTotalEmployees();

    @Procedure(procedureName = "get_total_employees")
    public Integer ProcGetTotalEmployees();

    @Query(value = "select proc_single_input(?1)", nativeQuery = true)
    public Integer NqGetAgeByEmpId(Integer empId);

    @Procedure(procedureName = "proc_single_input")
    public Integer ProcGetAgeByEmpId(Integer empId);

//    @Query(value = "select proc_multi_output(?1)", nativeQuery = true)
//    No Dialect mapping for JDBC type: 1111 - because this returns a record, we need a select * for separate cols
    @Query(value = "select * from proc_multi_output(?1)", nativeQuery = true)
    public Map<String, ?> NqGetAgeAndDept(Integer empId);
}
