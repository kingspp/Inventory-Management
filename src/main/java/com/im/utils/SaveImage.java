package com.im.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class SaveImage {

	public static String imageSave( MultipartFile image )
	{
		byte[] bytes;
		BufferedOutputStream out = null;

		String path = System.getProperty("user.home") + File.separator + "Imanagement";

		File customDir = new File(path);

		if( customDir.exists() )
		{
			System.out.println(customDir + " already exists");
		}
		else if( customDir.mkdirs() )
		{
			System.out.println(customDir + " was created");
		}
		else
		{
			// throw exception here
			System.out.println(customDir + " was not created");
		}
		File filePath = new File(customDir + File.separator + new Date().getTime() + ".jpg");
		try
		{
			bytes = image.getBytes();
			out = new BufferedOutputStream(new FileOutputStream(filePath));
			out.write(bytes);
			out.close();

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		return filePath.toString();
	}
}
