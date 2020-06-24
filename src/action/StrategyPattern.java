package action;

/**
 * ����ģʽ
 * ������ģʽ��������
 * ����ģʽ�����һ�������ѡ�����ģʽ����ϸ��ͣ��ṹ������һЩ
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // ʹ����ɫ������
        context.executeDraw(10, 0, 0);
    }
}

interface Strategy {
    public void draw(int radius, int x, int y);
}

class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("�ú�ɫ�ʻ�ͼ��radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("����ɫ�ʻ�ͼ��radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("����ɫ�ʻ�ͼ��radius:" + radius + ", x:" + x + ", y:" + y);
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeDraw(int radius, int x, int y){
        strategy.draw(radius, x, y);
    }
}