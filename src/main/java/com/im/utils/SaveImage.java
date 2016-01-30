package com.im.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import com.im.exception.CustomGenericException;

public class SaveImage {

	public static String imageSave( MultipartFile image, String folderName ) throws Exception
	{
		byte[] bytes;
		BufferedOutputStream out = null;
		File filePath = null;
		// Properties prop = new Properties();
		try
		{
			/*
			 * input = new FileInputStream("application.properties");
			 * prop.load(input);
			 */
			String path = System.getProperty("user.dir") + File.separator + "Imanagement" + File.separator + folderName;
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
				throw new CustomGenericException("Could not create the folder to save your images");
			}
			Date date = new Date();
			filePath = new File(customDir + File.separator + date.getTime() + ".jpg");

			if( image != null )
			{
				bytes = image.getBytes();
				out = new BufferedOutputStream(new FileOutputStream(filePath));
				out.write(bytes);
				out.close();
				return "Imanagement" + File.separator + folderName + File.separator
						+ ((Long) date.getTime()).toString();
			}
			else
			{
				return "No Image";
			}

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			if( out != null )
			{
				out.close();
			}

		}

	}
}