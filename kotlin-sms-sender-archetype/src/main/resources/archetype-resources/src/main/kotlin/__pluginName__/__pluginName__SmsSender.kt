package ${package}.${pluginName}

import se.curity.identityserver.sdk.service.sms.SmsSender

class ${pluginName}SmsSender(private val _configuration: ${pluginName}SmsConfig): SmsSender
{
    override fun sendSms(toNumber: String, msg: String): Boolean
    {
        // TODO: Implement sending an sms.
        // Check out the examples on GitHub: https://github.com/search?q=sms+org%3Acurityio&type=Repositories

        return true
    }
}
