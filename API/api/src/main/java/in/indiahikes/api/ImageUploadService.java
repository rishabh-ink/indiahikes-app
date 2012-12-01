package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author srinivas.iyengar
 */
@Path ("/upload")
public class ImageUploadService
{
	@POST
	@Consumes (MediaType.MULTIPART_FORM_DATA)
	@Produces (MediaType.APPLICATION_JSON)
	public Response addNewClientImage(@HeaderParam ("Content-Length") Long fileSize,
	        @FormDataParam ("file") InputStream inputStream,
	        @FormDataParam ("file") FormDataContentDisposition fileDetails,
	        @FormDataParam ("file") FormDataBodyPart bodyPart)
	{
		String uploadedFileLocation = "./" + fileDetails.getFileName();

		// save it
		writeToFile(inputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;
		return Response.ok().entity(new ApiResponse(Response.Status.OK, output)).build();
	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation)
	{

		try
		{
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}

	}

}
