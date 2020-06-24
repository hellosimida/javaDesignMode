package created;

/**
 * �򵥹���ģʽ
 * �򵥵�˵���򵥹���ģʽͨ������������һ�������� XxxFactory��������һ����̬�������������ǲ�ͬ�Ĳ��������ز�ͬ��������ͬһ�����ࣨ��ʵ��ͬһ�ӿڣ���ʵ������
 * ����ǿ��ְ��һԭ��һ����ֻ�ṩһ�ֹ��ܣ�FoodFactory �Ĺ��ܾ���ֻҪ������������ Food��
 */
public class SimpleFactoryPattern {
    public static void main(String[]args){
        ComputerFactory computerFactory =  new ComputerFactory();
        computerFactory.createComputer("hp").start();
    }

}

abstract class Computer1 {
    /**
     * ��Ʒ�ĳ��󷽷����ɾ���Ĳ�Ʒ��ȥʵ��
     */
    public abstract void start();
}

class LenovoComputer extends Computer1 {
    @Override
    public void start() {
        System.out.println("�����������");
    }
}

class HpComputer extends Computer1{
    @Override
    public void start() {
        System.out.println("���յ�������");
    }
}

class AsusComputer extends Computer1 {
    @Override
    public void start() {
        System.out.println("��˶��������");
    }
}

class ComputerFactory {
    public Computer1 createComputer(String type){
        Computer1 mComputer=null;
        switch (type) {
            case "lenovo":
                mComputer=new LenovoComputer();
                break;
            case "hp":
                mComputer=new HpComputer();
                break;
            case "asus":
                mComputer=new AsusComputer();
                break;

        }
        return mComputer;
    }
}
