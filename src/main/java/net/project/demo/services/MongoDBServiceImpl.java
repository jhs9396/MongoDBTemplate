package net.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.project.demo.model.GroupsModel;
import net.project.demo.model.RelationsModel;
import net.project.demo.model.ResourcesModel;
import net.project.demo.template.MongoDBTemplate;

@Service
public class MongoDBServiceImpl implements MongoDBService{
	
	@Autowired
	@Qualifier("groupsTemplate")
	MongoDBTemplate groupsTemplate;
	
	@Autowired
	@Qualifier("resourcesTemplate")
	MongoDBTemplate resourcesTemplate;
	
	@Autowired
	@Qualifier("relationsTemplate")
	MongoDBTemplate relationsTemplate;
	
	@Override
	public void test() {
		GroupsModel     groups      = new GroupsModel();
		ResourcesModel  resources1  = new ResourcesModel();
		ResourcesModel  resources2  = new ResourcesModel();
		RelationsModel  relations   = new RelationsModel();
		
		resources1.setType_lv1("type1");
		resources1.setType_lv2("type2");
		resources1.setType_lv3("type3");
		resources1.setValue("resources1 value");
		
		resources2.setType_lv1("type1");
		resources2.setType_lv2("type2");
		resources2.setType_lv3("type3");
		resources2.setValue("resources2 value");
		
		resourcesTemplate.create(resources1);
		resourcesTemplate.create(resources2);
		
		// update source as soon as possible 
	}

}
