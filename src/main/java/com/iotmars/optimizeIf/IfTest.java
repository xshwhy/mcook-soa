package com.iotmars.optimizeIf;

import com.iotmars.optimizeIf.common.ChannelRuleEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: xsh
 * @date: 2020/12/23 9:53
 */
public class IfTest {

    public static void main(String[] args) {
       /* //这里我们模拟接收到的数据，其渠道为为TOUTIAO，来自头条的数据
        String sign = "TOUTIAO";
        GeneralChannelRule rule = null;
        //根据对应渠道获取对应的具体规则实现类
        if (ChannelRuleEnum.TENCENT.name.equals(sign)) {
            rule = new TencentChannelRule();
        } else if (ChannelRuleEnum.TOUTIAO.name.equals(sign)) {
            rule = new TouTiaoChannelRule();
        } else {
            //匹配不到
        }
        //执行
        rule.process();*/

        String sign = "TOUTIAO";
        ChannelRuleEnum channelRule = ChannelRuleEnum.match(sign);
        GeneralChannelRule rule = channelRule.getChannel();
        rule.process();

        List<String> list = Arrays.asList("a", "b", null, null);
        List<String> list2 = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(list2);


        int a = 1;
        Integer b = 1;
        System.out.println(a ==b);

    }






}
