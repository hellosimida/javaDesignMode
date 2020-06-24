package structure;

/**
 * ����ģʽ
 * Ҳ�����ģʽ��Facade Pattern�������Դ������ʹ�ã����� slf4j �Ϳ������Ϊ������ģʽ��Ӧ�á�����һ���򵥵����ģʽ
 */
public class FacadePattern {
    public static void main(String[] args) {
        /**
         * ����ʹ�÷������������ԵĶ����ٻ�ͼ
         */
        // ��һ��Բ��
        Shape circle = new Circle();
        circle.draw();

        // ��һ��������
        Shape rectangle = new Rectangle();
        rectangle.draw();

        /**
         * ʹ��������ֱ�ӿ��Ի����뻭��ͼ
         */
        ShapeMaker shapeMaker = new ShapeMaker();

        // �ͻ��˵������ڸ���������
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

/**
 * ����һ�������ӿڻ�ͼ
 */
interface Shape {
    void draw();
}

/**
 *��Բ
 */
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("��Բ");
    }
}

/**
 *������
 */
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("������");
    }
}

/**
 *��������
 */
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("��������");
    }
}

/**
 * ����һ�������࣬�����еĶ��󶼴�������
 */
class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    /**
     * ���涨��һ�ѷ���������Ӧ�õ���ʲô���������������������
     */

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

