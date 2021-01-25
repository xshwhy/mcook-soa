package com.iotmars.po;

import com.iotmars.annotation.Check;
import lombok.Data;

/**
 * @author: xsh
 * @date: 2021/1/25 14:34
 */
@Data
public class UserPO {

    /**
     * 姓名
     * */
    private String name;

    /**
     * 性别 man or women
     * */
    @Check(paramValues = {"man", "woman"})
    private String sex;


}
