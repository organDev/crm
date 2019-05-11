package builder.framework;
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
 * @date 2019/5/11
 */
public abstract class AbstractBuilder {
    protected Message message;
    protected Head head;
    protected Body body;
    protected Author author;
    /**
     * 创建消息头部
     * @return
     */
    protected abstract Head createHead();

    /**
     * 创建消息体
     * @return
     */
    protected abstract Body createBody();

    /**
     * 署名
     * @return
     */
    protected abstract Author signature();

    public Message getMessage(){
        return message;
    }
}
