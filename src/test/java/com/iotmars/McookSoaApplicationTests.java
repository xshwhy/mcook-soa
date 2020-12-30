package com.iotmars;

import com.alibaba.fastjson.JSON;
import com.iotmars.es.po.MenuDO;
import com.iotmars.es.po.MenuDTO;
import com.iotmars.es.po.User;
import com.iotmars.es.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class McookSoaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;


    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    void createIndexTest() throws IOException {
        // 1 创建索引
        CreateIndexRequest request = new CreateIndexRequest("kuang_index1");
        // 客户端执行请求
        CreateIndexResponse createIndexResponse = client
                .indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @Test
    void existIndexTest() throws IOException {
        // 1 创建索引
        GetIndexRequest request = new GetIndexRequest("kuang_index2");
        // 客户端执行请求
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    void deleteIndexTest() throws IOException {
        // 1 创建索引
        DeleteIndexRequest request = new DeleteIndexRequest("kuang_index1");
        // 客户端执行请求
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    /**
     * 添加文档
     */
    @Test
    void addDocumentTest() throws IOException {
        // 创建对象
        User user = new User("狂战",3);
        // 创建请求
        IndexRequest request = new IndexRequest("kuang_index");

        // 规则 put /kuangshen_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        // 将我们的数据放入请求 json
        request.source(JSON.toJSONString(user), XContentType.JSON);

        // 客户端发送请求,获取响应的结果
        IndexResponse index = client.index(request, RequestOptions.DEFAULT);

        System.out.println(index.toString());
        System.out.println(index.status());
    }

    @Test
    void existDocumentTest() {
        GetRequest getRequest = new GetRequest("kuang_index", "1");
        try {
            if (client.exists(getRequest, RequestOptions.DEFAULT)) {
                GetResponse documentFields = client.get(getRequest, RequestOptions.DEFAULT);
                log.info(documentFields.getSourceAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateDocumentTest() {
        UpdateRequest updateRequest = new UpdateRequest("kuang_index", "1");
        updateRequest.timeout("1s");

        User user = new User("张三", 22);
        updateRequest.doc(JSON.toJSONString(user),XContentType.JSON);

        try {
            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
            log.info(String.valueOf(updateResponse.status()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteDocumentTest() {
        DeleteRequest deleteRequest = new DeleteRequest("kuang_index", "1");
        try {
            DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
            log.info(String.valueOf(deleteResponse.status()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void addRequestListTest(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Jnoh",12));
        users.add(new User("Jerry",23));
        users.add(new User("Tom",41));
        users.add(new User("Mike",21));
        users.add(new User("Li",18));

        BulkRequest bulkRequest = new BulkRequest();
        for (User user : users) {
            bulkRequest.add(
                    new IndexRequest("index_1")
                            .source(JSON.toJSONString(user),XContentType.JSON));
        }
        try {
            BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            log.info(String.valueOf(bulkResponse.status()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void searchTest(){

        SearchRequest searchRequest = new SearchRequest("index_1");
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.termQuery("age","18"))
                .from(0)
                .size(1)
                .timeout(new TimeValue(60, TimeUnit.SECONDS)));
        try {
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            log.info(JSON.toJSONString(searchResponse.getHits()));
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                log.info(String.valueOf(hit.getSourceAsMap()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private MenuRepository menuRepository;


    @Test
    void searchTest1(){
        Iterable<MenuDO> search = menuRepository.search(QueryBuilders.termQuery("name", "香"));
        search.forEach(System.out::println);


    }

    @Test
    void createIndex(){
        restTemplate.createIndex(MenuDTO.class);


    }



}
