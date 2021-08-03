package com.together.wxlogin.controller;

import com.common.utils.R;
import com.together.wxlogin.dto.WxLoginDto;
import com.together.wxlogin.dto.WxResultDto;
import com.together.wxlogin.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    @PostMapping("/wxLogin")
    public R wxLogin(@RequestBody WxLoginDto wxLoginDto){
        WxResultDto wxlogin = playersService.wxlogin(wxLoginDto);
        return R.ok().put("data",wxlogin);
    }
}
