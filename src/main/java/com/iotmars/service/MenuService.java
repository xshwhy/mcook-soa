package com.iotmars.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iotmars.dto.FlDTO;
import com.iotmars.es.po.MenuDO;
import com.iotmars.es.repository.MenuRepository;
import com.iotmars.mapper.MenuMapper;
import com.iotmars.po.Menu;
import com.iotmars.utils.Result;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xsh
 * @date: 2020/12/25 17:37
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    /**
     * 同步es
     */
    public void findMenuInPublish() {
        // 查询处于发布状态的菜谱
        List<Menu> menus = menuMapper.selectList(new QueryWrapper<Menu>().eq("publish_status", 2));
        List<MenuDO> menuEs = new ArrayList<>();
        // 同步es和mysql
        menus.forEach(menu -> {
            Integer menuId = menu.getId();
            String menuName = menu.getName();
            String description = menu.getDescription();
            String fl = menu.getFl();
            // 食材清单
            List<FlDTO> fls = JSONObject.parseArray(fl, FlDTO.class);
            StringBuffer sb = new StringBuffer();
            fls.forEach(f -> sb.append(f.getName() + ""));
            MenuDO menuDO = new MenuDO()
                    .setId(menuId).setName(menuName)
                    .setDescription(description).setTags(sb.toString());
            menuEs.add(menuDO);
        });
        menuRepository.saveAll(menuEs);
    }

    /**
     * 搜索es
     * @return
     */
    public Result searchMenu(String keyWord,Integer page,Integer pageSize) {
        // 构造查询条件

        // 添加基本的分词查询
//        MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyWord, "name").type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
        // 分页
//        queryBuilder.withPageable(PageRequest.of(page, pageSize));
        // 排序
//        queryBuilder.withSort(SortBuilders.fieldSort())
//        Iterable<MenuDO> search = menuRepository.search(queryBuilder);
        // 查询条件
        MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyWord, "name", "tags")
                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
        // 添加权重
        queryBuilder.field("name",1.2f);
        queryBuilder.field("tags",0.5f);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(PageRequest.of(page-1, pageSize))
                .build();
        Page<MenuDO> search = menuRepository.search(searchQuery);
        List<MenuDO> content = search.getContent();
        return new Result().isExist(content);
    }







}
