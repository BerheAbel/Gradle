package api;

import java.util.Iterator;

import org.json.JSONObject;
public class ParseDynamicJosn {
	
	public static void parseObject(JSONObject json, String key) {
		System.out.println(json.has(key));
		//System.out.println(json.get(key));
	}
	public static void getkey(JSONObject josn, String key) {
		boolean exist=josn.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		if (!exist) {
			parseObject(josn, key);
		}
		else{parseObject(josn, key);}
	}
	
	public static void main(String[] args) {
		
		String inputJson="{\n"
				+ "  \"claim_loss_type_cd\":\"TEL\",\n"
				+ "  \"claim_type\":\"002\",\n"
				+ "  \"claim_reason\":\"001\",\n"
				+ "  \"info\":{\n"
				+ "    \"applicationContext\":{\n"
				+ "      \"country\":\"US\"\n"
				+ "    }\n"
				+ "  }\n"
				+ "}";
		
		JSONObject inputjsonobject = new JSONObject(inputJson);
		getkey(inputjsonobject, "country");
	}

}
