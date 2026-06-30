package clg.dkte;
import java.util.*;

class Employee
{
	protected int empid;
	protected String empName;
	protected double salary;
	
	public Employee()
	{
		
	}
	public void calculate() {
		// TODO Auto-generated method stub
		
	}
	Scanner sc = new Scanner(System.in);
	public Employee(int empid, String empName, double salary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void acceptRecord()
	{
		System.out.println("Enter Employee id:");
		empid = sc.nextInt();
		System.out.println("Enter Employee Name:");
		empName = sc.next();
		System.out.println("Enter a salary:");
		salary = sc.nextDouble();
		//System.out.println("-----------------------------------------------------");
	}
	public void displayRecord()
	{
		System.out.println("Employee id:"+empid);
		System.out.println("Employee Name:"+empName);
		System.out.println("Employee Salary:"+salary);
		//System.out.println("-----------------------------------------------------");
	}
	
}
class Manager extends Employee
{
	private double bonus;

	
   public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int empid, String empName, double salary) {
		super(empid, empName, salary);
		// TODO Auto-generated constructor stub
	}
   public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void acceptRecord()
	{
		super.acceptRecord();
		System.out.println("Enter a Bonus:");
		bonus = sc.nextDouble();
        System.out.println("--------------------------------------------------");
	}
	@Override
	public void calculate()
	{
		double m_salary = salary + bonus;
		System.out.println("Manager Salary:"+m_salary);
		
	}
	public void displayRecord() 
	{
		super.displayRecord();
		System.out.println("Bonus:"+bonus);
        System.out.println("--------------------------------------------------");

	}
}
class Developer extends Employee
{
	private int overTimeHours;
	
	public Developer() {
		super();
		this.overTimeHours = overTimeHours;
	}

	public int getOverTimeHours() {
		return overTimeHours;
	}

	public void setOverTimeHours(int overTimeHours) {
		this.overTimeHours = overTimeHours;
	}
	
	public void acceptRecord()
	{
		super.acceptRecord();
		System.out.println("Enter a Hours:");
		overTimeHours = sc.nextInt();
		System.out.println("-----------------------------------------------------");

	}
	public void calculate()
	{
		double d_salary = salary + (overTimeHours * 500);
		System.out.println("Developer Salary:" +d_salary);
	}
	public void displayRecord()
	{
		super.displayRecord();
		System.out.println("Hours:"+overTimeHours);
		System.out.println("-----------------------------------------------------");

	}
	
}
public class Program {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public static int menuList()
	{
		int ch;
		System.out.println("0.Exit");
		System.out.println("1.Add Manager");
		System.out.println("2.Add Developer");
		System.out.println("3.Display All Employees");
		System.out.println("4.Search Employee by salary");
		System.out.println("5.Calculate Salary");
		System.out.println("6.Delete Employee");
		
		System.out.println("Enter a choice:");
		ch = sc.nextInt();
		return ch;


	}
	public static void main(String[] args)
	{
		int ch;
		
		Employee[] emp = new Employee[2];
		int count = 0;
		while((ch = menuList()) != 0)
		{
			switch(ch)
			{
			case 1:
				if(count < emp.length)
				{
					emp[count] = new Manager();
					emp[count].acceptRecord();
					count++;
				}
				else {
					System.out.println("Array id full");
				}
				break;
				
			case 2:
				if(count < emp.length)
				{
					emp[count] = new Developer();
					emp[count].acceptRecord();
					count++;
				}
				break;
				
			case 3:
				 if (count == 0) {
	                    System.out.println("No Employees Found.");
	                } else {
	                    for (int i = 0; i < count; i++) {    //count
	                        emp[i].displayRecord();
	                        System.out.println("--------------------------");
	                    }
	                }
	                break;
				
				
			case 4:
				System.out.println("Enter a Employee id:");
				int key = sc.nextInt();
				
				boolean found = false;
				
				for(int i = 0; i < emp.length; i++)
				{
					if(emp[i] != null && emp[i].getEmpid() == key)
					{
						emp[i].displayRecord();
						found = true;
						break;
					}	
				}
				if(!found)
				{
					System.out.println("Employee not found..!!!");
				}
				break;
				
			case 5:				
				if(count == 0) {
					System.out.println("No employee available");
				}else
				{
					for(int i = 0; i < count; i++)
					{
						emp[i].calculate();
					}
				}
				break;
			case 6:
			    System.out.println("Enter Employee ID to Delete:");
			    int deleteId = sc.nextInt();

			    boolean deleted = false;

			   for(int i = 0; i < count; i++)
			   {
				   if(emp[i] != null && emp[i].getEmpid() == deleteId)
				   {
					   for(int j = i; j < count - 1; j++)
					   {
						   emp[j] = emp[j + 1];
					   }
					   emp[count - 1] = null;
					   count--;
					   
					   deleted = true;
					   System.out.println("Employee Deleted Succssfully..!!");
				   }
			   }
			   if(!deleted)
				   System.out.println("Employee not found!!");
			   break;

				   
			default:
				System.out.println("Invalid Choice...!!");
				continue;
				
			}
		}
	}

}
