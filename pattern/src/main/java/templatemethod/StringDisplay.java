package templatemethod;
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
 * @date 2019/5/10
 */
public class StringDisplay extends AbstractDisplay {
    private final String string ;
    public StringDisplay(String string){
        if (null == string){
            throw new IllegalArgumentException( "String cannot be null" );
        }
        this.string = string;
    }
    @Override
    protected void open() {
        System.out.println( "Open String" );
    }

    @Override
    protected void print() {
        System.out.println( string );
    }

    @Override
    protected void close() {
        System.out.println( "Close String" );
    }
}
