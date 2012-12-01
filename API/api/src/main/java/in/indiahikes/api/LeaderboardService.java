package in.indiahikes.api;

import in.indiahikes.api.data.ApiResponse;
import in.indiahikes.api.data.UserDetails;

import java.util.ArrayList;
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
	public Response getUserDetails(@PathParam ("top") @DefaultValue ("5") String topStr)
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
		List<UserDetails> leaderboard = new ArrayList<UserDetails>();
		for (int i = 0; i < top; i++)
		{
			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName("Srinivas");
			userDetails.setLastName("Iyengar");
			userDetails.setFacebookUrl("https://www.facebook.com/srini156");
			userDetails.setScore(100);
			userDetails.setProfileUrl("https://www.facebook.com/srini156/");
			leaderboard.add(userDetails);
		}
		return Response.status(Response.Status.OK).entity(new ApiResponse(Response.Status.OK, leaderboard)).build();
	}
}
