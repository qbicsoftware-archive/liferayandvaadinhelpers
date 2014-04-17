package de.uni_tuebingen.qbic.main;

public class ConfigurationManagerFactory {
	 public static ConfigurationManager getInstance(){
		
		 if(LiferayAndVaadinUtils.isLiferayPortlet()){
			 if(!LiferayConfigurationManager.Instance.isInitialized()){
				 LiferayConfigurationManager.Instance.init();
			 }
			 return LiferayConfigurationManager.Instance;
		 }
		 
		 if(!LiferayIndependentConfigurationManager.Instance.isInitialized()){
			 LiferayIndependentConfigurationManager.Instance.init();
		 }
		 
		return LiferayIndependentConfigurationManager.Instance;
	}
}
