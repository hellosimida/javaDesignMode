package action;

import java.util.ArrayList;
import java.util.List;

/**
 * ����¼ģʽ
 * ����¼ģʽ��Memento Pattern������һ�������ĳ��״̬���Ա����ʵ���ʱ��ָ����󡣱���¼ģʽ������Ϊ��ģʽ��
 *
 * ����
 * ��ͼ���ڲ��ƻ���װ�Ե�ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬��
 * ��Ҫ�������ν����¼ģʽ�����ڲ��ƻ���װ��ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬�������������Ժ󽫶���ָ���ԭ�ȱ����״̬��
 * ��ʱʹ�ã��ܶ�ʱ������������Ҫ��¼һ��������ڲ�״̬����������Ŀ�ľ���Ϊ�������û�ȡ����ȷ�����ߴ���Ĳ������ܹ��ָ�����ԭ�ȵ�״̬��ʹ������"���ҩ"�ɳԡ�
 * ��ν����ͨ��һ������¼��ר�Ŵ洢����״̬��
 *
 * �ؼ����룺�ͻ����뱸��¼����ϣ��뱸��¼��������ϡ�
 *
 * Ӧ��ʵ���� 1�����ҩ�� 2������Ϸʱ�Ĵ浵�� 3��Windows ��� ctri + z�� 4��IE �еĺ��ˡ� 4�����ݿ���������
 *
 * �ŵ㣺 1�����û��ṩ��һ�ֿ��Իָ�״̬�Ļ��ƣ�����ʹ�û��ܹ��ȽϷ���ػص�ĳ����ʷ��״̬�� 2��ʵ������Ϣ�ķ�װ��ʹ���û�����Ҫ����״̬�ı���ϸ�ڡ�
 * ȱ�㣺������Դ�������ĳ�Ա�������࣬�Ʊػ�ռ�ñȽϴ����Դ������ÿһ�α��涼������һ�����ڴ档
 *
 * ʹ�ó����� 1����Ҫ����/�ָ����ݵ����״̬������ 2���ṩһ���ɻع��Ĳ�����
 * ע����� 1��Ϊ�˷��ϵ�����ԭ�򣬻�Ҫ����һ��������¼���ࡣ 2��Ϊ�˽�Լ�ڴ棬��ʹ��ԭ��ģʽ+����¼ģʽ��
 *
 * ʵ��
 * ����¼ģʽʹ�������� Memento��Originator �� CareTaker��Memento ������Ҫ���ָ��Ķ����״̬��Originator �������� Memento �����д洢״̬��Caretaker ������� Memento �лָ������״̬��
 * MementoPatternDemo�����ǵ���ʾ��ʹ�� CareTaker �� Originator ��������ʾ�����״̬�ָ���
 */
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}

class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
