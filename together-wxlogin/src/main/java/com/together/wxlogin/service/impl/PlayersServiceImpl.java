package com.together.wxlogin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.together.wxlogin.dao.PlayersDao;
import com.together.wxlogin.dto.WxLoginDto;
import com.together.wxlogin.dto.WxResultDto;
import com.together.wxlogin.entity.Players;
import com.together.wxlogin.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * 接口实现
 */
@Service
public class PlayersServiceImpl extends ServiceImpl<PlayersDao, Players> implements PlayersService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WxResultDto wxlogin(WxLoginDto wxLoginDto) {
        HashMap<String, String> map = new HashMap<>(4);
        map.put("appid",wxLoginDto.getAppid());
        map.put("secret",wxLoginDto.getSecret());
        map.put("js_code",wxLoginDto.getJsCode());
        map.put("grant_type",wxLoginDto.getGrantType());
        ResponseEntity<WxResultDto> entity = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session", WxResultDto.class, map);
        return entity.getBody();
    }
}
