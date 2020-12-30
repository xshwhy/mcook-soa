package com.iotmars.es.repository;

import com.iotmars.es.po.MenuDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xsh
 * @date: 2020/12/28 9:44
 */
@Repository
public interface MenuRepository extends ElasticsearchRepository<MenuDO,Integer> {




}
