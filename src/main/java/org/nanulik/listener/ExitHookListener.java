package org.nanulik.listener;

import org.nanulik.helper.MetadataSaver;
import org.nanulik.model.DatabaseMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
@Component
public class ExitHookListener implements ApplicationListener<ContextClosedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ExitHookListener.class);

    private final DatabaseMetadata metadata;
    private final MetadataSaver metadataSaver;

    public ExitHookListener(DatabaseMetadata metadata, MetadataSaver metadataSaver) {
        this.metadata = metadata;
        this.metadataSaver = metadataSaver;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        logger.info("Persisting database data.");

        metadataSaver.persistDatabaseMetadata(
                metadata
        );
    }
}
