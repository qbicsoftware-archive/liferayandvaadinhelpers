package de.uni_tuebingen.qbic.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implements {@see ConfigurationManager}. Does not need Portal environment.
 * 
 * @author wojnar
 * 
 */

public enum LiferayIndependentConfigurationManager implements ConfigurationManager {
  Instance;
  public static final String CONFIGURATION_SUFFIX = ".configuration";
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
  
  private String portletPropertiesFileName = "portlet.properties";

  private boolean initialized = false;

  /*
   * LiferayIndependentConfigurationManager(){ init(); }
   */

  public boolean isInitialized() {
    return initialized;
  }

  public void init() {
    Properties portletConfig = new Properties();
    InputStream input = null;

    try {
      input =
          LiferayIndependentConfigurationManager.class.getClassLoader().getResourceAsStream(
              portletPropertiesFileName);
      if (input == null) {
        System.out.println("Sorry, unable to find " + portletPropertiesFileName);
        return;
      }

      // load a properties file from class path, inside static method
      portletConfig.load(input);
      Properties config = new Properties();
      dataSource = portletConfig.getProperty(DATASOURCE_KEY, "openBIS");
      dataSourceUser = portletConfig.getProperty(DATASOURCE_USER);
      dataSourcePass = portletConfig.getProperty(DATASOURCE_PASS);
      dataSourceUrl = portletConfig.getProperty(DATASOURCE_URL);
      genomeViewerUrl = portletConfig.getProperty(GENOMEVIEWER_URL);
      genomeViewerRestApi = portletConfig.getProperty(GENOMEVIEWER_RESTAPI);
      tmpFolder = portletConfig.getProperty(TMP_FOLDER);
      scriptsFolder = portletConfig.getProperty(SCRIPTS_FOLDER);
      pathVariable = portletConfig.getProperty(PATH_VARIABLE);
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
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
