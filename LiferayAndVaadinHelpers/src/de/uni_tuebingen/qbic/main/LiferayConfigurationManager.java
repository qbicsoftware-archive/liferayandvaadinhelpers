package de.uni_tuebingen.qbic.main;

import java.util.Properties;
import com.liferay.util.portlet.PortletProps; // util-java.jar

/**
 * Implements {@see ConfigurationManager} Portal dependent
 * 
 * @author wojnar
 * 
 */
public enum LiferayConfigurationManager implements ConfigurationManager {
  Instance;
  public static final String DATASOURCE_KEY = "datasource";
  public static final String DATASOURCE_USER = "datasource.user";
  public static final String DATASOURCE_PASS = "datasource.password";
  public static final String DATASOURCE_URL = "datasource.url";
  public static final String GENOMEVIEWER_URL = "genomeviewer.url";
  public static final String GENOMEVIEWER_RESTAPI = "genomeviewer.restapi";
  public static final String TMP_FOLDER = "tmp.folder";
  public static final String SCRIPTS_FOLDER = "barcode.scripts";
  public static final String PATH_VARIABLE = "path.variable";

  private String configurationFileName;
  private String dataSource;
  private String dataSourceUser;
  private String dataSourcePass;
  private String dataSourceUrl;

  private String genomeViewerUrl;
  private String genomeViewerRestApi;
  
  private String tmpFolder;
  private String scriptsFolder;
  private String pathVariable;


  private boolean initialized = false;

  /*
   * private LiferayConfigurationManager(){ init(); }
   */
  public boolean isInitialized() {
    return initialized;
  }

  public void init() {
    Properties portletConfig = PortletProps.getProperties();
    dataSource = portletConfig.getProperty(DATASOURCE_KEY, "openBIS");
    dataSourceUser = portletConfig.getProperty(DATASOURCE_USER);
    dataSourcePass = portletConfig.getProperty(DATASOURCE_PASS);
    dataSourceUrl = portletConfig.getProperty(DATASOURCE_URL);
    genomeViewerUrl = portletConfig.getProperty(GENOMEVIEWER_URL);
    genomeViewerRestApi = portletConfig.getProperty(GENOMEVIEWER_RESTAPI);
    tmpFolder = portletConfig.getProperty(TMP_FOLDER);
    scriptsFolder = portletConfig.getProperty(SCRIPTS_FOLDER);
    pathVariable = portletConfig.getProperty(PATH_VARIABLE);
    initialized = true;
  }

  @Override
  public String getConfigurationFileName() {
    return configurationFileName;
  }

  @Override
  public String getDataSource() {
    return dataSource;
  }

  @Override
  public String getDataSourceUser() {
    return dataSourceUser;
  }

  @Override
  public String getDataSourcePassword() {
    return dataSourcePass;
  }

  @Override
  public String getDataSourceUrl() {
    return dataSourceUrl;
  }

  @Override
  public String getGenomeViewerUrl() {
    return genomeViewerUrl;
  }

  @Override
  public String getGenomeViewerRestApiUrl() {
    return genomeViewerRestApi;
  }

  @Override
  public String getScriptsFolder() {
    return scriptsFolder;
  }

  @Override
  public String getTmpFolder() {
    return tmpFolder;
  }

  @Override
  public String getPathVariable() {
    return pathVariable;
  }
}
