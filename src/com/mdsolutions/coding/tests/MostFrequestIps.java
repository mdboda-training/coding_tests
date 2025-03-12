package com.mdsolutions.coding.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequestIps {

	public static void main(String[] args) {
		String[] ips = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"};
		List<String> ipLIst = Arrays.asList(ips);
		
        Map<String, Long> ipCounts = ipLIst.stream()
                .map(line -> line.split(" ")[0]) 
                .collect(Collectors.groupingBy(ip -> ip, Collectors.counting()));

        long maxCount = ipCounts.values().stream()
                .max(Long::compare)
                .orElse(0L); // Handle empty map case

        List<String> mostFrequentIPs = ipCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

         String.join(",", mostFrequentIPs);
         System.out.println(mostFrequentIPs);
//		Map<String, Long> map = ipList.stream().map(ip->ip.split(" ")[0])
//         .collect(Collectors.groupingBy( (ip)-> ip, Collectors.counting()));//.max(Collectors.counting());
//		long length = map.entrySet().stream().coll .max(Long::compare).orElse(0L);
//		System.out.println(length);
//		map.entrySet().stream().filter(e -> e.getValue()==length).forEach(s -> s.getKey());
//		filter(ip -> ip.contains(" ")).flatMap(ip ->  Arrays.stream(ip.split(" "))).collect(Collectors.groupingBy(ip-> ip, Collectors.counting())).forEach((t, u) -> System.out.println(t+" :: "+u));;
	}
}
