package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;
import in.indiahikes.api.data.PhotoDetails;
import in.indiahikes.db.PhotoDAO;
import in.indiahikes.flickr.ImageHandler;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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
	public Response uploadImage(@HeaderParam ("Content-Length") Long fileSize,
	        @FormDataParam ("file") InputStream inputStream,
	        @FormDataParam ("file") FormDataContentDisposition fileDetails,
	        @FormDataParam ("file") FormDataBodyPart bodyPart,
	        @FormDataParam ("latitude") @DefaultValue ("0") String latitude,
	        @FormDataParam ("longitude") @DefaultValue ("0") String longitude,
	        @FormDataParam ("accuracy") @DefaultValue ("0") String accuracy,
	        @FormDataParam ("facebook_username") @DefaultValue ("") String facebookUserName)
	{

		if ("".equals(latitude))
		{
			latitude = "0";
		}
		if ("".equals(longitude))
		{
			longitude = "0";
		}
		ImageHandler imageHandler = new ImageHandler();
		PhotoDetails photoDetails = null;
		try
		{
			photoDetails =
			        imageHandler.uploadImageToFlickr(inputStream, fileDetails.getFileName(), latitude, longitude,
			                accuracy);
			photoDetails.setFacebookUserName(facebookUserName);
			PhotoDAO photodao = new PhotoDAO();
			photodao.insert(photoDetails);
		}
		catch (Exception ex)
		{
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
			        .entity(new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR, "Upload to Flickr Failed")).build();
		}
		return Response.ok().entity(new ApiResponse(Response.Status.OK, photoDetails)).build();
	}
}
