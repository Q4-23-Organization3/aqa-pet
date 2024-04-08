package hw11;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LoggerConfig {

    private static final String consoleAppenderName = "console";
    private static final String consolePattern = "%highlight{%d{HH:mm:ss.SSS} %-5level - %c:%M (%L) %m\\n}";

    public void createConfig(Level level) {
        ConfigurationBuilder<BuiltConfiguration> configurationBuilder =
                ConfigurationBuilderFactory.newConfigurationBuilder();
        AppenderComponentBuilder consoleAppenderBuilder =
                configurationBuilder.newAppender(consoleAppenderName, "Console");
        LayoutComponentBuilder patternLayoutBuilder =
                configurationBuilder.newLayout("PatternLayout");
        patternLayoutBuilder.addAttribute("pattern", consolePattern);
        consoleAppenderBuilder.add(patternLayoutBuilder);
        configurationBuilder.add(consoleAppenderBuilder);
        RootLoggerComponentBuilder rootLoggerComponentBuilder = configurationBuilder.newRootLogger(level);
        rootLoggerComponentBuilder.add(configurationBuilder.newAppenderRef(consoleAppenderName));
        configurationBuilder.add(rootLoggerComponentBuilder);
        Configurator.initialize(configurationBuilder.build());
    }
}
