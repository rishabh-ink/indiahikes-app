package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;
import in.indiahikes.api.data.UserDetails;
import in.indiahikes.db.UserDAO;

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
		UserDetails userDetails = getCurrentUserDetails(userId);
		return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK, userDetails)).build();
	}

	/**
	 * @param UserId User Id of the User.
	 * @return UserDetails for the UserId.
	 */
	private UserDetails getCurrentUserDetails(String userId)
	{
		UserDAO userDao = new UserDAO();
		return userDao.getUserDetailsByUsername(userId);
	}
}
