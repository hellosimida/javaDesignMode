package structure;

/**
 * ������ģʽ֮Ĭ��������
 */
public class DefaultAdapterPattern {
    public static void main(String[] args) {

        CarDesigner carDesigner=new CarDesigner();
        carDesigner.drawPicture();
        carDesigner.findIdea();
        carDesigner.thinkUE();
        carDesigner.showPicture();

        System.out.println("----------------------");

        HouseDesigner houseDesigner=new HouseDesigner();
        houseDesigner.drawPicture();
        houseDesigner.findIdea();
        houseDesigner.thinkUE();
        houseDesigner.showPicture();
    }
}

interface IDesigner {

    public void drawPicture();

    public void findIdea();

    public void thinkUE();

    public void showPicture();
}

//Ĭ��������
abstract class Designer implements IDesigner {

    public void drawPicture() {
        System.out.println("������");
    }

    public void findIdea() {
        System.out.println("Ѱ����У�");
    }
}

//������1
class CarDesigner extends Designer{

    @Override
    public void thinkUE() {
        System.out.println("˼���������û����飡");
    }

    @Override
    public void showPicture() {
        System.out.println("���������չ��");
    }

}

//������2
class HouseDesigner extends Designer {

    @Override
    public void thinkUE() {
        System.out.println("˼�����ݵ��û����飡");
    }

    @Override
    public void showPicture() {
        System.out.println("�췿�����չ��");
    }
}