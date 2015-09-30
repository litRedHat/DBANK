package com.tangdi.dbank.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyResourceConfigurer extends PropertyPlaceholderConfigurer {

	private Properties properties;

	@Override
	protected void processProperties (ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {

		super.processProperties(beanFactoryToProcess, props);

		this.properties = props;
	}

	public String getPropertiesValue(String key) {
		
		String value = "交易异常，请联系工作人员";
		if (key != null && !"".equals(key)) {
			value = this.properties.getProperty(key);
			if (value != null) {
				try {
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
				}
			} else {
				value = "交易异常，请联系工作人员";
			}
		}
		return value;
	}
}