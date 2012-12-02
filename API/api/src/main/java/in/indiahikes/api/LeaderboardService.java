package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;
import in.indiahikes.api.data.UserDetails;
import in.indiahikes.db.UserDAO;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author srinivas.iyengar
 */
@Path ("/leaderboard/")
public class LeaderboardService
{
	@GET
	@Path ("{top}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getLeaderboard(@PathParam ("top") @DefaultValue ("5") String topStr)
	{
		int top = 0;
		try
		{
			top = Integer.parseInt(topStr);
		}
		catch (NumberFormatException ex)
		{
			// Log Exception
			top = 5;
		}
		List<UserDetails> leaderboard = getUserDetailsList(top);
		return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK, leaderboard)).build();
	}

	/**
	 * @param top
	 * @return
	 */
	private List<UserDetails> getUserDetailsList(int top)
	{

		UserDAO userDao = new UserDAO();
		return userDao.getLeaderboard(top);
	}
}
