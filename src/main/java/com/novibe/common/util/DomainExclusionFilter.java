package com.novibe.common.util;

import java.util.List;

public class DomainExclusionFilter {

    public static boolean isExcluded(String domain, List<String> excludedDomains) {
        String normalizedDomain = normalize(domain);
        return excludedDomains.stream()
                .map(DomainExclusionFilter::normalize)
                .anyMatch(excluded -> normalizedDomain.equals(excluded) || normalizedDomain.endsWith("." + excluded));
    }

    public static String normalize(String domain) {
        String normalized = domain.strip().toLowerCase();
        if (normalized.startsWith("www.")) {
            return normalized.substring("www.".length());
        }
        return normalized;
    }
}
