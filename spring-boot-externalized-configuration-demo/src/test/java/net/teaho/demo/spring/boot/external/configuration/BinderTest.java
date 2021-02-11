package net.teaho.demo.spring.boot.external.configuration;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.*;
import org.springframework.boot.context.properties.bind.handler.IgnoreTopLevelConverterNotFoundBindHandler;
import org.springframework.boot.context.properties.bind.validation.ValidationBindHandler;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.junit.Assert.assertEquals;

/**
 * @author hetl@akulaku.com
 * @date 2020-09
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BinderTest {

    private MockEnvironment environment;

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void beforeSetup() {
        environment = new MockEnvironment().withProperty("binder.test.enabled", "true")
            .withProperty("binder.test.url", "https://google.com")
            .withProperty("binder.test.name", "environment");
    }

    @Test
    public void testBinder_withoutHandler_bindSuccess() {
        TestPropertyConfig bc = Binder.get(environment)
            .bind("binder.test", Bindable.of(TestPropertyConfig.class))
            .get();
        TestPropertyConfig expect = new TestPropertyConfig();
        expect.setEnabled(true);
        expect.setUrl("https://google.com");
        expect.setName("environment");
        assertEquals(bc, expect);
    }

    @Test(expected = BindException.class)
    public void testBinder_withVilidator_bindFail() throws Exception {
        BindHandler handler = new IgnoreTopLevelConverterNotFoundBindHandler();
        handler = new ValidationBindHandler(handler, new SimpleConfigurationPropertiesJsr303Validator(configurableApplicationContext));
        handler = new SimpleEchoBindHandler(handler);
        TestPropertyConfig bc = Binder.get(environment)
            .bind("binder.test", Bindable.of(TestPropertyConfig.class), handler)
            .get();
        TestPropertyConfig expect = new TestPropertyConfig();
        expect.setEnabled(true);
        expect.setUrl("https://google.com");
        expect.setName("environment");
        assertEquals(bc, expect);

    }

    /**
     * 一个简单的echo bindHandler
     *
     */
    @Slf4j
    private static class SimpleEchoBindHandler extends AbstractBindHandler {

        public SimpleEchoBindHandler(BindHandler parent) {
            super(parent);
        }

        @Override
        public <T> Bindable<T> onStart(ConfigurationPropertyName name, Bindable<T> target, BindContext context) {
            log.info("config property name:{}, bindable:{}", name, target);
            return super.onStart(name, target, context);
        }

        @Override
        public Object onSuccess(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) {
            log.info("config property name:{}, bindable:{}, result:{}", name, target, result);
            return super.onSuccess(name, target, context, result);
        }

        @Override
        public Object onFailure(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Exception error) throws Exception {
            log.error("config property name:{}, bindable:{}, error:{}", name, target, error);
            return super.onFailure(name, target, context, error);
        }

        @Override
        public void onFinish(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) throws Exception {
            log.info("config property name:{}, bindable:{}, result:{}", name, target, result);
            super.onFinish(name, target, context, result);
        }
    }

    private static class SimpleConfigurationPropertiesJsr303Validator implements Validator {
        private static final String[] VALIDATOR_CLASSES = { "javax.validation.Validator",
            "javax.validation.ValidatorFactory",
            "javax.validation.bootstrap.GenericBootstrap" };

        private final SimpleConfigurationPropertiesJsr303Validator.Delegate delegate;

        SimpleConfigurationPropertiesJsr303Validator(ApplicationContext applicationContext) {
            this.delegate = new SimpleConfigurationPropertiesJsr303Validator.Delegate(applicationContext);
        }

        @Override
        public boolean supports(Class<?> type) {
            return this.delegate.supports(type);
        }

        @Override
        public void validate(Object target, Errors errors) {
            this.delegate.validate(target, errors);
        }

        public static boolean isJsr303Present(ApplicationContext applicationContext) {
            ClassLoader classLoader = applicationContext.getClassLoader();
            for (String validatorClass : VALIDATOR_CLASSES) {
                if (!ClassUtils.isPresent(validatorClass, classLoader)) {
                    return false;
                }
            }
            return true;
        }

        private static class Delegate extends LocalValidatorFactoryBean {

            Delegate(ApplicationContext applicationContext) {
                setApplicationContext(applicationContext);
                setMessageInterpolator(new MessageInterpolatorFactory().getObject());
                afterPropertiesSet();
            }

        }
    }


}
