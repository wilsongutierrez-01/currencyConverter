package alura.courses.com.dto;

public record Currency(String baseCode, String targetCode, Double conversionRate, Double conversionResult) {
}
