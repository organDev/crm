package singleton;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 懒汉模式
 * @author maikec
 * @date 2019/5/11
 */
public final class SingletonLazy {
    private static SingletonLazy singletonLazy;
    private SingletonLazy(){}
    public static SingletonLazy getInstance(){
        if (null == singletonLazy){
            ReentrantReadWriteLock.WriteLock lock = new ReentrantReadWriteLock().writeLock();
            try {
                if (lock.tryLock()){
                    if (null == singletonLazy){
                        singletonLazy = new SingletonLazy();
                    }
                }
            }finally {
                lock.unlock();
            }

//            synchronized (SingletonLazy.class){
//                if (null == singletonLazy){
//                    singletonLazy = new SingletonLazy();
//                }
//            }
        }
        return singletonLazy;
    }
}
