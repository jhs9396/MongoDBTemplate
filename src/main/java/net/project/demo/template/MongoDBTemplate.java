package net.project.demo.template;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

/**
 * MongoDB multiple connection template
 * 
 * @author		HyeonSu Jeon
 * @version		0.2
 * @since		0.1
 */
public class MongoDBTemplate{
	
	/**
	 * MongoDB database name
	 */
	String database;
	
	/**
	 * MongoDB collection name
	 */
	String collections;
	
	/**
	 * MongoDB host address
	 */
	String host;
	
	/**
	 * MongoDB port number
	 */
	Integer port;
	
	/**
	 * MongoDB DataModel filename 
	 */
	Class<?> className;
	
	/**
	 * MongoDBClient 객체
	 */
	MongoClient client;
	
	/**
	 * MongoDB connection information factory
	 */
	SimpleMongoDbFactory factory;
	
	/**
	 * MongoTemplate 객체
	 */
	MongoTemplate template;
	
	/**
	 * MongoDBTemplate Constructor
	 * 
	 * @param host	MongoDB ip address
	 * @param port	MongoDB port
	 */
	@Autowired
	public MongoDBTemplate(@Value("${spring.data.mongodb.host}") String host, @Value("${spring.data.mongodb.port}") Integer port) {
		this.host = host;
		this.port = port;
		
		client = new MongoClient(this.host, this.port);
	}
	
	/**
	 * MongoDB Information Initialization Method
	 * 
	 * @param	className	MongoDB DataModel Filename
	 * @param	database	Database name
	 * @param	collections	Collections name
	 * @return	MongoDB 접속정보 세팅
	 */
	public void mongoDbInit(Class<?> className, String database, String collections) {
		this.className 		= className;
		this.database 		= database;
		this.collections 	= collections;
		
		factory 			= new SimpleMongoDbFactory(client, this.database);
		template 			= new MongoTemplate(factory);
	}

	/**
	 * MongoDB Data Insert method
	 * 
	 * @param	model	className에 해당하는 객체
	 * @return	not return. MongoDB 데이터 입력
	 */
	public void create(Object model) {
		template.insert(model);
	}

	/**
	 * MongoDB Data Update method
	 * 
	 * @param	model	className에 해당하는 객체
	 * @return	not return. MongoDB 데이터 수정
	 */
	public void update(Object model) {
		template.save(model);
	}

	/**
	 * MongoDB Data Delete method
	 * 
	 * @param	model	className에 해당하는 객체
	 * @return	not return. MongoDB 데이터 삭제
	 */
	public void delete(Object model) {
		template.remove(model);
	}

	/**
	 * MongoDB All data Delete Method
	 * 
	 * @param	model	className에 해당하는 객체
	 * @return	not return. MongoDB 데이터 전체 삭제
	 */
	public void deleteAll() {
		template.remove(new Query(), collections);
	}

	/**
	 * MongoDB(D-platform) Groups/Resources/Relations 정보 단건 조회 method
	 * 
	 * @param	cid	Groups/Resources/Relations primary key (not Object_ID)
	 * @return	className에 해당하는 Model return. document 단건 조회 결과 반환
	 */
	public Object findOne(String cid) {
		Query query = new Query(Criteria.where("_cid").is(cid));
		return template.findOne(query, className, collections);
	}
	
	/**
	 * MongoDB Customizing Query By BasicQuery
	 * 
	 * @param	query	BasicQuery 객체
	 * @return	조회된 DataModel List 형태로 반환
	 */
	public List<?> findByBasicQuery(BasicQuery query){
		return template.find(query, className, collections);
	}
	
	/**
	 * MongoDB Customizing Query By MongoQuery Object
	 * 
	 * @param	query	MongoDB Query Object
	 * @return	DataModel List 형태로 반환
	 */
	public List<?> findByQuery(Query query) {
		return template.find(query, className, collections); 
	}

	/**
	 * 전체 데이터 조회 method
	 *
	 * @return	전체 데이터 조회 후 List 형태로 반환
	 */
	public List<?> findAll() {
		return template.findAll(className, collections);
	}
	
	/**
	 * MongoDBTemplate DISTINCT method
	 * 
	 * @param	fieldName	조회 대상 field name
	 * @param	query		MongoDB Query 객체
	 * @return	사용자가 명시한 Object type list를 반환
	 */
	public List<?> distinct(String fieldName, Query query){
		return template.getCollection(collections).distinct(fieldName, query.getQueryObject());
	}
	
	/**
	 * MongoDBTemplate aggregate method
	 * match, group, sort 등 Operation option 사용 가능 
	 * 
	 * @param	options	AggregationOperation parameters이며, MongoTemplate에서 지원되는 operation 정부 사용 가능
	 * @return	AggreationResults 객체를 List로 변환하여 반환
	 */
	public List<JSONObject> aggregate(AggregationOperation... options){
		Aggregation agg = Aggregation.newAggregation(options).withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());
		return template.aggregate(agg,collections,JSONObject.class).getMappedResults();
	}
}
