package com.kevinchan;

import java.util.List;

public interface EmployeeDao {
    /**
     * 添加员工
     * insert into employee values(?,?,?,?);
     */
    public boolean save(Employee employee);

    /**
     * 修改某个员工
     * update employee set name=?,department=? where eid=?
     */
    public boolean update(Employee employee);

    /**
     * 删除某个员工
     * delete from employee where eid=?
     */

    /**
     * 根据员工编号查询某个员工
     * select * from employee where eid=?
     */
    public Employee getQueryById(int eid);

    /**
     * 查询所有员工
     * select * from employee
     */
    public List<Employee> queryAll();

}
