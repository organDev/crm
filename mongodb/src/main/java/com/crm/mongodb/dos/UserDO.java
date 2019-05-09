package com.crm.mongodb.dos;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 *
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 用户信息领域对象
 * @author maikec
 * @date 2019/4/29
 */
@Data
@Document
public class UserDO implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;

}
