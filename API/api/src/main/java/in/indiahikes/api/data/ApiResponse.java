package in.indiahikes.api.data;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author srinivas.iyengar
 */
public class ApiResponse
{
	@JsonProperty ("status_code")
	private int statusCode;
	@JsonProperty ("status_message")
	private String statusMessage;
	@JsonProperty ("data")
	private Object data;

	/**
	 * Public Constructor for POJO Mapping.
	 */
	public ApiResponse()
	{

	}

	/**
	 * @param responseStatus Response Status.
	 * @param data Data Payload to be sent along with the response.
	 */
	public ApiResponse(Response.Status responseStatus, Object data)
	{
		this.setStatusCode(responseStatus.getStatusCode());
		this.setStatusMessage(responseStatus.name());
		this.setData(data);
	}

	/**
	 * This Method is used to set the API Response with data as payload.
	 * @param statusCode API Status Code.
	 * @param statusMessage API Status Message corresponding to Status Code.
	 * @param data Data Payload to be sent along with the Response.
	 */
	public ApiResponse(int statusCode, String statusMessage, Object data)
	{
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
		this.setData(data);
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode()
	{
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode)
	{
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage()
	{
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage)
	{
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the data
	 */
	public Object getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data)
	{
		this.data = data;
	}
}
