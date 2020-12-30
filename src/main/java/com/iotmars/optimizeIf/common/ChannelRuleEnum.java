package com.iotmars.optimizeIf.common;

import com.iotmars.optimizeIf.GeneralChannelRule;
import com.iotmars.optimizeIf.TencentChannelRule;
import com.iotmars.optimizeIf.TouTiaoChannelRule;

/**
 * @author: xsh
 * @date: 2020/12/23 9:52
 */
public enum ChannelRuleEnum {
    /**
     * 头条
     */
    TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    /**
     * 腾讯
     */
    TENCENT("TENCENT",new TencentChannelRule());

    public String name;

    public GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }


    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }


    public static ChannelRuleEnum match(String name) {
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }



}
