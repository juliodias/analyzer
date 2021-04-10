package io.juliodias.analyzer;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "analyzer");
    }

    public void countContributions() {
        meterRegistry.counter("contributions.counter").increment();
    }

}
