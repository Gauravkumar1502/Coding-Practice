package codingproblems.tcscodevita.season11round2_20012024;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD {

    static List<List<Integer>> generateConfigurations(int L, List<Integer> blocks) {
        List<List<Integer>> configurations = new ArrayList<>();
        generateConfigurationsHelper(L, blocks, new ArrayList<>(), configurations);
        return configurations;
    }

    static void generateConfigurationsHelper(int remainingHeight, List<Integer> blocks, List<Integer> currentConfig, List<List<Integer>> configurations) {
        if (remainingHeight == 0) {
            configurations.add(new ArrayList<>(currentConfig));
            return;
        }

        for (int block : blocks) {
            if (remainingHeight - block >= 0) {
                currentConfig.add(block);
                generateConfigurationsHelper(remainingHeight - block, blocks, currentConfig, configurations);
                currentConfig.remove(currentConfig.size() - 1);
            }
        }
    }

    static Map<Integer, Integer> calculateFrequencies(List<Integer> configuration) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int block : configuration) {
            frequencyMap.put(block, frequencyMap.getOrDefault(block, 0) + 1);
        }
        return frequencyMap;
    }

    static void christmasTower(int L, List<Integer> blocks) {
        List<List<Integer>> configurations = generateConfigurations(L, blocks);
        configurations.sort((config1, config2) -> {
            Map<Integer, Integer> freqMap1 = calculateFrequencies(config1);
            Map<Integer, Integer> freqMap2 = calculateFrequencies(config2);

            int maxFreq1 = Collections.max(freqMap1.values());
            int maxFreq2 = Collections.max(freqMap2.values());

            if (maxFreq1 != maxFreq2) {
                return Integer.compare(maxFreq2, maxFreq1);
            } else {
                return compareBlocks(config1, config2);
            }
        });

        for (List<Integer> config : configurations) {
            Map<Integer, Integer> frequencies = calculateFrequencies(config);
            boolean validConfiguration = true;

            if (validConfiguration) {
                List<Integer> result = new ArrayList<>(frequencies.keySet());
                result.sort((a, b) -> {
                    int freqCompare = Integer.compare(frequencies.get(b), frequencies.get(a));
                    return (freqCompare != 0) ? freqCompare : Integer.compare(a, b);
                });

                out.print(String.join(" ", result.stream().map(Object::toString).toArray(String[]::new)));
                return;
            }
        }

        out.print("Impossible");
    }

    static int compareBlocks(List<Integer> config1, List<Integer> config2) {
        for (int i = 0; i < config1.size(); i++) {
            if (!config1.get(i).equals(config2.get(i))) {
                return Integer.compare(config1.get(i), config2.get(i));
            }
        }
        return 0;
    }

    static BufferedReader reader;
    static PrintWriter out;
    public static void main(String[] args) throws NumberFormatException, IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int L = Integer.parseInt(reader.readLine());
        List<Integer> blocks = new ArrayList<>();
        Arrays.stream(reader.readLine().split(" ")).forEach(block -> blocks.add(Integer.parseInt(block)));
        christmasTower(L, blocks);
        out.flush();
        reader.close();
        out.close();
    }
}
