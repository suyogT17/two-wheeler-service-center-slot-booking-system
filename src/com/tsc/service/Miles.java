package com.tsc.service;

import java.util.Comparator;

import com.tsc.model.Distance;

public class Miles implements Comparator<Distance> {
	
	@Override
	public int compare(Distance d1,Distance d2)
	{
		return Double.compare(d1.getMiles(),d2.getMiles());
	}

}
