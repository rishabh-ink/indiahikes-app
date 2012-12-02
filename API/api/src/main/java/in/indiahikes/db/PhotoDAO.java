package in.indiahikes.db;

import in.indiahikes.api.data.PhotoDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhotoDAO
{

	Connection conn;

	public int insert(PhotoDetails photo)
	{

		// score is 5 by default.

		/*
		 * photo_id,
		 * facebook_username
		 * flickr_link
		 */

		DbHelper db = new DbHelper();
		Connection conn = db.getConnection();

		ResultSet rst = null;
		Statement stmt = null;

		PreparedStatement pstatement = null;

		int num_of_rows = 0;

		try
		{

			String queryString = "INSERT INTO photo(facebook_username, flickr_url) VALUES ( ?, ?)";
			pstatement = conn.prepareStatement(queryString);
			pstatement.setString(1, photo.getFacebookUserName());
			pstatement.setString(2, photo.getFlickLink());

			num_of_rows = pstatement.executeUpdate();
			stmt = null;

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num_of_rows;
	}

	public PhotoDetails getPhotoDetailsByPhotoID(int photoId)
	{

		Connection con;
		DbHelper db = new DbHelper();
		ResultSet rst = null;
		PhotoDetails photoDetails = null;
		try
		{
			con = db.getConnection();

			Statement stmt = null;

			stmt = con.createStatement();
			rst = stmt.executeQuery("select * from greentrail.photo where photo_id = " + photoId);
			if (rst.next())
			{
				photoDetails = rsToPhotoDetails(rst);
			}
		}

		catch (SQLException e)
		{
			e.printStackTrace();

		}

		return photoDetails;
	}

	public PhotoDetails getPhotoDetailsByPhotoUsername(String userName)
	{

		Connection con;
		DbHelper db = new DbHelper();
		ResultSet rst = null;
		PhotoDetails photoDetails = null;
		try
		{
			con = db.getConnection();
			Statement stmt = null;
			stmt = con.createStatement();
			rst = stmt.executeQuery("select * from greentrail.photo where facebook_username = '" + userName + "'");
			if (rst.next())
			{
				photoDetails = rsToPhotoDetails(rst);
			}
		}

		catch (SQLException e)
		{
			e.printStackTrace();

		}

		return photoDetails;
	}

	private PhotoDetails rsToPhotoDetails(ResultSet rs) throws SQLException
	{
		if (rs == null)
		{
			return null;
		}
		PhotoDetails photoDetails = new PhotoDetails();
		photoDetails.setPhotoId(rs.getString("photo_id"));
		photoDetails.setFacebookUserName(rs.getString(""));
		photoDetails.setFlickLink(rs.getString(""));
		return photoDetails;
	}
}
