package io.juliodias.analyzer;

import static io.juliodias.analyzer.ContributionPayloadWrapper.ContributionsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ContributionPublisher implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContributionPublisher.class);

    private final String contributionQueue;
    private final QueueService queueService;
    private final ContributionResource contributionResource;

    public ContributionPublisher(QueueService queueService,
                                 ContributionResource contributionResource,
                                 @Value("${contributions.sqs}") String contributionQueue) {
        this.queueService = queueService;
        this.contributionQueue = contributionQueue;
        this.contributionResource = contributionResource;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        LOGGER.info(":: Starting process contributions ::");

        final ContributionPayloadWrapper contributions = contributionResource.createContributions();
        contributions.getContributionsDTO()
                .stream()
                .map(ContributionsDTO::getContributionDTO)
                .forEach(contribution -> queueService.sendMessage(contributionQueue, contribution.toString()));

        LOGGER.info(":: Finish process contributions ::");
    }

}
