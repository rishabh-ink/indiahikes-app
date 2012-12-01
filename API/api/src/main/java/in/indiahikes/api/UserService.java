package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;
import in.indiahikes.api.data.UserDetails;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author srinivas.iyengar
 */
@Path ("/userdetails/")
public class UserService
{
	/**
	 * @return User Details.
	 */
	@GET
	@Path ("{user_id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserDetails(@PathParam ("user_id") String userId)
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Srinivas");
		userDetails.setLastName("Iyengar");
		userDetails.setFacebookUrl("https://www.facebook.com/srini156");
		userDetails.setScore(100);
		userDetails.setProfileUrl("https://www.facebook.com/srini156/");
		return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK, userDetails)).build();
	}
}
