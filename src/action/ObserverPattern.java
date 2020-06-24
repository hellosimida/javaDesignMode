package action;

import java.util.ArrayList;
import java.util.List;

/**
 * �۲���ģʽ
 *
 * ����������һ�Զ��ϵʱ����ʹ�ù۲���ģʽ��Observer Pattern�������磬��һ�������޸�ʱ������Զ�֪ͨ�������Ķ���
 *
 * ����
 * ��ͼ�����������һ��һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�
 * ��Ҫ�����һ������״̬�ı����������֪ͨ�����⣬����Ҫ���ǵ����ú͵���ϣ���֤�߶ȵ�Э����
 * ��ʱʹ�ã�һ������Ŀ����󣩵�״̬�����ı䣬���е��������󣨹۲��߶��󣩶����õ�֪ͨ�����й㲥֪ͨ��
 * ��ν����ʹ����������������Խ�����������ϵ������
 * �ؼ����룺�ڳ���������һ�� ArrayList ��Ź۲����ǡ�
 *
 * Ӧ��ʵ���� 1��������ʱ������ʦ�۲���߱�ۣ�Ȼ��֪ͨ�����������߾��ۡ� 2�����μ���������������������캢������������һ��ˮ����һ�����ڹ꣬����ڹ���ǹ۲��ߣ����۲�������ˮ���������
 *
 * �ŵ㣺 1���۲��ߺͱ��۲����ǳ�����ϵġ� 2������һ�״������ơ�
 * ȱ�㣺 1�����һ�����۲��߶����кܶ��ֱ�Ӻͼ�ӵĹ۲��ߵĻ��������еĹ۲��߶�֪ͨ���Ứ�Ѻܶ�ʱ�䡣 2������ڹ۲��ߺ͹۲�Ŀ��֮����ѭ�������Ļ����۲�Ŀ��ᴥ������֮�����ѭ�����ã����ܵ���ϵͳ������ 3���۲���ģʽû����Ӧ�Ļ����ù۲���֪�����۲��Ŀ���������ô�����仯�ģ�������ֻ��֪���۲�Ŀ�귢���˱仯��
 *
 * ʹ�ó�����
 * һ������ģ�����������棬����һ��������������һ�����档����Щ�����װ�ڶ����Ķ�����ʹ���ǿ��Ը��Զ����ظı�͸��á�
 * һ������ĸı佫��������һ����������Ҳ�����ı䣬����֪�������ж��ٶ��󽫷����ı䣬���Խ��Ͷ���֮�����϶ȡ�
 * һ���������֪ͨ�������󣬶�����֪����Щ������˭��
 * ��Ҫ��ϵͳ�д���һ����������A�������Ϊ��Ӱ��B����B�������Ϊ��Ӱ��C���󡭡�������ʹ�ù۲���ģʽ����һ����ʽ�������ơ�
 * ע����� 1��JAVA ���Ѿ����˶Թ۲���ģʽ��֧���ࡣ 2������ѭ�����á� 3�����˳��ִ�У�ĳһ�۲��ߴ���ᵼ��ϵͳ���ǣ�һ������첽��ʽ��
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

/**
 * ���ȣ���Ҫ�������⣬ÿ��������Ҫ���й۲����б�����ã����������ݱ����ʱ��֪ͨ�����۲���
 */
class Subject {

    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

/**
 * ����۲��߽ӿ�
 */
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

/**
 * ����Ĺ۲�����
 */
class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}

/**
 * ����Ĺ۲�����
 */
class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}

/**
 * ����Ĺ۲�����
 */
class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}


