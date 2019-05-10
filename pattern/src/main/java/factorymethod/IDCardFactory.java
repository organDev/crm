package factorymethod;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import factorymethod.framework.AbstractFactory;
import factorymethod.framework.AbstractProduct;

import java.util.LinkedList;
import java.util.List;

/**
 * @author maikec
 * @date 2019/5/10
 */
public class IDCardFactory extends AbstractFactory {
    private final List<IDCard> idCards = new LinkedList<>(  );
    @Override
    protected AbstractProduct createProduct(String owner) {
        if (null == owner){
            throw new IllegalArgumentException( "owner cannot be null" );
        }
        return new IDCard( owner );
    }

    @Override
    protected void registerProduct(AbstractProduct product) {
        if (!(product instanceof IDCard)){
            throw new IllegalArgumentException( "product should be IDCard instance" );
        }
        idCards.add( (IDCard) product );
    }
}
