package in.indiahikes.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author srinivas.iyengar
 */
@Path ("/test/{str}")
public class TestService
{
	/**
	 * Test API.
	 * @param str String
	 * @return Echo of the String.
	 */

	@GET
	public String test(@PathParam ("str") String str)
	{
		return "Response is " + str;
	}
}
