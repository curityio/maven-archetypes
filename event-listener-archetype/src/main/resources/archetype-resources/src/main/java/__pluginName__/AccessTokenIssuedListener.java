package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.events.IssuedAccessTokenOAuthEvent;
import se.curity.identityserver.sdk.event.EventListener;

public final class AccessTokenIssuedListener implements EventListener<IssuedAccessTokenOAuthEvent>
{
    // Change the generic type of the interface and return of the getEventType method to listen to a different type of event.
    // Event types that can be listened to are implentations of the Evet interface. You can find all the available
    // event types in the documentation: https://developer.curity.io/docs/latest/developer-guide/plugins/apidocs/index.html

    private final ${pluginName}EventListenerConfig _configuration;

    public AccessTokenIssuedListener(${pluginName}EventListenerConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public Class<IssuedAccessTokenOAuthEvent> getEventType()
    {
        return IssuedAccessTokenOAuthEvent.class;
    }

    @Override
    public void handle(IssuedAccessTokenOAuthEvent event)
    {
        // TODO: implement logic that should trigger on this event.
        // See examples of event listeners on GitHub: https://github.com/search?q=topic%3Aevent-listener+org%3Acurityio
    }
}
