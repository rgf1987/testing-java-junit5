package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model{
	
	Map<String, Object> map = new HashMap<>();

	@Override
	public void addAttribute(String key, Object o) {
		// TODO Auto-generated method stub
		map.put(key, o);
	}

	@Override
	public void addAttribute(Object o) {
		//do nothing		
	}
	
	public Map getMap() {
		return map;
	}

}
