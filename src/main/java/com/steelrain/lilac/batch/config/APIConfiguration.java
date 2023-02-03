package com.steelrain.lilac.batch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:api-keys.properties")
public class APIConfiguration {

    @Value("${youtube.api.key}")
    private String m_youtubeKey;

    @Value("${sentiment.threshold}")
    private String m_threshold;

    @Value("${sentiment.comment.count}")
    private String m_commentCount;

    @Value("${playlist.fetch.size}")
    private String m_playlistFetchSize;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    APIConfig apiConfig(){
        return new APIConfig(this.m_youtubeKey, m_threshold, m_commentCount, m_playlistFetchSize);
    }
}
