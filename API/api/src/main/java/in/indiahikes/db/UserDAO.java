package in.indiahikes.db;

import in.indiahikes.api.data.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO
{

	public int insert(UserDetails user)
	{

		// score is 5 by default.

		/*
		 * facebook_username:
		 * name:
		 * score:
		 * facebook_url:
		 */

		DbHelper db = new DbHelper();
		Connection conn = db.getConnection();

		ResultSet rst = null;
		Statement stmt = null;

		PreparedStatement pstatement = null;

		int num_of_rows = 0;

		try
		{

			String queryString =
			        "INSERT INTO userdetails(facebook_username,name,score,facebook_url) VALUES (?, ?,?, ?)";
			pstatement = conn.prepareStatement(queryString);

			pstatement.setString(1, user.getUserName());
			pstatement.setString(2, user.getName());
			pstatement.setInt(3, user.getScore());
			pstatement.setString(4, user.getFacebookUrl());

			int updateQuery = pstatement.executeUpdate();
			stmt = null;

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num_of_rows;
	}

	public List<UserDetails> getLeaderboard(int top)
	{
		Connection con;
		DbHelper db = new DbHelper();
		ResultSet rst = null;
		List<UserDetails> leaderboard = new ArrayList<UserDetails>();
		try
		{
			con = db.getConnection();

			Statement stmt = null;

			stmt = con.createStatement();
			rst = stmt.executeQuery("select * from userdetails order by score desc limit " + top);

			if (rst.next())
			{
				do
				{
					UserDetails userDetails = rsToUserDetails(rst);
					leaderboard.add(userDetails);
				} while (rst.next());
			}
		}
		catch (SQLException ex)
		{

		}

		return leaderboard;
	}

	public UserDetails getUserDetailsByUsername(String username)
	{

		Connection con;
		DbHelper db = new DbHelper();
		ResultSet rst = null;
		UserDetails userDetails = null;
		try
		{
			con = db.getConnection();

			Statement stmt = null;

			stmt = con.createStatement();
			rst = stmt.executeQuery("select * from userdetails where facebook_username = '" + username + "'");
			if (rst.next())
			{
				userDetails = rsToUserDetails(rst);

			}
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return userDetails;
	}

	private UserDetails rsToUserDetails(ResultSet rs) throws SQLException
	{
		if (rs == null)
		{
			return null;
		}

		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(rs.getString("facebook_username"));
		userDetails.setName(rs.getString("name"));
		userDetails.setScore(rs.getInt("score"));
		userDetails.setFacebookUrl(rs.getString("facebook_url"));
		return userDetails;

	}

	public static void main(String[] args)
	{
		UserDAO dao = new UserDAO();

		UserDetails user = null;
		user = dao.getUserDetailsByUsername("srini156");
		System.out.println(user.getScore());

	}
}
