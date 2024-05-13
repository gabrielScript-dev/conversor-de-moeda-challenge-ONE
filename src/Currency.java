import java.util.Map;

public record Currency(String result, String baseCode, Map<String,Double> conversionRates) {
}