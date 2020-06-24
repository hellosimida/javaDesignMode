package action;

/**
 * ״̬ģʽ
 *
 * ��״̬ģʽ��State Pattern���У������Ϊ�ǻ�������״̬�ı�ġ��������͵����ģʽ������Ϊ��ģʽ��
 * ��״̬ģʽ�У����Ǵ�����ʾ����״̬�Ķ����һ����Ϊ����״̬����ı���ı�� context ����
 *
 * ����
 * ��ͼ������������ڲ�״̬�����ı�ʱ�ı�������Ϊ���������������޸��������ࡣ
 *
 * ��Ҫ������������Ϊ����������״̬�����ԣ������ҿ��Ը�������״̬�ı���ı����������Ϊ��
 *
 * ��ʱʹ�ã������а������������״̬�йص�������䡣
 *
 * ��ν���������־����״̬����������
 *
 * �ؼ����룺ͨ������ģʽ�Ľӿ���ֻ��һ����������״̬ģʽ�Ľӿ�����һ�����߶�����������ң�״̬ģʽ��ʵ����ķ�����һ�㷵��ֵ�������Ǹı�ʵ��������ֵ��Ҳ����˵��״̬ģʽһ��Ͷ����״̬�йء�ʵ����ķ����в�ͬ�Ĺ��ܣ����ǽӿ��еķ�����״̬ģʽ������ģʽһ����Ҳ������������ if...else ������ѡ����䡣
 *
 * Ӧ��ʵ���� 1���������ʱ���˶�Ա����������״̬��������״̬�ͳ���״̬�� 2�������ұ����У�'���ǳ���ӿ�','��A'���Ǿ���״̬��'�����ұ���'�Ǿ��廷����Context����
 *
 * �ŵ㣺 1����װ��ת������ 2��ö�ٿ��ܵ�״̬����ö��״̬֮ǰ��Ҫȷ��״̬���ࡣ 3����������ĳ��״̬�йص���Ϊ�ŵ�һ�����У����ҿ��Է���������µ�״̬��ֻ��Ҫ�ı����״̬���ɸı�������Ϊ�� 4������״̬ת���߼���״̬����ϳ�һ�壬������ĳһ���޴���������顣 5�������ö������������һ��״̬���󣬴Ӷ�����ϵͳ�ж���ĸ�����
 * ȱ�㣺 1��״̬ģʽ��ʹ�ñ�Ȼ������ϵͳ��Ͷ���ĸ����� 2��״̬ģʽ�Ľṹ��ʵ�ֶ���Ϊ���ӣ����ʹ�ò��������³���ṹ�ʹ���Ļ��ҡ� 3��״̬ģʽ��"����ԭ��"��֧�ֲ���̫�ã����ڿ����л�״̬��״̬ģʽ�������µ�״̬����Ҫ�޸���Щ����״̬ת����Դ���룬�����޷��л�������״̬�������޸�ĳ��״̬�����ΪҲ���޸Ķ�Ӧ���Դ���롣
 *
 * ʹ�ó����� 1����Ϊ��״̬�ı���ı�ĳ����� 2����������֧���Ĵ����ߡ�
 *
 * ע���������Ϊ��״̬Լ����ʱ��ʹ��״̬ģʽ������״̬������ 5 ����
 *
 * ʵ��
 * ���ǽ�����һ�� State �ӿں�ʵ���� State �ӿڵ�ʵ��״̬�ࡣContext ��һ������ĳ��״̬���ࡣ
 * StatePatternDemo�����ǵ���ʾ��ʹ�� Context ��״̬��������ʾ Context ��״̬�ı�ʱ����Ϊ�仯��
 */
public class StatePattern {
    public static void main(String[] args) {
        /**
         * Context ���Բ���ά�� state ���ԣ����������򵥺ܶ�
         */
        Context1 context = new Context1();

        /**
         * ��Ϊ��ʼ״̬
         */
        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        /**
         * ��Ϊ����״̬
         */
        StopState stopState = new StopState();
        stopState.doAction(context);

        /**
         * ���Ի�ȡ��ǰ��״̬
         */
        System.out.println(context.getState().toString());
    }
}

/**
 * ����״̬�ӿ�
 */
interface State {
    public void doAction(Context1 context);
}

/**
 * ����һ����ʼ״̬
 */
class StartState implements State {

    public void doAction(Context1 context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}

/**
 * ����һ������״̬
 */
class StopState implements State {

    public void doAction(Context1 context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}

/**
 * ���� Context ��
 */
class Context1 {
    private State state;

    public Context1(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
