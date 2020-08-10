package ${package}.${pluginName}

import se.curity.identityserver.sdk.event.EventListener
import se.curity.identityserver.sdk.event.EventListenerCollection
import se.curity.identityserver.sdk.plugin.descriptor.EventListenerPluginDescriptor

class ${pluginName}EventListenerDescriptor: EventListenerPluginDescriptor<${pluginName}EventListenerConfig>
{
    override fun getEventListenerCollection(): Class<out EventListenerCollection> = ${pluginName}ListenerCollection::class.java

    override fun getPluginImplementationType(): String =  "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}EventListenerConfig> = ${pluginName}EventListenerConfig::class.java
}

class ${pluginName}ListenerCollection(configuration: ${pluginName}EventListenerConfig): EventListenerCollection
{
    private val listeners: Set<EventListener<*>> = setOf(${pluginName}EventListener(configuration))

    override fun getListeners(): Set<EventListener<*>> = listeners
}
