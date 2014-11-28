package de.uni_tuebingen.qbic.main;


/**
 * The ConfigurationManger interface represents the entire .properties file.
 * One might think about adding a getAttribute method in order to make it more generic.
 * @author wojnar
 *
 */
public interface ConfigurationManager {

	  public String getConfigurationFileName();

	  public String getDataSource();

	  public String getDataSourceUser();

	  public String getDataSourcePassword();

	  public String getDataSourceUrl();
	  
	  public String getGenomeViewerUrl();
	  
	  public String getGenomeViewerRestApiUrl();
	  
	  public boolean isInitialized();
}
