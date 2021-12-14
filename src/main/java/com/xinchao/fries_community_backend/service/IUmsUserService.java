package com.xinchao.fries_community_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinchao.fries_community_backend.model.dto.RegisterDTO;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.service.impl
 * @ClassName : IUmsUserService.java
 * @createTime : 2021/12/14 15:02
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public interface IUmsUserService extends IService<UmsUser> {
    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);
}
