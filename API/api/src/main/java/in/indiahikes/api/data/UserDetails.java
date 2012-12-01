package in.indiahikes.api.data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author srinivas.iyengar
 */
public class UserDetails
{
	@JsonProperty ("first_name")
	private String firstName;
	@JsonProperty ("last_name")
	private String lastName;
	@JsonProperty ("score")
	private int score;
	@JsonProperty ("facebook_url")
	private String facebookUrl;
	@JsonProperty ("profile_url")
	private String profileUrl;

	/**
	 * Default Constructor
	 */
	public UserDetails()
	{

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the score
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score)
	{
		this.score = score;
	}

	/**
	 * @return the facebookUrl
	 */
	public String getFacebookUrl()
	{
		return facebookUrl;
	}

	/**
	 * @param facebookUrl the facebookUrl to set
	 */
	public void setFacebookUrl(String facebookUrl)
	{
		this.facebookUrl = facebookUrl;
	}

	/**
	 * @return the profileUrl
	 */
	public String getProfileUrl()
	{
		return profileUrl;
	}

	/**
	 * @param profileUrl the profileUrl to set
	 */
	public void setProfileUrl(String profileUrl)
	{
		this.profileUrl = profileUrl;
	}

}
