package net.teaho.demo.spring.cloud.context.named.app;

import net.teaho.demo.spring.cloud.context.named.SimpleNamedContextFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SimplePropertiesFactory {

	@Autowired
	private Environment environment;

	private Map<Class, String> classToProperty = new HashMap<>(1<<2);

	public SimplePropertiesFactory() {
		classToProperty.put(Rule.class, "SimpleRuleClassName");
	}

	public boolean isSet(Class clazz, String name) {
		return StringUtils.hasText(getClassName(clazz, name));
	}


	public String getClassName(Class clazz, String name) {
		if (this.classToProperty.containsKey(clazz)) {
			String classNameProperty = this.classToProperty.get(clazz);
			return environment.getProperty(name + "." + SimpleNamedContextFactory.NAMESPACE + "." + classNameProperty);
		}
		return null;
	}

	public <C> C get(Class<C> clazz, String name) {
		String className = getClassName(clazz, name);
		if (StringUtils.hasText(className)) {
			try {
				Class<?> toInstantiate = Class.forName(className);
				return (C) BeanUtils.instantiateClass(toInstantiate);
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Unknown class to load "+className+" for class " + clazz + " named " + name);
			}
		}
		return null;
	}
}
