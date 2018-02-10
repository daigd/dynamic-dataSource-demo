package com.warm.system.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface OrderService extends IService<Order> {
    List<Order> getOrderList();
    BigDecimal getOrderPriceByUserId(Integer userId);
}
