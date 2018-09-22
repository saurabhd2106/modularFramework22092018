package commonLibs;

public interface IAlert {
	
	public void acceptAlert() throws Exception;

	public void rejectAlert() throws Exception;

	public String getMessageFromAlert() throws Exception;

}
