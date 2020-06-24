package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ģʽ
 * �ֽв�������ģʽ�������ڰ�һ�����ƵĶ�����һ����һ�Ķ������ģʽ�������νṹ����϶���������ʾ�����Լ������Ρ��������͵����ģʽ���ڽṹ��ģʽ���������˶���������νṹ��
 * ����ģʽ������һ�������Լ���������ࡣ�����ṩ���޸���ͬ������ķ�ʽ��
 * ����ͨ�������ʵ������ʾ���ģʽ���÷���ʵ����ʾ��һ����֯��Ա���Ĳ�νṹ��
 *
 * ����
 * ��ͼ����������ϳ����νṹ�Ա�ʾ"����-����"�Ĳ�νṹ�����ģʽʹ���û��Ե����������϶����ʹ�þ���һ���ԡ�
 * ��Ҫ����������������ͽṹ�������У�ģ���˼�Ԫ�غ͸���Ԫ�صĸ���ͻ�������������Ԫ��һ����������Ԫ�أ��Ӷ�ʹ�ÿͻ������븴��Ԫ�ص��ڲ��ṹ���
 * ��ʱʹ�ã� 1�������ʾ����Ĳ���-�����νṹ�����νṹ���� 2����ϣ���û�������϶����뵥������Ĳ�ͬ���û���ͳһ��ʹ����Ͻṹ�е����ж���
 * ��ν������֦��Ҷ��ʵ��ͳһ�ӿڣ���֦�ڲ���ϸýӿڡ�
 *
 * �ؼ����룺��֦�ڲ���ϸýӿڣ����Һ����ڲ����� List������� Component��
 *
 * Ӧ��ʵ���� 1���������ʽ����������������������һ�������������У���һ��������Ҳ�����ǲ�����������������һ���������� 2���� JAVA AWT �� SWING �У����� Button �� Checkbox ����Ҷ��Container ����֦��
 * �ŵ㣺 1���߲�ģ����ü򵥡� 2���ڵ��������ӡ�
 * ȱ�㣺��ʹ�����ģʽʱ����Ҷ�Ӻ���֦����������ʵ���࣬�����ǽӿڣ�Υ������������ԭ��
 *
 * ʹ�ó��������֡����峡���������β˵����ļ����ļ��еĹ���
 *
 * ע���������ʱΪ�����ࡣ
 */
public class CompositePattern {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //��ӡ����֯������Ա��
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    //���캯��
    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }
}
