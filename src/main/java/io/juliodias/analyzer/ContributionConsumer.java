package io.juliodias.analyzer;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContributionConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContributionConsumer.class);

    private final MetricsService metricsService;

    public ContributionConsumer(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @SqsListener("${contributions.sqs}")
    public void process(final String contribution) {
        LOGGER.info("Receiving contribution: [{}]", contribution);

        metricsService.countContributions();
    }
}
