package com.together.wxlogin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.together.wxlogin.dao.PlayersDao;
import com.together.wxlogin.dto.WxLoginDto;
import com.together.wxlogin.dto.WxResultDto;
import com.together.wxlogin.entity.Players;

/**
 * 接口，实现在impl
 */
public interface PlayersService extends IService<Players> {

    WxResultDto wxlogin(WxLoginDto wxLoginDto);
}
