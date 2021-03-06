 /**
 * 文件名称：
 * 版权所有：Copyright gesoft
 * 创建时间：2017-06-28 11:58:20
 * 创 建 人：WCL (ln_admin@yeah.net)
 * 功能描述：
 **/
package com.gesoft.dao;

import org.springframework.stereotype.Repository;

import com.gesoft.common.EntityDAOImpl;
import com.gesoft.model.OrderModel;


@Repository
public class OrderDAO extends EntityDAOImpl<OrderModel, Long>
{
	@Override
    public String getMybatisSqlMapNamespace()
    {
        return "OrderMapper";
    }
}
