package de.uni_tuebingen.qbic.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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

  private static Logger log = new Logger(LiferayConfigurationManager.class);


  private String configurationFileName;
  private String dataSource;
  private String dataSourceUser;
  private String dataSourcePass;
  private String dataSourceUrl;
  private String genomeViewerUrl;
  private String genomeViewerRestApi;

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
      configurationFileName = portletConfig.getProperty("default" + CONFIGURATION_SUFFIX);
      try {

        config.load(new FileInputStream(configurationFileName));
        StringWriter configDebug = new StringWriter();
        config.list(new PrintWriter(configDebug));
        dataSource = config.getProperty(DATASOURCE_KEY, "openBIS");
        dataSourceUser = config.getProperty(DATASOURCE_USER);
        dataSourcePass = config.getProperty(DATASOURCE_PASS);
        dataSourceUrl = config.getProperty(DATASOURCE_URL);
        genomeViewerUrl = config.getProperty(GENOMEVIEWER_URL);
        genomeViewerRestApi = config.getProperty(GENOMEVIEWER_RESTAPI);
      } catch (IOException e) {
        log.error("Failed to load configuration: ", e);
      }



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
}
