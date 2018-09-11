package net.project.demo.model;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB THREAT_RL database/relations collections DTO
 * 
 * @author		HyeonSu Jeon
 * @version		0.2
 * @since		0.1
 */
@Document(collection = "relations")
public class RelationsModel {
	/**
	 * MongoDB Object ID
	 */
	@Id
	private String _id;
	
	/**
	 * MongoDB Relations source id
	 */
	private String tid1;
	
	/**
	 * MongoDB Relations target id
	 */
	private String tid2;
	
	/**
	 * MongoDB Relations type
	 */
	private String rtype;
	
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
	public String getTid1() {
		return tid1;
	}
	public void setTid1(String tid1) {
		this.tid1 = tid1;
	}
	public String getTid2() {
		return tid2;
	}
	public void setTid2(String tid2) {
		this.tid2 = tid2;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	
	/** variable getter/setter end **/
	
	
	/**
	 * For AgensGraph JSONObject create method 
	 * 
	 * @return	JSONObject return. but not JSONObject. This is net.bitnine.agensgraph.graph.property.JsonObject
	 * @throws JSONException 
	 */
	public JSONObject to_json() throws JSONException {
		JSONObject json = new JSONObject();
		if(this._id != null) 	json.put("cid", 	this._id);
		if(this.tid1 != null)	json.put("tid1", 	this.tid1);
		if(this.tid2 != null)	json.put("tid2", 	this.tid2);
		if(this.rtype != null) 	json.put("rtype", 	this.rtype);
		
		return json; 
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("_id : "+get_id()+", tid1 : "+getTid1()+", tid2 : "+getTid2()+", rtype : "+getRtype());
		return str.toString();
	}
}
