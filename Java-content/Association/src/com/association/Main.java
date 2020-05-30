package com.association;
// Java program to illustrate the
// concept of Association


// class bank
class Bank
{
    private String name;

    // bank name
    Bank(String name)
    {
        this.name = name;
    }

    public String getBankName()
    {
        return this.name;
    }
}

// employee class
class Employee
{
    private String name;

    // employee name
    Employee(String name)
    {
        this.name = name;
    }

    public String getEmployeeName()
    {
        return this.name;
    }
}

// Association between both the
// classes in main method

public class Main
{
    public static void main (String[] args)
    {
        Bank bank = new Bank("HNB");
        Employee emp = new Employee("Nazhim");

        System.out.println(emp.getEmployeeName() +
                " is employee of " + bank.getBankName());
    }
}
