/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.util.ReflectUtil;
import lombok.Getter;

import java.lang.reflect.Field;

/**
 * @author maikec
 * @date 2019/3/21
 */
public class FinalDemo {
    @Getter
    private final Integer a;

    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo(100);
        Field field = ReflectUtil.getField( finalDemo.getClass(),"a" );
        try {
            field.setInt( finalDemo,1 );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public FinalDemo(Integer a){
        this.a = a;
    }

}
