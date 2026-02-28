package com.nikhilsable.weatherservice.service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheInspectionService {

    private final CacheManager cacheManager;

    public CacheInspectionService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void printCacheContents(String cacheName) {

        Cache cache = cacheManager.getCache(cacheName);

        if (cache == null) {
            System.out.println("Cache not found: " + cacheName);
            return;
        }

        Object nativeCache = cache.getNativeCache();

        System.out.println("---- Cache Inspection ----");
        System.out.println("Cache Name: " + cacheName);
        System.out.println("Native Cache Type: " + nativeCache.getClass().getName());
        System.out.println("Cache Data: " + nativeCache);
        System.out.println("--------------------------");
    }
}