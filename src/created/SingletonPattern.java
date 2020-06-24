package created;

/**
 * ����ģʽ
 *
 * ����̸֮��һ������£�������ʹ�õ� 1 �ֺ͵� 2 ��������ʽ������ʹ�õ� 3 �ֶ�����ʽ��
 * ֻ����Ҫ��ȷʵ�� lazy loading Ч��ʱ���Ż�ʹ�õ� 5 �ֵǼǷ�ʽ������漰�������л���������ʱ�����Գ���ʹ�õ� 6 ��ö�ٷ�ʽ��
 * �����������������󣬿��Կ���ʹ�õ� 4 ��˫������ʽ��*/
public class SingletonPattern {

}
/**
 * 1.����ʽ�̲߳���ȫд��
 */
class SingletonUnsafe {
    private static SingletonUnsafe instance;
    private SingletonUnsafe (){}

    public static SingletonUnsafe getInstance() {
        if (instance == null) {
            instance = new SingletonUnsafe();
        }
        return instance;
    }
}

/**
 * 2.����ʽ�̰߳�ȫд��
 */
class SingletonSafe {
    private static SingletonSafe instance;
    private SingletonSafe (){}
    public static synchronized SingletonSafe getInstance() {
        if (instance == null) {
            instance = new SingletonSafe();
        }
        return instance;
    }
}

/**
 * 3.����ʽ
 */
class SingletonHunger {
    private static SingletonHunger instance = new SingletonHunger();
    private SingletonHunger (){}
    public static SingletonHunger getInstance() {
        return instance;
    }
}

/**
 * 4.˫����/˫��У������DCL���� double-checked locking��
 * ���ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
 */
class SingletonDCL {
    private volatile static SingletonDCL singleton;
    private SingletonDCL (){}
    public static SingletonDCL getSingleton() {
        if (singleton == null) {
            synchronized (SingletonDCL.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }
}

/**
 * 5.�Ǽ�ʽ/��̬�ڲ���
 * �Ƿ� Lazy ��ʼ������
 * �Ƿ���̰߳�ȫ����
 * ʵ���Ѷȣ�һ��
 * ���������ַ�ʽ�ܴﵽ˫������ʽһ���Ĺ�Ч����ʵ�ָ��򵥡�
 * �Ծ�̬��ʹ���ӳٳ�ʼ����Ӧʹ�����ַ�ʽ������˫������ʽ��
 * ���ַ�ʽֻ�����ھ�̬��������˫������ʽ����ʵ������Ҫ�ӳٳ�ʼ��ʱʹ�á�
 * ���ַ�ʽͬ�������� classloader ��������֤��ʼ�� instance ʱֻ��һ���̣߳�
 * ������ 3 �ַ�ʽ��ͬ���ǣ��� 3 �ַ�ʽֻҪ Singleton �౻װ���ˣ�
 * ��ô instance �ͻᱻʵ������û�дﵽ lazy loading Ч�����������ַ�ʽ�� Singleton �౻װ���ˣ�instance ��һ������ʼ����
 * ��Ϊ SingletonHolder ��û�б�����ʹ�ã�ֻ��ͨ����ʽ���� getInstance ����ʱ���Ż���ʽװ�� SingletonHolder �࣬
 * �Ӷ�ʵ���� instance������һ�£����ʵ���� instance ��������Դ�������������ӳټ��أ�����һ���棬
 * �ֲ�ϣ���� Singleton �����ʱ��ʵ��������Ϊ����ȷ�� Singleton �໹�����������ĵط�������ʹ�ôӶ������أ�
 * ��ô���ʱ��ʵ���� instance ��Ȼ�ǲ����ʵġ����ʱ�����ַ�ʽ��ȵ� 3 �ַ�ʽ���Եúܺ���
 */
class SingletonInner {
    private static class SingletonHolder {
        private static final SingletonInner INSTANCE = new SingletonInner();
    }
    private SingletonInner (){}
    public static final SingletonInner getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 6��ö��
 * �Ƿ� Lazy ��ʼ������
 * �Ƿ���̰߳�ȫ����
 * ʵ���Ѷȣ���
 * ����������ʵ�ַ�ʽ��û�б��㷺���ã�������ʵ�ֵ���ģʽ����ѷ�����������࣬�Զ�֧�����л����ƣ����Է�ֹ���ʵ������
 * ���ַ�ʽ�� Effective Java ���� Josh Bloch �ᳫ�ķ�ʽ���������ܱ�����߳�ͬ�����⣬���һ��Զ�֧�����л����ƣ���ֹ�����л����´����µĶ��󣬾��Է�ֹ���ʵ���������������� JDK1.5 ֮��ż��� enum ���ԣ������ַ�ʽд�������˸о����裬��ʵ�ʹ����У�Ҳ�����á�
 * ����ͨ�� reflection attack ������˽�й��췽����
 */
enum SingletonEnum {
    INSTANCE;
    public void whateverMethod() {
    }
}

