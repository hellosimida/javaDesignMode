package created;

/**
 * ����ģʽ
 * �򵥹���ģʽ�ܼ򵥣���������������ǵ���Ҫ���Ҿ��þͲ�Ҫ�����ˡ�֮������Ҫ���빤��ģʽ������Ϊ����������Ҫʹ���������������ϵĹ�����
 * ��Ȼ���ǵ��� createComputer("hp") �������յ��ԣ����ǣ���ͬ�Ĺ���������������ȫ��һ����
 * ��һ����������Ҫѡȡ���ʵĹ�����Ȼ��ڶ��������Ϻͼ򵥹���һ����
 * �������ڣ�������Ҫ�ڵ�һ��ѡ��������Ҫ�Ĺ��������磬������ LogFactory �ӿڣ�ʵ������ FileLogFactory �� KafkaLogFactory���ֱ��Ӧ����־д���ļ���д�� Kafka �У�
 * ��Ȼ�����ǿͻ��˵�һ������Ҫ��������Ҫʵ���� FileLogFactory ���� KafkaLogFactory���⽫����֮������еĲ�����
 */
public class FactoryMode {
    public static void main(String[]args){
        ChineseComputerFactory computerFactory = new ChineseComputerFactory();
        computerFactory.createComputer("hp").start();
    }
}

abstract class Computer {
    /**
     * ��Ʒ�ĳ��󷽷����ɾ���Ĳ�Ʒ��ȥʵ��
     */
    public abstract void start();
}

class AmericanLenovoComputer extends Computer {
    @Override
    public void start() {
        System.out.println("American�����������");
    }
}

class AmericanHpComputer extends Computer{
    @Override
    public void start() {
        System.out.println("American���յ�������");
    }
}

class AmericanAsusComputer extends Computer {
    @Override
    public void start() {
        System.out.println("American��˶��������");
    }
}

class ChineseLenovoComputer extends Computer {
    @Override
    public void start() {
        System.out.println("Chinese�����������");
    }
}

class ChineseHpComputer extends Computer{
    @Override
    public void start() {
        System.out.println("Chinese���յ�������");
    }
}

class ChineseAsusComputer extends Computer {
    @Override
    public void start() {
        System.out.println("Chinese��˶��������");
    }
}

class AmericanComputerFactory {
    public Computer createComputer(String type){
        Computer mComputer=null;
        switch (type) {
            case "lenovo":
                mComputer=new AmericanLenovoComputer();
                break;
            case "hp":
                mComputer=new AmericanHpComputer();
                break;
            case "asus":
                mComputer=new AmericanAsusComputer();
                break;

        }
        return mComputer;
    }
}

class ChineseComputerFactory {
    public Computer createComputer(String type){
        Computer mComputer=null;
        switch (type) {
            case "lenovo":
                mComputer=new ChineseLenovoComputer();
                break;
            case "hp":
                mComputer=new ChineseHpComputer();
                break;
            case "asus":
                mComputer=new ChineseAsusComputer();
                break;

        }
        return mComputer;
    }
}
