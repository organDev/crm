package prototype.framework;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import prototype.MessageProduct;
import prototype.UnderlineProduct;

/**
 * @author maikec
 * @date 2019/5/11
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.register( new UnderlineProduct() );
        manager.register( new MessageProduct() );

        manager.create(  new UnderlineProduct()  ).use();
        manager.create(  new MessageProduct()  ).use();
    }
}
