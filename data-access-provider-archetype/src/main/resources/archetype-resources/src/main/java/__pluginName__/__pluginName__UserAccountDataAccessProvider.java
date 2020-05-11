package ${package}.${pluginName};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.attribute.AccountAttributes;
import se.curity.identityserver.sdk.attribute.scim.v2.ResourceAttributes;
import se.curity.identityserver.sdk.attribute.scim.v2.extensions.LinkedAccount;
import se.curity.identityserver.sdk.data.query.ResourceQuery;
import se.curity.identityserver.sdk.data.query.ResourceQueryResult;
import se.curity.identityserver.sdk.data.update.AttributeUpdate;
import se.curity.identityserver.sdk.datasource.UserAccountDataAccessProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Map;

public class ${pluginName}UserAccountDataAccessProvider implements UserAccountDataAccessProvider
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider.class);

    private final ${pluginName}DataAccessProviderConfig _configuration;

    public ${pluginName}UserAccountDataAccessProvider(${pluginName}DataAccessProviderConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public ResourceAttributes<?> getByUserName(String userName, ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received request to get account by username : {}", userName);
        throw new NotImplementedException();
    }

    @Override
    public ResourceAttributes<?> getByEmail(String email, ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received request to get account by email : {}", email);
        throw new NotImplementedException();
    }

    @Override
    public ResourceAttributes<?> getByPhone(String phone, ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received request to get account by phone number : {}", phone);
        throw new NotImplementedException();
    }

    @Override
    public AccountAttributes create(AccountAttributes accountAttributes)
    {
        _logger.debug("Received request to create account with data : {}", accountAttributes);
        throw new NotImplementedException();
    }

    @Override
    public ResourceAttributes<?> update(AccountAttributes accountAttributes,
        ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received request to update account with data : {}", accountAttributes);
        throw new NotImplementedException();
    }

    @Override
    public ResourceAttributes<?> update(String accountId, Map<String, Object> map,
        ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received request to update account with id:{} and  data : {}", accountId, map);
        throw new NotImplementedException();
    }

    @Override
    public ResourceAttributes<?> patch(String accountId, AttributeUpdate attributeUpdate,
        ResourceQuery.AttributesEnumeration attributesEnumeration)
    {
        _logger.debug("Received patch request with accountId:{} and  data : {}", accountId, attributeUpdate);
        throw new NotImplementedException();
    }


    @Override
    public void link(String linkingAccountManager, String localAccountId, String foreignDomainName, String foreignUserName)
    {
        throw new NotImplementedException();
    }

    @Override
    public Collection<LinkedAccount> listLinks(String linkingAccountManager, String localAccountId)
    {
        throw new NotImplementedException();
    }

    @Override
    public AccountAttributes resolveLink(String linkingAccountManager, String foreignDomainName, String foreignAccountId)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteLink(String linkingAccountManager, String localAccountId, String foreignDomainName, String foreignAccountId)
    {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String accountId)
    {
        _logger.debug("Received request to delete account with accountId: {}", accountId);
        throw new NotImplementedException();
    }

    @Override
    public ResourceQueryResult getAll(long startIndex, long count)
    {
        _logger.debug("Received request to get all accounts with startIndex :{} and count: {}", startIndex, count);
        throw new NotImplementedException();
    }
}
