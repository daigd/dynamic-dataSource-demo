package com.warm.system.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.User;

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
public interface UserService extends IService<User> {
    List<User> getUserList();

    BigDecimal getOrderPriceByUserId(Integer userId);
}
