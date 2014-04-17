package de.uni_tuebingen.qbic.main;

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
