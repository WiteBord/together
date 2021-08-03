package com.together.fencing.dto;

import lombok.Data;

@Data
public class FencingDto {
    /**
     *玩家
     */
    private String player;
    /**
     *对手
     */
    private String rival;
    /**
     *血量
     */
    private int hp;
    /**
     *行动
     */
    private String act;

}
