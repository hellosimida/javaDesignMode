package structure;

/**
 * ����ģʽ
 * ����: �������ʵ�ֽ���, ʹ�����߿��Զ����ı仯
 * ͨ�׵�˵, ����һ���������һ�����еķ���, ��Ҫһ������, ͨ���ۺϵĹ�ϵ����
 *
 * ����ģʽ���ŵ�:
 * �����ʵ�ַ���. ��������ģʽ����Ҫ�ص�, ����ȫ��Ϊ�˽���̳е�ȱ�����������ģʽ. �ڸ�ģʽ��,ʵ�ֿ��Բ��ܳ����Լ��,�����ٰ���һ���̶��ĳ�������
 * �������������.
 * ʵ��ϸ�ڶԿͻ�͸��. �ͻ����ù���ϸ�ڵ�ʵ��, ���Ѿ��ɳ����ͨ���ۺϹ�ϵ����˷�װ.
 *
 * ����ģʽ��ʹ�ó���:
 * ��ϣ��������ʹ�ü̳еĳ���. ����̳в�ι��ˡ��޷���ϸ����ƿ����ȳ���
 * �ӿڻ�����಻�ȶ��ĳ���.
 * ������Ҫ��ϸߵĳ���. ��ƵĿ�����Խϸ,�����õĿ����Ծ�Խ��, �����ü̳����ܸ��������, �����ܳ���̫ϸ�Ŀ�����
 *
 *
 * ʹ������ģʽ��Ҫ������β�ֳ����ʵ��,������һ��Ƽ̳о�Ҫ����ʹ�ø�ģʽ. ����ģʽ����ͼ���ǶԱ仯�ķ�װ, �����ѿ��ܱ仯�����ط�װ����ϸ����С���߼���Ԫ��,���������ɢ.����ڽ���ϵͳ���ʱ,������ļ̳���N��ʱ,���Կ���ʹ������ģʽ
 * ����ģʽ��JavaӦ���е�һ���ǳ����͵����Ӿ���JDBC��������JDBCΪ���еĹ�ϵ�����ݿ��ṩһ��ͨ�õĽ��档һ��Ӧ��ϵͳ��̬��ѡ��һ�����ʵ���������Ȼ��ͨ�������������ݿ����淢��ָ�������̾��ǽ������ɫ����Ϊί�ɸ�ʵ�ֽ�ɫ�Ĺ��̡�
 * �����ɫ��������κ����ݿ����淢����ѯָ���Ϊ�����ɫ����ֱ�������ݿ�����򽻵���JDBC��������������ײ�Ĺ���������JDBC�������Ĵ��ڣ�Ӧ��ϵͳ���Բ����������ݿ������ϸ�ڶ��������ݻ���ͬʱ���ݿ�����Ҳ���Զ�����Ӧ��ϵͳ��ϸ�ڶ��������ݻ�
 */
public class BridgePattern {
    /**
     * ********************************************************
     * @ClassName: Client
     * @Description: ����ģʽ���Կͻ���
     *
     **********************************************************
     */
    public static void main(String[] args) {
        DriverManager manager = new DriverManager(new MysqlDriver());
        manager.getConnection();

        manager = new DriverManager(new OracleDriver());
        manager.getConnection();
    }
}

/**
 * ********************************************************
 * @ClassName: Driver
 * @Description: ʵ�ֻ���ɫ
 *
 **********************************************************
 */
interface Driver {
    public void getConnection();
}

/**
 * ********************************************************
 * @ClassName: MysqlDriver
 * @Description: ����ʵ�ֻ���ɫ
 *
 **********************************************************
 */
class MysqlDriver implements Driver{
    @Override
    public void getConnection() {
        System.out.println("mysql ���ݿ�����");
    }
}

/**
 * ********************************************************
 * @ClassName: OracleDriver
 * @Description: ����ʵ�ֻ���ɫ
 *
 **********************************************************
 */
class OracleDriver implements Driver{
    @Override
    public void getConnection() {
        System.out.println("oracle���ݿ�����");
    }
}

/**
 * ********************************************************
 * @ClassName: Manager
 * @Description: ���󻯽�ɫ
 *
 **********************************************************
 */
abstract class Manager {
    private Driver driver;

    public Manager(Driver driver){
        this.driver = driver;
    }

    public  void getConnection(){
        driver.getConnection();
    }
}
/**
 * ********************************************************
 * @ClassName: Manager
 * @Description: ������󻯽�ɫ
 *
 **********************************************************
 */
class DriverManager extends Manager {
    public DriverManager(Driver driver){
        super(driver);
    }

    @Override
    public  void getConnection(){
        super.getConnection();
    }
}

