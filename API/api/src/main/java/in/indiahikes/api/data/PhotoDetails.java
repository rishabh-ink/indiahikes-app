package in.indiahikes.api.data;

/**
 * @author srinivas.iyengar
 */
public class PhotoDetails
{
	private String photoId;
	private String facebookUserName;
	private String flickLink;

	/**
	 * Default Constructor.
	 */
	public PhotoDetails()
	{
		super();
	}

	/**
	 * @param photoId
	 * @param facebookUserName
	 * @param flickLink
	 */
	public PhotoDetails(String photoId, String facebookUserName, String flickLink)
	{
		super();
		this.photoId = photoId;
		this.facebookUserName = facebookUserName;
		this.flickLink = flickLink;
	}

	/**
	 * @return the photoId
	 */
	public String getPhotoId()
	{
		return photoId;
	}

	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(String photoId)
	{
		this.photoId = photoId;
	}

	/**
	 * @return the facebookUserName
	 */
	public String getFacebookUserName()
	{
		return facebookUserName;
	}

	/**
	 * @param facebookUserName the facebookUserName to set
	 */
	public void setFacebookUserName(String facebookUserName)
	{
		this.facebookUserName = facebookUserName;
	}

	/**
	 * @return the flickLink
	 */
	public String getFlickLink()
	{
		return flickLink;
	}

	/**
	 * @param flickLink the flickLink to set
	 */
	public void setFlickLink(String flickLink)
	{
		this.flickLink = flickLink;

	}

}
