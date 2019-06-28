
package JavaOOp.L03WorkingwithAbstraction.Exercises.p06greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemAndQuantity = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < itemAndQuantity.length; i += 2) {
            String type = itemAndQuantity[i];
            long amaunt = Long.parseLong(itemAndQuantity[i + 1]);

            String itemType = "";

            itemType = checkType(type, itemType);

            if (itemType.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + amaunt) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (amaunt > bag.get("Gold").values().stream()
                                    .mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream()
                            .mapToLong(e -> e)
                            .sum() + amaunt > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (amaunt > bag.get("Gold").values().stream()
                                    .mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream()
                            .mapToLong(e -> e)
                            .sum() + amaunt > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }
                bag.putIfAbsent(itemType,new LinkedHashMap<>());
                bag.get(itemType).putIfAbsent(type,0L);



            bag.get(itemType).put(type, bag.get(itemType).get(type) + amaunt);
            if (itemType.equals("Gold")) {
                gold += amaunt;
            } else if (itemType.equals("Gem")) {
                gems += amaunt;
            } else if (itemType.equals("Cash")) {
                cash += amaunt;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static String checkType(String type, String itemType) {
        if (type.length() == 3) {
            itemType = "Cash";
        } else if (type.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (type.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }
        return itemType;
    }
}