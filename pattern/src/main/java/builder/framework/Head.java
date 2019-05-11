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
public class Head {
    private String name;
    public Head(){}
    public Head(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        super.toString();
        return name == null ? "Head" : name;
    }
}