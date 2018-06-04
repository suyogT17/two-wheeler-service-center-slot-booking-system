package com.tsc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExController {

	String videopath,imagespath;
	
	@RequestMapping(value="/get.html",method=RequestMethod.GET)
	public String getview() {
		
		return "stegno";
	}
	
	
	@RequestMapping(value="/next.html",method=RequestMethod.GET)
	public String getnext() {
	
		videopath="H:/input1.mp4";
		System.out.println(videopath);
		int lastId=videopath.lastIndexOf("/");
    	imagespath=videopath.substring(0, lastId);
    	if(!new File(imagespath+"/images").exists()){
    	new File(imagespath+"/images").mkdir();
    	}
    	if(!new File(imagespath+"/output").exists()){
		new File(imagespath+"/output").mkdir();
    	}
    	if(!new File(imagespath+"/music").exists()){
		new File(imagespath+"/music").mkdir();
    	}
    	
		try {
			VideoStegnography.videoToImageEncode(videopath,"my name is suyogT i am studing bachelors at spit");
			System.out.println("complete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "next";
	}
	
	
	@RequestMapping(value="/encode.html",method=RequestMethod.GET)
	public String next2() throws Exception {
		
		Stegno steg=new Stegno();
		steg.encode(imagespath+"/images", "image1", "png", "image1", "my name is suyogT i am studing bachelors at spit");
		return "next2";
	}
	
	@RequestMapping(value="/envideo.html",method=RequestMethod.GET)
	public String envideo() throws Exception {
		
		VideoStegnography.videoFromImages(videopath, imagespath, 24);
		return "next3";
	}
	
	
	@RequestMapping(value="/addaudio.html",method=RequestMethod.GET)
	public String addvideo() throws Exception {
		
		VideoStegnography.addAudio(videopath, 24);
		return "next4";
	}
	
	
	
	
	
	
}
