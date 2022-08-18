package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.events.Event
import se.curity.identityserver.sdk.event.EventListener

class ${pluginName}EventListener(private val _configuration: ${pluginName}EventListenerConfig): EventListener<Event>
{
    // TODO: Change the generic type of the interface and return of the getEventType method to listen to a different type of event.
    // Event types that can be listened to are implementations of the Event interface. You can find all the available
    // event types in the documentation: https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/data/events/package-summary.html

    override fun getEventType(): Class<Event>
    {

        return Event::class.java
    }

    override fun handle(event: Event)
    {
        // TODO: implement logic that should trigger on this event.
        // See examples of event listeners on GitHub: https://github.com/search?q=topic%3Aevent-listener+org%3Acurityio
    }
}
