package com.tsc.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;



public class Stegno
{
	public Stegno()
	{
	}
	
	public boolean encode(String path, String original, String ext1, String stegan, String message) throws Exception
	{
		//String message=readFile(iopath);
		String			file_name 	= image_path(path,original,ext1);
		BufferedImage 	image_orig	= getImage(file_name);
		
		BufferedImage image = user_space(image_orig);
		image = add_text(image,message);
		
		return(setImage(image,new File(image_path(path,stegan,"png")),"png"));
	}
	
	
	public String decode(String path, String name)
	{
		byte[] decode;
		try
		{
			BufferedImage image  = user_space(getImage(image_path(path,name,"png")));
			decode = decode_text(get_byte_data(image));
			return(new String(decode));
		}
        catch(Exception e)
        {
			
				 System.out.println("There is no hidden message in this image!");
			return "";
        }
    }
    
	
	private String image_path(String path, String name, String ext)
	{
		return path + "/" + name + "." + ext;
	}
	
	
	private BufferedImage getImage(String f)
	{
		BufferedImage 	image	= null;
		File 		file 	= new File(f);
		
		try
		{
			image = ImageIO.read(file);
		}
		catch(Exception ex)
		
		{
			
				System.out.println("Image could not be read!");
		}
		return image;
	}
	
	private boolean setImage(BufferedImage image, File file, String ext)
	{
		try
		{
			file.delete(); //delete resources used by the File
			ImageIO.write(image,ext,file);
			return true;
		}
		catch(Exception e)
		{
			
				System.out.println("File could not be saved!");
			return false;
		}
	}
	

	private BufferedImage add_text(BufferedImage image, String text)
	{
	
		byte img[]  = get_byte_data(image);
		byte msg[] = text.getBytes();
		byte len[]   = bit_conversion(msg.length);
		try
		{
			encode_text(img, len,  0); 
			encode_text(img, msg, 32); 
		}
		catch(Exception e)
		{
			
			System.out.println("Target File cannot hold message!");
		}
		return image;
	}
	
	private BufferedImage user_space(BufferedImage image)
	{
		
		BufferedImage new_img  = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D    graphics = new_img.createGraphics();
		graphics.drawRenderedImage(image, null);
		graphics.dispose();
		return new_img;
	}
	

	private byte[] get_byte_data(BufferedImage image)
	{
		WritableRaster raster   = image.getRaster();
		DataBufferByte buffer = (DataBufferByte)raster.getDataBuffer();
		return buffer.getData();
	}

	private byte[] bit_conversion(int i)
	{
		byte byte3 = (byte)((i & 0xFF000000) >>> 24); //0
		byte byte2 = (byte)((i & 0x00FF0000) >>> 16); //0
		byte byte1 = (byte)((i & 0x0000FF00) >>> 8 ); //0
		byte byte0 = (byte)((i & 0x000000FF)       );
		//{0,0,0,byte0} is equivalent, since all shifts >=8 will be 0
		return(new byte[]{byte3,byte2,byte1,byte0});
	}
	


	private byte[] encode_text(byte[] image, byte[] addition, int offset)
	{
		//check that the data + offset will fit in the image
		if(addition.length + offset > image.length)
		{
			throw new IllegalArgumentException("File not long enough!");
		}
		//loop through each addition byte
		for(int i=0; i<addition.length; ++i)
		{
			//loop through the 8 bits of each byte
			int add = addition[i];
			for(int bit=7; bit>=0; --bit, ++offset) //ensure the new offset value carries on through both loops
			{
				//assign an integer to b, shifted by bit spaces AND 1
				//a single bit of the current byte
				int b = (add >>> bit) & 1;
			
				image[offset] = (byte)((image[offset] & 0xFE) | b );
			}
		}
		return image;
	}
    

	private byte[] decode_text(byte[] image)
	{
		int length = 0;
		int offset  = 32;
		
		for(int i=0; i<32; ++i) //i=24 will also work, as only the 4th byte contains real data
		{
			length = (length << 1) | (image[i] & 1);
		}
		
		byte[] result = new byte[length];
		
		//loop through each byte of text
		for(int b=0; b<result.length; ++b )
		{
			//loop through each bit within a byte of text
			for(int i=0; i<8; ++i, ++offset)
			{
				//assign bit: [(new byte value) << 1] OR [(text byte) AND 1]
				result[b] = (byte)((result[b] << 1) | (image[offset] & 1));
			}
		}
		return result;
	}
	
	private String readFile(String path) throws Exception
	{
		String a="",c=null;
		FileReader f=new FileReader(path);
		BufferedReader b=new BufferedReader(f);
		while((c=b.readLine())!=null)
		{
			a=a+c+"\n";
		}
		f.close();
		//System.out.println(a);
		return a;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		String fpath,fname,exte,dest,data,msg1;
		Stegno tech=new Stegno();
		
		BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1.Encode data in Image:");
		System.out.println("2.Decode file in image:");
		System.out.println("3.Decode data from image:");
		System.out.println("4.Exit");
		try
		{
		System.out.println("Enter your choice: ");
		int ch=Integer.parseInt(s.readLine());
		switch(ch)
		{
			case 1:			
					System.out.println("Enter folder path");
					fpath=s.readLine();
					
					System.out.println("Enter file name");
					fname=s.readLine();
					
					System.out.println("Enter extension");
					exte=s.readLine();
					
					System.out.println("Enter Destination file name: ");
					dest=s.readLine();
					
					System.out.println("Enter message:");
					msg1=s.readLine();
					
					//msg1=suy.readFile(data);
					tech.encode(fpath,fname,exte,dest,msg1);
					
					System.out.println("Your data encoded successfully!!!");
					break;
		
			case 2:
					System.out.println("Enter folder path");
					fpath=s.readLine();
					
					System.out.println("Enter file name");
					fname=s.readLine();
					
					System.out.println("Enter extension");
					exte=s.readLine();
					
					System.out.println("Enter Destination file name: ");
					dest=s.readLine();
					
					System.out.println("Enter path of f3"
							+ "1ile to be encoded in it");
					data=s.readLine();
					
					msg1=tech.readFile(data);
					tech.encode(fpath,fname,exte,dest,msg1);
					
					System.out.println("Your data encoded successfully!!!");
					break;
					
			case 3:
					System.out.println("Enter Encoded folder path: ");
					String efpath=s.readLine();
					System.out.println("Enter Encoded Image name: ");
					String efname=s.readLine();
					String odata=tech.decode(efpath, efname);
					if(!odata.equals(null))
					System.out.println("data retrived: "+odata);
					break;
					
			case 4:
					System.exit(0);
		}	
		}
		catch(Exception e)
		{
		//	E:\SUYOG\college\Prp(diploma)\project ty\Our BB\Our BB
		}
	}
}