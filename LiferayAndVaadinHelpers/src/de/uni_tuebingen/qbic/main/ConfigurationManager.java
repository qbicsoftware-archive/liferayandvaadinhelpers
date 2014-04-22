package de.uni_tuebingen.qbic.main;


/**
 * The ConfigurationManger interface represents the entire .properties file.
 * One might think about adding a getAttribute method in order to make it more generic.
 * @author wojnar
 *
 */
public interface ConfigurationManager {
	
	  public String getMastersDir();

	  public String getUserDefaultsDir();

	  public String getWorkflowDir();

	  public String getBioDBUpdateFilePath();

	  public String getBioDBUpdateFlagPath();

	  public String getBioDBUpdateFileEnding();

	  public String getBioDBBrutusPath();

	  public String getBioDBDBFileExtension();

	  public String getConfigurationFileName();

	  public String getDataSource();

	  public String getDataSourceUser();

	  public String getDataSourcePassword();

	  public String getDataSourceURL();

	  public String getWikiUser();

	  public String getWikiPass();

	  public String getWikiURL();
	  
	  public boolean isInitialized();
}
