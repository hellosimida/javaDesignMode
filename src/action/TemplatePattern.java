package action;

/**
 * ģ��ģʽ
 * ��ģ��ģʽ��Template Pattern���У�һ�������๫��������ִ�����ķ����ķ�ʽ/ģ�塣����������԰���Ҫ��д����ʵ�֣������ý��Գ������ж���ķ�ʽ���С��������͵����ģʽ������Ϊ��ģʽ��
 *
 * ����
 * ��ͼ������һ�������е��㷨�ĹǼܣ�����һЩ�����ӳٵ������С�ģ�巽��ʹ��������Բ��ı�һ���㷨�Ľṹ�����ض�����㷨��ĳЩ�ض����衣
 * ��Ҫ�����һЩ����ͨ�ã�ȴ��ÿһ�����඼����д����һ������
 * ��ʱʹ�ã���һЩͨ�õķ�����
 * ��ν��������Щͨ���㷨���������
 * �ؼ����룺�ڳ�����ʵ�֣���������������ʵ�֡�
 *
 * Ӧ��ʵ���� 1�����췿�ӵ�ʱ�򣬵ػ������ߡ�ˮ�ܶ�һ����ֻ���ڽ����ĺ��ڲ��мӱڳ���դ���Ȳ��졣 2�����μ������������õ� 81 �ѣ������һ��������߼��Ǽܡ� 3��spring �ж� Hibernate ��֧�֣���һЩ�Ѿ����õķ�����װ���������翪�����񡢻�ȡ Session���ر� Session �ȣ�����Ա���ظ�д��Щ�Ѿ��淶�õĴ��룬ֱ�Ӷ�һ��ʵ��Ϳ��Ա��档
 *
 * �ŵ㣺 1����װ���䲿�֣���չ�ɱ䲿�֡� 2����ȡ�������룬����ά���� 3����Ϊ�ɸ�����ƣ�����ʵ�֡�
 * ȱ�㣺ÿһ����ͬ��ʵ�ֶ���Ҫһ��������ʵ�֣�������ĸ������ӣ�ʹ��ϵͳ�����Ӵ�
 *
 * ʹ�ó����� 1���ж�����๲�еķ��������߼���ͬ�� 2����Ҫ�ġ����ӵķ��������Կ�����Ϊģ�巽����
 *
 * ע�����Ϊ��ֹ���������һ��ģ�巽�������� final �ؼ��ʡ�
 */
public class TemplatePattern {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

/**
 * ����һ�������࣬����ģ�巽��������Ϊ final��
 */
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //ģ��
    public final void play(){

        //��ʼ����Ϸ
        initialize();

        //��ʼ��Ϸ
        startPlay();

        //������Ϸ
        endPlay();
    }
}

/**
 *������չ���������ʵ���ࡣ
 */
class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

/**
 * ������չ���������ʵ���ࡣ
 */
class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}