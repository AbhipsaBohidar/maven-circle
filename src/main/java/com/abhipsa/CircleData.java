package com.abhipsa;

import java.util.ArrayList;
import java.util.List;

public class CircleData {

	List<CircleStructure> circleDatabase = new ArrayList<CircleStructure>() {
	    {
	        add(new CircleStructure(1, "abc1"));
	        add(new CircleStructure(2, "abc2"));
	        add(new CircleStructure(3, "abc3"));
	        add(new CircleStructure(4, "abc4"));
	        add(new CircleStructure(5, "abc5"));
	    }
        };
	
	public List<CircleStructure> listCircleData(){
		return circleDatabase;
	}
	
	
}
