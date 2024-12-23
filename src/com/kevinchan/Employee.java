package com.foreknow.test;

public class Employee {
    private Integer eid;
    private String name;
    private Double salary;
    private String department;

    public Employee() {

    }

    public Employee(Integer eid, String name, Double salary, String department) {
        this.eid = eid;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void main(String[] args) {
        //创建一个员工类型的数组
        Employee[] array = new Employee[2];
        Employee e1 = new Employee();
        e1.setEid(100);
        e1.setName("fender");
        Employee e2 = new Employee();
        e2.setEid(101);
        e2.setName("gibson");

        //向数组中添加对象
        array[0] = e1;
        array[1] = e2;

        //获取数组中所有员工
        for (Employee employee:array) {
            System.out.println(employee.getEid() + "---" + employee.getName());
        }



    }
}
