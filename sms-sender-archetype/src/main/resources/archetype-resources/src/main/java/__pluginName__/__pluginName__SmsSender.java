package ${package}.${pluginName};

import se.curity.identityserver.sdk.service.sms.SmsSender;

public final class ${pluginName}SmsSender implements SmsSender
{
    private final ${pluginName}SmsConfig _configuration;

    public ${pluginName}SmsSender(${pluginName}SmsConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public boolean sendSms(String toNumber, String msg)
    {
        // TODO: Implement sending an sms.
        // Check out the examples on GitHub: https://github.com/search?q=sms+org%3Acurityio&type=Repositories

        return true;
    }
}
