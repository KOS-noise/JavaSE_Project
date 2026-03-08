package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        for (Publication p : publications) {
            String type = getPublicationType(p);
            sumMap.put(type, sumMap.getOrDefault(type, 0.0) + p.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> avgMap = new HashMap<>();
        for (String key : sumMap.keySet()) {
            avgMap.put(key, sumMap.get(key) / countMap.get(key));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Double> distMap = new HashMap<>();
        int total = publications.length;
        
        for (Publication p : publications) {
            String type = getPublicationType(p);
            distMap.put(type, distMap.getOrDefault(type, 0.0) + 1);
        }
        
        for (String key : distMap.keySet()) {
            distMap.put(key, (distMap.get(key) / total) * 100);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return ((double) count / publications.length) * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        System.out.println("\n===== 출판물 통계 분석 =====");
        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat dfPercent = new DecimalFormat("#,##0.00");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        // 출력 순서 맞춤
        String[] types = {"소설", "참고서", "잡지"};
        for (String type : types) {
            if(avgPrices.containsKey(type)) {
                System.out.println("   - " + type + ": " + df.format(avgPrices.get(type)) + "원");
            }
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : types) {
            if(distribution.containsKey(type)) {
                System.out.println("   - " + type + ": " + dfPercent.format(distribution.get(type)) + "%");
            }
        }

        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + dfPercent.format(ratio2007) + "%");
    }
}