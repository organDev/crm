/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author maikec
 * @date 2019/3/27
 */
public class FunctionalInterfaceMain {
    public static void main(String[] args) {
        FunctionalInterfaceDemo demo = (a, b)->{return a+b;};
        System.out.println( demo.sum( 1, 3 ) );
        demo.intro();

        List intList=Arrays.asList(10,20,30,40,50);
        // Counting
        long  count = (Long) intList.stream().collect(Collectors.counting());
        System.out.println(count);
    }
}
