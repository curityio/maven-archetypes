package ${package}.authentication;

import se.curity.identityserver.sdk.web.Request;

class RequestModel 
{
    private Request _request;

    RequestModel(Request request)
    {   
        _request = request;
    }

    public Request getRequest()
    {
        return _request;
    }
}