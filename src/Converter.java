public class Converter {
    private final SearchRate sr;

    public Converter() {
        this.sr = new SearchRate("e1a1c13357dd1612de06cb6d");
    }
    public double converter(String currencyCodeIn, String currencyCodeOut, double value) {
        Currency currency = this.sr.search(currencyCodeIn);

        if(!currency.result().equals("error")) {
            double rateValueCurrency = currency.conversionRates().get(currencyCodeOut);
            return value * rateValueCurrency;
        } else {
            return -1;
        }
    }
}