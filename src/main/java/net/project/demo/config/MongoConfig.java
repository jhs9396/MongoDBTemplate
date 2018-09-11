package net.project.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.project.demo.model.GroupsModel;
import net.project.demo.model.RelationsModel;
import net.project.demo.model.ResourcesModel;
import net.project.demo.template.MongoDBTemplate;

/**
 * MongoDB Multiple Connection Configuration
 * 
 * @author		HyeonSu Jeon
 * @version		0.2
 * @since		0.1
 */
@Configuration
public class MongoConfig {

	/**
	 * MongoDB host address
	 */
	@Value("${spring.data.mongodb.host}") String host;
	
	/**
	 * MongoDB port number
	 */
	@Value("${spring.data.mongodb.port}") Integer port;
    
	/**
	 * MongoDBTemplate Bean 객체 생성
	 * 여러 bean을 선언하여 다 수의 Database 접근 
	 * 
	 * @return	Init로 세팅한 database, collections을 가진 MongoDBTemplate 객체 반환
	 */
	@Bean(name="groupsTemplate")
	public MongoDBTemplate groupsTemplate(){
		MongoDBTemplate template = new MongoDBTemplate(host, port);
		template.mongoDbInit(GroupsModel.class, "GR", "groups");
		return template;
	}

	/**
	 * MongoDBTemplate Bean 객체 생성
	 * 여러 bean을 선언하여 다 수의 Database 접근 
	 * 
	 * @return	Init로 세팅한 database, collections을 가진 MongoDBTemplate 객체 반환
	 */
	@Bean(name="resourcesTemplate")
	public MongoDBTemplate resourcesTemplate(){
		MongoDBTemplate template = new MongoDBTemplate(host, port);
		template.mongoDbInit(ResourcesModel.class, "RS", "resources");
		return template;
	}
	
	/**
	 * MongoDBTemplate Bean 객체 생성
	 * 여러 bean을 선언하여 다 수의 Database 접근 
	 * 
	 * @return	Init로 세팅한 database, collections을 가진 MongoDBTemplate 객체 반환
	 */
	@Bean(name="relationsTemplate")
	public MongoDBTemplate relationsTemplate(){
		MongoDBTemplate template = new MongoDBTemplate(host, port);
		template.mongoDbInit(RelationsModel.class, "RL", "relations");
		return template;
	}
 
	/** 다른 DB 접근 필요 시 Model, Bean 생성하여 사용 가능 **/
}
