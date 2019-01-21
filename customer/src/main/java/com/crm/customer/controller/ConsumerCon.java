package com.crm.customer.controller;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.customer.pojo.vo.ConsumerVO;
import org.springframework.stereotype.Controller;

/**
 * 客户管理
 * @author maikec
 * @date 2019/1/21
 */
@Controller
public interface ConsumerCon<VO extends ConsumerVO> {

    /**
     * 新增用户
     * @param consumerVO
     * @return
     */
    int insert(VO consumerVO);
}
