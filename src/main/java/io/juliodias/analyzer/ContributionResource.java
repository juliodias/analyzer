package io.juliodias.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import static org.springframework.util.StreamUtils.copyToString;

@Component
public class ContributionResource {

    private final ObjectMapper objectMapper;
    private final Resource contributionResource;

    public ContributionResource(ObjectMapper objectMapper,
                                @Value("classpath:contributions.json") Resource contributionResource) {
        this.objectMapper = objectMapper;
        this.contributionResource = contributionResource;
    }

    public ContributionPayloadWrapper createContributions() throws Exception {
        final String contributionsPayload = toContributions(contributionResource);
        return objectMapper.readValue(contributionsPayload, ContributionPayloadWrapper.class);
    }

    private String toContributions(final Resource resource) throws IOException {
        return copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
