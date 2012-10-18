package com.siteview.ecc.simplereport;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siteview.tool.GIFEncoder;



public class CreateImage {

	public void create(HttpSession session,HttpServletResponse response,String id) {
		BufferedImage chartImagemap=null;
		OutputStream output=null;
		try {
			chartImagemap=(BufferedImage)session.getAttribute(id);
			output = response.getOutputStream();
//			ImageIO.write(chartImagemap, "GIF", output);
			GIFEncoder encode = new GIFEncoder(chartImagemap);
			encode.Write(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{output.close();}catch(Exception e){}
		}
	}
	public void create(BufferedImage chartImagemap, String strPath) {
		try {
				createDir(strPath);
				OutputStream output = new FileOutputStream(strPath);
				try{
//					ImageIO.write(chartImagemap, "GIF", output);
					GIFEncoder encode = new GIFEncoder(chartImagemap);
					encode.Write(output);
					}finally{output.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void createDir(String strPath)
	{
		int idx1=strPath.lastIndexOf("\\");
		int idx2=strPath.lastIndexOf("/");
		int idx=Math.max(idx1,idx2);
			
		if(idx>0)
		{
			String path=strPath.substring(0,idx);
			java.io.File f=new java.io.File(path);
			if(!f.exists())
				f.mkdirs();
		}
		
		
	}
	
}
