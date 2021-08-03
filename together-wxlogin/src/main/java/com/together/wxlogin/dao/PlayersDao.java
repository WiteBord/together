package com.together.wxlogin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.together.wxlogin.entity.Players;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayersDao extends BaseMapper<Players> {
}
