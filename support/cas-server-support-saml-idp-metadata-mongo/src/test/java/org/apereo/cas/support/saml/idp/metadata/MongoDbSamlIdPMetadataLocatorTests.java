package org.apereo.cas.support.saml.idp.metadata;

import org.apereo.cas.support.saml.BaseMongoDbSamlMetadataTests;
import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;
import org.apereo.cas.util.junit.EnabledIfPortOpen;

import lombok.val;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link MongoDbSamlIdPMetadataLocatorTests}.
 *
 * @author Misagh Moayyed
 * @since 6.2.0
 */
@TestPropertySource(properties = {
    "cas.authn.samlIdp.metadata.mongo.databaseName=saml-idp-generator",
    "cas.authn.samlIdp.metadata.mongo.host=localhost",
    "cas.authn.samlIdp.metadata.mongo.port=27017",
    "cas.authn.samlIdp.metadata.mongo.userId=root",
    "cas.authn.samlIdp.metadata.mongo.password=secret",
    "cas.authn.samlIdp.metadata.mongo.authenticationDatabaseName=admin",
    "cas.authn.samlIdp.metadata.mongo.dropCollection=true",
    "cas.authn.samlIdp.metadata.mongo.idpMetadataCollection=saml-idp-metadata"
})
@Tag("MongoDb")
@EnabledIfPortOpen(port = 27017)
@EnabledIfContinuousIntegration
public class MongoDbSamlIdPMetadataLocatorTests extends BaseMongoDbSamlMetadataTests {

    @Test
    public void verifySigningKeyWithoutService() {
        val resource = samlIdPMetadataLocator.resolveSigningKey(Optional.empty());
        assertNotNull(resource);
    }
}
