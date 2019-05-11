/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 * @author maikec
 * @date 2019/5/11
 */

/**
 * 原型模式
 * 1、浅克隆（shallow clone），浅拷贝是指拷贝对象时仅仅拷贝对象本身和对象中的基本变量，而不拷贝对象包含的引用指向的对象。
 * (如：对象A1中包含对B1的引用，B1中包含对C1的引用。浅拷贝A1得到A2，A2中依然包含对B1的引用，
 * B1中依然包含对C1的引用。深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2中包含对C2（C1的copy）的引用)
 * 2、深克隆（deep clone），深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象
 * （需要重新clone方法.如：
 * @Override
 *     protected Object clone() throws CloneNotSupportedException {
 *         Husband husband = (Husband) super.clone();
 *         husband.wife = (Wife) husband.getWife().clone();
 *         return husband;
 *     }
 * ）
 * @author maikec
 * @date 2019/5/11
 */
package prototype;