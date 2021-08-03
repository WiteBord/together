package com.together.fencing.controller;
import com.common.utils.R;
import com.together.fencing.dto.FencingDto;
import com.together.fencing.service.FencingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FencingController {
    @Autowired
    FencingService fencingService;

    @PostMapping("fencing")
    public R fencing(@RequestBody FencingDto fencingDto) {
        FencingDto actresult=fencingService.actresult(fencingDto);
        return R.ok().put("data",actresult);

    }


}
