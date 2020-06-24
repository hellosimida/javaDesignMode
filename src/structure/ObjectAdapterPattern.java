package structure;

/**
 * ������ģʽ֮����������
 */
public class ObjectAdapterPattern {
    public static void main(String[] args) {
        Client client = new Client(new Adapter());
        client.doThings();
    }

}

/**
 * ����Ŀ���ࣨITarget����������ĳЩ����ԭ��Client���޷�ֱ�ӵ��øýӿ��Լ�����������ķ���
 */
interface ITarget {
    void dealThings();
}

/**
 * ����Ŀ���ࣨConcreteTarget����������ĳЩ����ԭ��Client���޷�ֱ�ӵ��ø���
 */
class ConcreteTarget implements ITarget{

    @Override
    public void dealThings() {
        System.out.println("deal real things");
    }
}

/**
 * ������������(IAdapter)Client����Է��ʺ͵��õĽӿ�
 */
interface IAdapter{
    public void doSomethings();
}

/**
 * ������������(Adapter)ͨ����ϵķ�ʽAdapter����һ��ITarget����
 */
class Adapter implements IAdapter{
    private ITarget target;

    public Adapter(){
        this.target = new ConcreteTarget();
    }

    @Override
    public void doSomethings() {
        System.out.println("I am an adapter");
        this.target.dealThings();
    }
}

/**
 * ������������ԭ��ֻ�ܷ���IAdapter��������ķ�����
 */
class Client{
    IAdapter adapter;

    public Client(IAdapter adapter){
        this.adapter = adapter;
    }

    public void doThings(){
        adapter.doSomethings();
    }
}


