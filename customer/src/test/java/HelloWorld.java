/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import org.junit.Test;

import java.sql.Date;

/**
 * @author maikec
 * @date 2019/1/30
 */
public class HelloWorld {
    public class Inner{

    }

    public static void main(String[] args) {
        int i = 0;
        int j = i;
        System.out.println( i == j );

        Integer integer = new Integer( 1 );
        Integer integer1 = integer;
        integer1 = 2;
        System.out.println( integer.hashCode() + "=" + integer1.hashCode() );


        Integer integer2 = 1;
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.one(integer2);
        System.out.println( integer2 );
    }

    public void one(Integer param){
        param = 2;
        System.out.println( param );
    }

    @Test
    public void date(){
        System.out.println( new Date(1549470858000L) );
    }
}
