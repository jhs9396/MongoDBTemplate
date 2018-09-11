package net.project.demo.model;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB THREAT_GR database/groups collections DTO
 * 
 * @author		HyeonSu Jeon
 * @version		0.2
 * @since		0.1
 */
@Document(collection = "groups")
public class GroupsModel {
	
	/**
	 * MongoDB Object ID
	 */
	@Id
	String _id;
	
	/**
	 * MongoDB Groups Document origin variable
	 */
	String origin;

	/**
	 * MongoDB Groups Document in_rs variable
	 */
	List<String> in_rs;
	
	/**
	 * MongoDB Groups Document in_rl variable
	 */
	List<String> in_rl;
	
	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * origin getter
	 * 
	 * @return	origin 반환
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * origin setter
	 * 
	 * @param	origin	MongoDB Groups origin
	 * @return	no return. origin 저장
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * in_rs getter
	 * 
	 * @return	Groups에 포함된 Resource List 반환
	 */
	public List<String> getIn_rs() {
		return in_rs;
	}
	
	/**
	 * in_rs setter
	 * 
	 * @param	in_rs	MongoDB Groups in_rs 
	 * @return	no return. in_rs ArrayList 저장
	 */
	public void setIn_rs(List<String> in_rs) {
		this.in_rs = in_rs;
	}
	
	/**
	 * in_rl getter
	 * 
	 * @return	Groups에 포함된 relation List 반환
	 */
	public List<String> getIn_rl() {
		return in_rl;
	}
	
	/**
	 * in_rl setter
	 * 
	 * @param	in_rl	MongoDB Groups in_rl
	 * @return	no return. in_rl 저장
	 */
	public void setIn_rl(List<String> in_rl) {
		this.in_rl = in_rl;
	}
	
	/**
	 * AgensGraph용 JSONObject 생성 method
	 * 
	 * @return	DTO variable to JSONObject(but, equal JSONObject. AgensGraph type JsonObject) 
	 * @throws JSONException 
	 */
	public JSONObject to_json() throws JSONException {
		JSONObject json = new JSONObject();
		
		if(this._id 	!= null)	json.put("_id", 	this._id);
		if(this.origin 	!= null) 	json.put("origin", 	this.origin);
		if(this.in_rs	!= null)	json.put("in_rs", 	this.in_rs);
		if(this.in_rl	!= null)	json.put("in_rl", 	this.in_rl);
		
		return json; 
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("_id : "+get_id()+", origin : "+getOrigin()+", In_rl : "+getIn_rl()+", In_rs : "+getIn_rs());
		return str.toString();
	}
}
