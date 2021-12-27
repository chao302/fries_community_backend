package com.xinchao.fries_community_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinchao.fries_community_backend.model.dto.LoginDTO;
import com.xinchao.fries_community_backend.model.dto.RegisterDTO;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
import com.xinchao.fries_community_backend.model.vo.ProfileVO;


public interface IUmsUserService extends IService<UmsUser> {
    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
