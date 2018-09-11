package net.project.demo.model;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB THREAT_RS database/resources collections DTO
 * 
 * @author		HyeonSu Jeon
 * @version		0.2
 * @since		0.1
 */
@Document(collection = "resources")
public class ResourcesModel {
	
	/**
	 * MongoDB Object ID
	 */
	@Id
	private String _id;
	
	/**
	 * MongoDB value variable
	 */
	private String value;
	
	/**
	 * MongoDB type_lv1 variable
	 */
	private String type_lv1;
	
	/**
	 * MongoDB type_lv2 variable
	 */
	private String type_lv2;
	
	/**
	 * MongoDB type_lv3 variable
	 */
	private String type_lv3;
	
	/**
	 * variable getter/setter start
	 * No use lombok. (1. Unknown error prevent. 2. Eclipse is very easy to create constructors and getters/setters.)
	 *  
	 */
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType_lv1() {
		if(type_lv1 == null) type_lv1="";
		return type_lv1;
	}
	public void setType_lv1(String type_lv1) {
		this.type_lv1 = type_lv1;
	}
	public String getType_lv2() {
		if(type_lv2 == null) type_lv2="";
		return type_lv2;
	}
	public void setType_lv2(String type_lv2) {
		this.type_lv2 = type_lv2;
	}
	public String getType_lv3() {
		if(type_lv3 == null) type_lv3="";
		return type_lv3;
	}
	public void setType_lv3(String type_lv3) {
		this.type_lv3 = type_lv3;
	}
	
	/** variable getter/setter end **/
	
	/**
	 * For JSONObject create method 
	 * 
	 * @return	JSONObject return.
	 * @throws JSONException 
	 */
	public JSONObject to_json() throws JSONException {
		JSONObject json = new JSONObject();
		if(this._id 		!= null) 	json.put("cid", 		this._id);
		if(this.value 		!= null) 	json.put("value", 		this.value);
		if(this.type_lv1 	!= null) 	json.put("type_lv1", 	this.type_lv1);
		if(this.type_lv2 	!= null) 	json.put("type_lv2", 	this.type_lv2);
		if(this.type_lv3 	!= null) 	json.put("type_lv3", 	this.type_lv3);
		
		return json; 
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("_id : "+get_id()+", value : "+getValue()+", type_lv1 : "+getType_lv1()+", type_lv2 : "+getType_lv2()+", type_lv3 : "+getType_lv3());
		return str.toString();
	}
}
