package created;

/**
 * ���󹤳�ģʽ
 * ���󹤳����������Զ��׼��ģ���������Ҫ�Ӹ���ʾ��������Ҫ�޸����еĹ����������еĹ���������������ʾ���ķ��������е�Υ���˶��޸Ĺرգ�����չ����������ԭ��
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // ��һ����Ҫѡ��һ�����󳧡�
        ComputerFactory1 cf = new AmdFactory();
        // ��������� CPU
        CPU cpu = cf.makeCPU();
        // �������������
        MainBoard board = cf.makeMainBoard();
        // ���������Ӳ��
        HardDisk hardDisk = cf.makeHardDisk();

        // ��ͬһ�����ӳ����� CPU�����塢Ӳ����װ��һ��
        Computer2 result = new Computer2(cpu, board, hardDisk);
    }
}
abstract class ComputerFactory1 {
    /**
     * ����cpu
     */
    public abstract CPU makeCPU();

    /**
     * ��������
     */
    public abstract MainBoard makeMainBoard();
    /**
     * ����Ӳ��
     */
    public abstract HardDisk makeHardDisk();
}

class AmdFactory extends ComputerFactory1{

    @Override
    public CPU makeCPU() {
        CPU cpu = new CPU();
        cpu.setBrand("amdCPU");
        System.out.println("amd����CPU");
        return cpu;
    }

    @Override
    public MainBoard makeMainBoard() {
        MainBoard mainBoard = new MainBoard();
        mainBoard.setBrand("amd����");
        System.out.println("amd��������");
        return mainBoard;
    }

    @Override
    public HardDisk makeHardDisk() {
        HardDisk hardDisk = new HardDisk();
        hardDisk.setBrand("amdӲ��");
        System.out.println("amd����Ӳ��");
        return hardDisk;
    }
}

class IntelFactory extends ComputerFactory1{

    @Override
    public CPU makeCPU() {
        CPU cpu = new CPU();
        cpu.setBrand("intelCPU");
        System.out.println("intel����CPU");
        return cpu;
    }

    @Override
    public MainBoard makeMainBoard() {
        MainBoard mainBoard = new MainBoard();
        mainBoard.setBrand("intel����");
        System.out.println("intel��������");
        return mainBoard;
    }

    @Override
    public HardDisk makeHardDisk() {
        HardDisk hardDisk = new HardDisk();
        hardDisk.setBrand("intelӲ��");
        System.out.println("intel����Ӳ��");
        return hardDisk;
    }
}

class Computer2{
    public Computer2(CPU cpu, MainBoard board, HardDisk hardDisk) {
        System.out.println("������װcpu:"+cpu.getBrand()+",���壺"+board.getBrand()+",Ӳ�̣�"+hardDisk.getBrand());
    }
}

class CPU{
    /**
     * Ʒ��
     */
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

class MainBoard{
    /**
     * Ʒ��
     */
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
class HardDisk{
    /**
     * Ʒ��
     */
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
