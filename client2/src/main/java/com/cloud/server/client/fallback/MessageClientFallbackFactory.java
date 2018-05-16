package com.cloud.server.client.fallback;

import com.cloud.server.client.repo.MessageClient;

@Component
public class MessageClientFallbackFactory implements FallbackFactory<MessageClient> {

    @Override
    public ProducerClient create(Throwable cause) {
        return new ProducerClientFallback(cause);
    }
}

