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
 * @date 2019/4/17
 */
public class StackDemo {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;//存放方法区的局部变量表中
        System.out.println( a == b );
        Integer c = new Integer( 1 );//存放在堆空间
        System.out.println( a == c );
        Integer d = new Integer( 1 );
        System.out.println( d == c );
    }
}
