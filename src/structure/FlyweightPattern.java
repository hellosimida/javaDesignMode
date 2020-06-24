package structure;

import java.util.HashMap;

/**
 * ��Ԫģʽ
 * ��Ԫģʽ��Flyweight Pattern����Ҫ���ڼ��ٴ���������������Լ����ڴ�ռ�ú�������ܡ��������͵����ģʽ���ڽṹ��ģʽ�����ṩ�˼��ٶ��������Ӷ�����Ӧ������Ķ���ṹ�ķ�ʽ��
 * ��Ԫģʽ�����������е�ͬ��������δ�ҵ�ƥ��Ķ����򴴽��¶������ǽ�ͨ������ 5 ������������ 20 ���ֲ��ڲ�ͬλ�õ�Բ����ʾ����ģʽ������ֻ�� 5 �ֿ��õ���ɫ������ color ���Ա�����������е� Circle ����
 *
 * ����
 * ��ͼ�����ù�������Ч��֧�ִ���ϸ���ȵĶ���
 * ��Ҫ��������д�������ʱ���п��ܻ�����ڴ���������ǰ����й�ͬ�Ĳ��ֳ���������������ͬ��ҵ������ֱ�ӷ������ڴ������еĶ��󣬱������´�����
 * ��ʱʹ�ã� 1��ϵͳ���д������� 2����Щ�������Ĵ����ڴ档 3����Щ�����״̬�󲿷ֿ����ⲿ���� 4����Щ������԰�������״̬��Ϊ�ܶ��飬�������̶���Ӷ������޳�����ʱ��ÿһ����󶼿�����һ�����������档 5��ϵͳ����������Щ������ݣ���Щ�����ǲ��ɷֱ�ġ�
 * ��ν������Ψһ��ʶ���жϣ�������ڴ����У��򷵻����Ψһ��ʶ������ʶ�Ķ���
 * �ؼ����룺�� HashMap �洢��Щ����
 *
 * Ӧ��ʵ���� 1��JAVA �е� String��������򷵻أ����û���򴴽�һ���ַ����������ַ�����������档 2�����ݿ�����ݳء�
 *
 * �ŵ㣺�����ٶ���Ĵ���������ϵͳ���ڴ棬ʹЧ����ߡ�
 * ȱ�㣺�����ϵͳ�ĸ��Ӷȣ���Ҫ������ⲿ״̬���ڲ�״̬�������ⲿ״̬���й��л������ʣ���Ӧ�������ڲ�״̬�ı仯���仯����������ϵͳ�Ļ��ҡ�
 *
 * ʹ�ó����� 1��ϵͳ�д������ƶ��� 2����Ҫ����صĳ�����
 *
 * ע����� 1��ע�⻮���ⲿ״̬���ڲ�״̬��������ܻ������̰߳�ȫ���⡣ 2����Щ�������һ������������Կ��ơ�
 */
public class FlyweightPattern {
    private static final String colors[] =
            { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            Circle1 circle =
                    (Circle1)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}

interface Shape1 {
    void draw();
}

class Circle1 implements Shape1 {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle1(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape1> circleMap = new HashMap<>();

    public static Shape1 getCircle(String color) {
        Circle1 circle = (Circle1)circleMap.get(color);

        if(circle == null) {
            circle = new Circle1(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}


