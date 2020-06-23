package created;

/**
 * ����ģʽ
 */
public class SingletonMode {
    /**
     * 1.����ʽ�̲߳���ȫд��
     */
    /*public class Singleton {
        private static Singleton instance;
        private Singleton (){}

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }*/

    /**
     * 2.����ʽ�̰߳�ȫд��
     */
    /*public class Singleton {
        private static Singleton instance;
        private Singleton (){}
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }*/

    /**
     * 3.����ʽ
     */
    /*public class Singleton {
        private static Singleton instance = new Singleton();
        private Singleton (){}
        public static Singleton getInstance() {
            return instance;
        }
    }*/

    /**
     * 4.˫����/˫��У������DCL���� double-checked locking��
     * ���ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
     */
    /*public class Singleton {
        private volatile static Singleton singleton;
        private Singleton (){}
        public static Singleton getSingleton() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }*/

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
    /*public class Singleton {
        private static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }
        private Singleton (){}
        public static final Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }*/

    /**
     * 6��ö��
     * �Ƿ� Lazy ��ʼ������
     * �Ƿ���̰߳�ȫ����
     * ʵ���Ѷȣ���
     * ����������ʵ�ַ�ʽ��û�б��㷺���ã�������ʵ�ֵ���ģʽ����ѷ�����������࣬�Զ�֧�����л����ƣ����Է�ֹ���ʵ������
     * ���ַ�ʽ�� Effective Java ���� Josh Bloch �ᳫ�ķ�ʽ���������ܱ�����߳�ͬ�����⣬���һ��Զ�֧�����л����ƣ���ֹ�����л����´����µĶ��󣬾��Է�ֹ���ʵ���������������� JDK1.5 ֮��ż��� enum ���ԣ������ַ�ʽд�������˸о����裬��ʵ�ʹ����У�Ҳ�����á�
     * ����ͨ�� reflection attack ������˽�й��췽����
     */
    /*public enum Singleton {
        INSTANCE;
        public void whateverMethod() {
        }
    }*/

    /**
     * ����̸֮��һ������£�������ʹ�õ� 1 �ֺ͵� 2 ��������ʽ������ʹ�õ� 3 �ֶ�����ʽ��
     * ֻ����Ҫ��ȷʵ�� lazy loading Ч��ʱ���Ż�ʹ�õ� 5 �ֵǼǷ�ʽ������漰�������л���������ʱ�����Գ���ʹ�õ� 6 ��ö�ٷ�ʽ��
     * �����������������󣬿��Կ���ʹ�õ� 4 ��˫������ʽ��*/
}
