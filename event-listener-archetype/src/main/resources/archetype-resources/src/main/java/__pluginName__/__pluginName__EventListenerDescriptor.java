package ${package}.${pluginName};

import se.curity.identityserver.sdk.event.EventListener;
import se.curity.identityserver.sdk.event.EventListenerCollection;
import se.curity.identityserver.sdk.plugin.descriptor.EventListenerPluginDescriptor;

import java.util.Collections;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public final class ${pluginName}EventListenerDescriptor implements EventListenerPluginDescriptor<${pluginName}EventListenerConfig>
{
    @Override
    public Class<? extends EventListenerCollection> getEventListenerCollection()
    {
        return ${pluginName}ListenerCollection.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}EventListenerConfig> getConfigurationType()
    {
        return ${pluginName}EventListenerConfig.class;
    }

    public static final class ${pluginName}ListenerCollection implements EventListenerCollection
    {
        private final Set<EventListener<?>> _listeners;

        public ${pluginName}ListenerCollection(${pluginName}EventListenerConfig configuration)
        {
            _listeners = Collections.singleton(new AccessTokenIssuedListener(configuration));
        }

        @Override
        public Set<? extends EventListener<?>> getListeners()
        {
            return unmodifiableSet(_listeners);
        }
    }
}
