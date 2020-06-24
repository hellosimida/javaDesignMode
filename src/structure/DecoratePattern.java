package structure;

/**
 * װ��ģʽ
 * 1. ��ʱʹ��
 * �ڲ������Ӻܶ�������������չ��ʱ
 * 2. ����
 * �����幦��ְ�𻮷֣�ͬʱ�̳�װ����ģʽ
 * 3. �ŵ�
 * װ����ͱ�װ������Զ�����չ���������໥��ϡ�����Ч�ذ���ĺ���ְ���װ�ι��ֿܷ���
 * װ��ģʽ�Ǽ̳й�ϵ��һ���������
 * װ��ģʽ���Զ�̬����չһ��ʵ����Ĺ���
 * 4. ȱ��
 * ���װ�αȽϸ��ӡ��������������кܶ��װ�Σ��������⣬һ��һ���飬�������������װ�γ������ˣ����빤����������
 * 5. ʹ�ó���
 * ��Ҫ��չһ����Ĺ���ʱ
 * ��Ҫ��̬�ظ�һ���������ӹ��ܣ������Զ�̬�س���ʱ
 * ��ҪΪһ�����ֵ�����и�װ���װ����ʱ
 *
 *
 * ƽ����ϵͳ��Ҫ�¹���ʱ������ɵ���������µĴ��룬��Щ�¼ӵĴ���ͨ��װ����ԭ����ĺ���ְ�����Ҫ��Ϊ�������������������ڣ������������м������µ��ֶΡ��µķ������µ��߼����Ӷ�����������ĸ��Ӷȣ�����Щ�¼���Ķ���������Ϊ������һЩֻ��ĳ���ض�����²Ż�ִ�еĸ�������Ϊ����Ҫ��
 * ��װ��ģʽȴ�ṩ��һ���ǳ��õĽ������������ÿ��Ҫװ�εĹ��ܷ��ڵ��������У�����������װ����Ҫװ�εĶ�����˵���Ҫִ��������Ϊʱ���ͻ�����Ϳ���������ʱ������Ҫ��ѡ��ء���˳��ĵ�ʹ��װ�ι��ܰ�װ�����ˡ�
 *
 *
 * JAVA IO���ǵ��͵�װ��ģʽ
 * InputStream������ԭʼ�Ķ���
 * ByteArrayInputStream��FileInputStream��PipedInputStream���Ǽ̳���InputStream�������������������
 * FilterInputStream�̳���InputStream,��װ��ģʽ�Ĺؼ��ڵ㣬��ʵ������һϵ��װ����
 * BufferedInputStream�̳���FilterInputStream�������û�����װ�Σ�Ҳ��ʹ�������������˻���Ĺ��ܣ�
 * LineNumberInputStream�̳���FilterInputStream���������к���װ�Σ��ڲ�����ʱ��Ϳ���ȡ���к��ˣ�
 * DataInputStream�̳���FilterInputStream��ʹ�����ǿ��Դ�������ת��Ϊ java �еĻ�������ֵ��
 * ��ȡ�кž�ͨ��һ�����������õ����ս��
 * InputStream inputStream = new LineNumberInputStream(new BufferedInputStream(new FileInputStream("")));
 *
 */
public class DecoratePattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //��һ������
        component = new ConcreteDecoratorA(component);
        //�ڶ�������
        component = new ConcreteDecoratorB(component);
        //���κ�����
        component.operation();
    }
}

/**
 * Component��һ���ӿڻ��ǳ����࣬���Ƕ�����������ĵĶ���Ҳ������ԭʼ�Ķ���
 */
abstract class Component {
    public abstract void operation();
}

/**
 * ���幹����ͨ���̳�ʵ��Component�������еĳ��󷽷���������ġ���ԭʼ��������Ľӿڻ�������ʵ�֣�����Ҫװ�εľ�������
 */
class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("�������Ĳ���");
    }

}

/**
 * װ����
 * һ����һ�������࣬�����������Ȼ��һ��private����ָ��Component���󹹼���
 */
abstract class Decorator extends Component {

    private Component component = null;

    //ͨ�����캯�����ݸ���������
    public Decorator(Component component) {
        this.component = component;
    }

    //ί�и���������ִ��
    @Override
    public void operation() {
        if(component != null) {
            this.component.operation();
        }
    }

}

/**
 * ���ǿ���д�������ʵ���࣬������ĵġ���ԭʼ�ġ�������Ķ���װ�γ�����������
 * �����д�����࣬�Ը�һ�¶��ߵ�ʵ��˳�򣬿��������
 */

/**
 * װ����ľ���ʵ��A
 */
class ConcreteDecoratorA extends Decorator {

    //���屻������
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //�����Լ������η���
    private void method1() {
        System.out.println("method1 ����");
    }

    @Override
    public void operation() {
        this.method1();
        super.operation();
    }

}

/**
 * װ����B
 */
class ConcreteDecoratorB extends Decorator {

    //���屻������
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    //�����Լ������η���
    private void method2() {
        System.out.println("method2 ����");
    }

    @Override
    public void operation() {
        super.operation();
        this.method2();
    }

}