package in.indiahikes.api.data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author srinivas.iyengar
 */
public class UserDetails
{
	@JsonProperty ("name")
	private String name;
	@JsonProperty ("score")
	private int score;
	@JsonProperty ("facebook_url")
	private String facebookUrl;
	@JsonProperty ("user_name")
	private String userName;

	/**
	 * Default Constructor
	 */
	public UserDetails()
	{

	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
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
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param profileUrl the profileUrl to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

}
