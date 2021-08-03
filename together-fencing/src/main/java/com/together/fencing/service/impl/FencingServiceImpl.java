package com.together.fencing.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.together.fencing.dto.FencingDto;
import com.together.fencing.service.FencingService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FencingServiceImpl implements FencingService {

    @Override
    public FencingDto actresult(FencingDto fencingDto){
        int hp=fencingDto.getHp();
        String act=fencingDto.getAct();
        String player= fencingDto.getPlayer();
        String rival =fencingDto.getRival();

        fencingDto.setHp(hp- 1);

        return fencingDto;
    }


}
