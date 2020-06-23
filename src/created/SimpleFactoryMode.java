package created;

public class SimpleFactoryMode {
    public abstract class Computer {
        /**
         * ��Ʒ�ĳ��󷽷����ɾ���Ĳ�Ʒ��ȥʵ��
         */
        public abstract void start();
    }

    public class LenovoComputer extends Computer {
        @Override
        public void start() {
            System.out.println("�����������");
        }
    }

    public class HpComputer extends Computer{
        @Override
        public void start() {
            System.out.println("���յ�������");
        }
    }

    public class AsusComputer extends Computer {
        @Override
        public void start() {
            System.out.println("��˶��������");
        }
    }

    public class ComputerFactory {
        public Computer createComputer(String type){
            Computer mComputer=null;
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

    public static void main(String[]args){
        SimpleFactoryMode simpleFactoryMode = new SimpleFactoryMode();
        ComputerFactory computerFactory = simpleFactoryMode.new ComputerFactory();
        computerFactory.createComputer("hp").start();
    }
}
