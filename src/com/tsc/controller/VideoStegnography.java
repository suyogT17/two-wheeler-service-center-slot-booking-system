package com.tsc.controller;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class VideoStegnography {

	public static String ffmpegpath="C:/Users/Suyog/Downloads/ffmpeg-20171123-a60b242-win64-static/ffmpeg-20171123-a60b242-win64-static/bin/ffmpeg -i ";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String videopath="H:/output24input1.mp4";
		System.out.println(videopath);
		int lastId=videopath.lastIndexOf("/");
    	String imagespath=videopath.substring(0, lastId);
/*    	if(!new File(imagespath+"/images").exists()){
    	new File(imagespath+"/images").mkdir();
    	}
    	if(!new File(imagespath+"/output").exists()){
		new File(imagespath+"/output").mkdir();
    	}
    	if(!new File(imagespath+"/music").exists()){
		new File(imagespath+"/music").mkdir();
    	}
*/    	
		try {
			//videoToImageEncode(videopath,"my name is suyogT i am studing bachelors at spit");
			decodeText(videopath);
			System.out.println("complete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
/*		try {
			decodeText("H:/output21input2.mp4");
			System.out.println("complete");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	}
	
	public static void videoToImageEncode(String videopath,String message) throws Exception{
		int lastId=videopath.lastIndexOf("/");
    	String imagespath=videopath.substring(0, lastId);
		videoToImages(videopath,imagespath);
		System.out.println("videoToimage complete");
		//Stegno steg=new Stegno();
		//steg.encode(imagespath+"/images", "image12", "png", "image12", message);
		System.out.println("data encoded");
		getAudio(videopath,imagespath);
	}
	
	@SuppressWarnings("static-access")
	public static void videoToImages(String videopath,String imagespath) throws IOException, InterruptedException {
		
		System.out.println("videoToImages()");
    	
		String videotoimg = ffmpegpath
    			+ videopath + " -vf fps=25 " + imagespath+"/images" + "/image%d.png";
    	System.out.println(videotoimg);
    	
    	Process p=Runtime.getRuntime().exec(videotoimg);
    	System.out.println("before exitting");
    	//Thread.currentThread().sleep(70000);      // 10 milliseconds
    	
    	//p.waitFor();
    	
        //p.destroyForcibly();
		
	}
	
	public static void getAudio(String videopath,String imagespath) throws IOException, InterruptedException{
    	System.out.println("getAudio()");
    	
    	//num=(int)(Math.random()*50+1);
      	int num=24;
    	String getaudio=ffmpegpath+ videopath +" -f mp3 -ab 192000 -vn "+imagespath+"/music/music"+num+".mp3";
    	System.out.println(getaudio);
    	Process p=Runtime.getRuntime().exec(getaudio);
    	/*p.waitFor();    
        p.destroy();*/
        System.out.println("p.destroy()");
    	
    }

	public static void videoFromImages(String videopath, String imagespath,int num) throws IOException, InterruptedException {

		System.out.println("videoFromImages()");
	    
    	String imgtovideo = ffmpegpath
    	        + imagespath+"/images" + "/image%d.png -c:v ffv1 -qscale:v 0 " + imagespath+"/output/" +"output1"+num+".avi";
    	System.out.println(imgtovideo);
    	Process p=Runtime.getRuntime().exec(imgtovideo);
    	
    	//p.waitFor();    
    	//String name=addAudio(videopath, num);
		
	}

	public static String addAudio(String videopath, int number) throws IOException {

		System.out.println("addAudio()");
    	int lastId=videopath.lastIndexOf("/");
    	String imagespath=videopath.substring(0, lastId);
    	String finalvideoname=videopath.substring(lastId+1);
    	
    	String imgvideoaudio= ffmpegpath+ imagespath+"/output/" +"output1"+number+".avi" + " -i "+ imagespath+"/music/music"+number+".mp3" + " -codec copy -shortest " + imagespath+"/output"+number+finalvideoname;
		System.out.println(imgvideoaudio);
    	try {
			Process p=Runtime.getRuntime().exec(imgvideoaudio);  	
			//p.waitFor();   
    		FileUtils.forceDelete(new File(imagespath+"/images"));
			 
    	}
    	catch(Exception e){
    		
    		System.out.println("Exception occured");
    		FileUtils.forceDelete(new File(imagespath+"/images"));
    	}
    	return "output"+number+finalvideoname;
    	
	}
	
	
	
	public static String decodeText(String videopath) throws IOException, InterruptedException{
		int lastId=videopath.lastIndexOf("/");
    	String imagespath=videopath.substring(0, lastId);
    	String videoname=videopath.substring(lastId+1);
		System.out.println("in decodetext()");
		new File(imagespath+"/images").mkdir();
		new File(imagespath+"/nosound").mkdir();
		if(removeAudio(videopath,imagespath,videoname)) {
		videoToImages(imagespath+"/nosound/nosound"+videoname, imagespath);
		}
		Stegno stegno=new Stegno();
		String decoded=stegno.decode(imagespath+"/images", "image1");
		if(!decoded.equals(null)){
			System.out.println(decoded);
		}
		FileUtils.forceDelete(new File(imagespath+"/images"));
		System.out.println("decoding successfull");
		return decoded;
		
		
	}
	
	public static boolean removeAudio(String videopath,String imagespath,String videoname) throws IOException, InterruptedException{
				

		System.out.println("in removeAudio()");
		String remove=ffmpegpath+videopath+" -c copy -an "+imagespath+"/nosound/nosound"+videoname;
		System.out.println(remove);
		Process p=Runtime.getRuntime().exec(remove);  	
		p.waitFor();
		p.destroyForcibly();
		System.out.println("after waitfor");
		return true;	
		
	}

}

