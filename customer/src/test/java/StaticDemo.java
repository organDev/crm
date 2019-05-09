/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

/**
 * @author maikec
 * @date 2019/3/21
 * 静态成员常量先于静态代码块初始化
 */
public class StaticDemo {
    static final int anInt = 100;
    final int c = 200;
    static {
        System.out.println("before:"+anInt );
        int b  = 100;
        System.out.println( anInt );
    }

    public static void main(String[] args) {

    }
}
