# 必须编写单元测试
对于数据库相关的查询，更新，删除等操作，
不能假设数据库里的数据是存在的，或者直接操作数据库把数据插入进去，请使用程序插入或者导入数据的方式来准备数据。


# 编码规约
DO（Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。
DTO（Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象
VO（View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象
# 推荐
给JVM设置-XX:+HeapDumpOnOutOfMemoryError参数，让JVM碰到OOM场景时输出dump信息
# MySQL
Table 11.1 Required Storage and Range for Integer Types Supported by MySQL

Type	 Storage (Bytes)	Minimum Value Signed	Minimum Value Unsigned	Maximum Value Signed	Maximum Value Unsigned
TINYINT	     1	                -128	                  0	                        127	                    255
SMALLINT	 2	                -32768                    0	                    32767	                65535
MEDIUMINT	 3	                -8388608	               0	                    8388607	                16777215
INT	         4	                -2147483648	               0	                    2147483647	            4294967295
BIGINT	     8	                -2^63	                   0	                    2^63-1	                 2^64-1
# 索引
业务上具有唯一特性的字段，即使是多个字段的组合，也必须建成唯一索引。 
说明：不要以为唯一索引影响了insert速度，这个速度损耗可以忽略，但提高查找速度是明显的；
另外，即使在应用层做了非常完善的校验控制，只要没有唯一索引，根据墨菲定律，必然有脏数据产生

超过三个表禁止join。
需要join的字段，数据类型必须绝对一致；多表关联查询时，保证被关联的字段需要有索引。 说明：即使双表join也要注意表索引、SQL性能

在varchar字段上建立索引时，必须指定索引长度，没必要对全字段建立索引，根据实际文本区分度决定索引长度即可
# 安全规约
隶属于用户个人的页面或者功能必须进行权限控制校验。 
说明：防止没有做水平权限校验就可随意访问、修改、删除别人的数据，比如查看他人的私信内容、修改他人的订单