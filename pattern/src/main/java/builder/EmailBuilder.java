package builder;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import builder.framework.*;

/**
 * @author maikec
 * @date 2019/5/11
 */
public class EmailBuilder extends AbstractBuilder {
    @Override
    protected Head createHead() {
         head = new Head("Email Head");
         return head;
    }

    @Override
    protected Body createBody() {
        body = new Body("Email Body");
        return body;
    }

    @Override
    protected Author signature() {
        author =  new Author("maikec");
        return author;
    }

    @Override
    public Message getMessage() {
        return new Message( head,body,author );
    }
}
