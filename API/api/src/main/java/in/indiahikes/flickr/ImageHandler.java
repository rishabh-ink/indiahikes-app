package in.indiahikes.flickr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.auth.Auth;
import com.aetrion.flickr.auth.Permission;
import com.aetrion.flickr.photos.GeoData;
import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotosInterface;
import com.aetrion.flickr.photos.geo.GeoInterface;
import com.aetrion.flickr.uploader.UploadMetaData;
import com.aetrion.flickr.uploader.Uploader;

/**
 * @author srinivas.iyengar
 */
public class ImageHandler
{

	String apiKey;
	String sharedSecret;
	Flickr f;
	REST rest;
	RequestContext requestContext;
	Properties properties = null;

	public ImageHandler()
	{
		apiKey = "3e4779d4dab478823c7d2e93434dc092";
		sharedSecret = "f6b8477ab15a1566";
		try
		{
			rest = new REST();
		}
		catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String uploadImageToFlickr(InputStream in, String metadata, String latitude, String longitude,
	        String accuracy) throws IOException, FlickrException, SAXException, ParserConfigurationException
	{

		f = new Flickr(apiKey, sharedSecret, rest);
		requestContext = RequestContext.getRequestContext();
		Auth auth = new Auth();
		auth.setPermission(Permission.WRITE);

		// token which we might need to refresh
		auth.setToken("72157632140430115-4f1e49d599d5e66c");
		requestContext.setAuth(auth);
		Flickr.debugRequest = false;
		Flickr.debugStream = false;
		Uploader up = new Uploader(apiKey, sharedSecret);
		UploadMetaData metaData = new UploadMetaData();
		metaData.setTitle("check for rhok");
		metaData.setPublicFlag(true);

		String photoId = up.upload(in, metaData);
		PhotosInterface photoQuery = new PhotosInterface(apiKey, sharedSecret, rest);
		Photo photo = photoQuery.getInfo(photoId, null);// No Auth Required.

		GeoInterface geoInterface = new GeoInterface(apiKey, sharedSecret, rest);
		GeoData location = new GeoData(longitude, latitude, accuracy);
		geoInterface.setLocation(photoId, location);
		return photo.getMediumUrl();
	}
}
