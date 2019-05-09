package Iterator;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author maikec
 * @date 2019/5/8
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList( new String[]{"a", "b", "c", "d"} );
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            System.out.println( iterator.next() );
        }
        for (String s:list
             ) {
            System.out.println( s );
        }
    }
}
