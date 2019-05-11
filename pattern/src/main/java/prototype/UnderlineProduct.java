package prototype;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import prototype.framework.Product;
import prototype.framework.exception.CloneFailureException;

/**
 * @author maikec
 * @date 2019/5/11
 */
public class UnderlineProduct implements Product {
    @Override
    public void use() {
        System.out.println( "UnderlineProduct" );
    }

    @Override
    public UnderlineProduct createClone() {
        try {
            return (UnderlineProduct) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new CloneFailureException();
        }
    }
}
