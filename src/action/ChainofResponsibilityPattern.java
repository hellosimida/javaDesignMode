package action;

/**
 * ������ģʽ
 *
 * ������������˼�壬����������������������ε�һ��ִ������ִ�������ж���ڵ㣬ÿ���ڵ㶼�л��ᣨ����ƥ�䣩���������������ĳ���ڵ㴦�����˾Ϳ��Ը���ʵ��ҵ�����󴫵ݸ���һ���ڵ����������߷��ش�����ϡ�
 *
 * ��ʵ�У���ٵ�OA���룬�����������ǰ��쵽1�죬����ֱ��������׼���ɣ�
 * �����1��3��ļ��ڣ���Ҫ���ž�����׼��
 * �����3�쵽30�죬����Ҫ�ܾ���������
 * ����30�죬����������׼��
 *
 * Ϊ��ʵ���������������ǿ��Բ������������ģʽ��
 * Ա���ύ�����ࣺLeaveRequest��
 * �����������δ����ࣺAbstractLeaveHandler��
 * ֱ���������������ࣺDirectLeaderLeaveHandler��
 * ���ž������ࣺDeptManagerLeaveHandler��
 * �ܾ������ࣺ GManagerLeaveHandler��
 */
public class ChainofResponsibilityPattern {
    public static void main(String[] args) {
        LeaveRequest request = LeaveRequest.builder().leaveDays(20).name("С��").build();


        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("����");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("֪��");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("������");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);


    }
}

/**
 * Ա���ύ����ʵ����
 */
class LeaveRequest {
    /**����*/
    private int leaveDays;

    /**����*/
    private String name;

    public LeaveRequest(int leaveDays, String name) {
        this.leaveDays = leaveDays;
        this.name = name;
    }

    public LeaveRequest() {

    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // build() �������� UserBuilder �����úõ����ԡ����ơ��� User �С�
    // ��Ȼ�������� �����ơ� ֮ǰ�������
    public LeaveRequest build() {
        return new LeaveRequest(leaveDays, name);
    }

    public static LeaveRequest builder() {
        return new LeaveRequest();
    }

    public LeaveRequest name(String name) {
        this.name = name;
        return this;
    }

    public LeaveRequest leaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
        return this;
    }

}

/**
 * �����������δ�����
 */
class AbstractLeaveHandler {
    /**ֱ����������������������*/
    protected int MIN = 1;
    /**���ž�������������*/
    protected int MIDDLE = 3;
    /**�ܾ�������������*/
    protected int MAX = 30;

    /**�쵼����*/
    protected String handlerName;

    /**��һ������ڵ㣨�����߼�����쵼��*/
    protected AbstractLeaveHandler nextHandler;

    /**������һ�ڵ�*/
    protected void setNextHandler(AbstractLeaveHandler handler){
        this.nextHandler = handler;
    }

    /**������ٵ���������ʵ��*/
    protected void handlerRequest(LeaveRequest request){

    }
}

/**
 * ֱ����������������
 */
class DirectLeaderLeaveHandler extends AbstractLeaveHandler{
    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() <= this.MIN){
            System.out.println("ֱ������:" + handlerName + ",�Ѿ�����;���̽�����");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("�����ܾ���");
        }

    }
}

/**
 * ���ž�������
 */
class DeptManagerLeaveHandler extends AbstractLeaveHandler {

    public DeptManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() >this.MIN && request.getLeaveDays() <= this.MIDDLE){
            System.out.println("���ž���:" + handlerName + ",�Ѿ�����;���̽�����");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("�����ܾ���");
        }
    }
}

/**
 * �ܾ�������
 */
class GManagerLeaveHandler extends AbstractLeaveHandler {
    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() > this.MIDDLE && request.getLeaveDays() <= this.MAX){
            System.out.println("�ܾ���:" + handlerName + ",�Ѿ�����;���̽�����");
            return;
        }

        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("�����ܾ���");
        }
    }
}
