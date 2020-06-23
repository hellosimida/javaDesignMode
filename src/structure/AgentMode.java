package structure;

/**
 * ����ģʽ
 * ��ͼ��Ϊ���������ṩһ�ִ����Կ��ƶ��������ķ��ʡ�
 *
 * ��Ҫ�������ֱ�ӷ��ʶ���ʱ���������⣬����˵��Ҫ���ʵĶ�����Զ�̵Ļ����ϡ����������ϵͳ�У���Щ��������ĳЩԭ�򣨱�����󴴽������ܴ󣬻���ĳЩ������Ҫ��ȫ���ƣ�������Ҫ������ķ��ʣ���ֱ�ӷ��ʻ��ʹ���߻���ϵͳ�ṹ�����ܶ��鷳�����ǿ����ڷ��ʴ˶���ʱ����һ���Դ˶���ķ��ʲ㡣
 *
 * ��ʱʹ�ã����ڷ���һ����ʱ��һЩ���ơ�
 *
 * ��ν���������м�㡣
 *
 * �ؼ����룺ʵ���뱻��������ϡ�
 *
 * Ӧ��ʵ����   1��Windows ����Ŀ�ݷ�ʽ��
 *              2����˽�ȥ�Ҹߴ������������ձ�ģ�����������⣺�Ѹߴ�������ò����������ߴ������˺�����ն�ʵ��������ӿڣ���˽���ʸߴ�����ʱ�򿴲��������������գ�����˵������Ǹߴ��������ࡣ
 *              3�����Ʊ��һ���ڻ�վ��Ҳ����ȥ���۵㡣
 *              4��һ��֧Ʊ�����д浥���˻����ʽ�Ĵ���֧Ʊ���г����������������ֽ𣬲��ṩ��ǩ�����˺����ʽ�Ŀ��ơ�
 *              5��spring aop��
 *
 * �ŵ㣺 1��ְ�������� 2������չ�ԡ� 3�����ܻ���
 *
 * ȱ�㣺 1�������ڿͻ��˺���ʵ����֮�������˴�����������Щ���͵Ĵ���ģʽ���ܻ��������Ĵ����ٶȱ����� 2��ʵ�ִ���ģʽ��Ҫ����Ĺ�������Щ����ģʽ��ʵ�ַǳ����ӡ�
 *
 * ʹ�ó�������ְ�������֣�ͨ��������ʹ�ó����� 1��Զ�̴��� 2��������� 3��Copy-on-Write ���� 4��������Protect or Access������ 5��Cache���� 6������ǽ��Firewall������ 7��ͬ������Synchronization������ 8���������ã�Smart Reference������
 *
 * ע����� 1����������ģʽ������������ģʽ��Ҫ�ı������Ƕ���Ľӿڣ�������ģʽ���ܸı���������Ľӿڡ�
 *            2����װ����ģʽ������װ����ģʽΪ����ǿ���ܣ�������ģʽ��Ϊ�˼��Կ��ơ�
 */
public class AgentMode {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // ͼ�񽫴Ӵ��̼���
        image.display();
        System.out.println("");
        // ͼ����Ҫ�Ӵ��̼���
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
