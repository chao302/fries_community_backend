package com.xinchao.fries_community_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinchao.fries_community_backend.mapper.BmsBillboardMapper;
import com.xinchao.fries_community_backend.model.entity.BmsBillboard;
import com.xinchao.fries_community_backend.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.service.impl
 * @ClassName : IBmsBillboardServiceImpl.java
 * @createTime : 2021/12/12 17:51
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper
        , BmsBillboard> implements IBmsBillboardService {
}
