package utilities;


public class PayloadUtil {

    public static String getOrderPayload() {
        return "{\n" +
                "  \"order_id\": \"12345\",\n" +
                "  \"customer\": {\n" +
                "    \"name\": \"Jane Smith\",\n" +
                "    \"email\": \"janesmith@example.com\",\n" +
                "    \"phone\": \"1-987-654-3210\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"456 Oak Street\",\n" +
                "      \"city\": \"Metropolis\",\n" +
                "      \"state\": \"NY\",\n" +
                "      \"zipcode\": \"10001\",\n" +
                "      \"country\": \"USA\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"product_id\": \"A101\",\n" +
                "      \"name\": \"Wireless Headphones\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 79.99\n" +
                "    },\n" +
                "    {\n" +
                "      \"product_id\": \"B202\",\n" +
                "      \"name\": \"Smartphone Case\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 15.99\n" +
                "    }\n" +
                "  ],\n" +
                "  \"payment\": {\n" +
                "    \"method\": \"credit_card\",\n" +
                "    \"transaction_id\": \"txn_67890\",\n" +
                "    \"amount\": 111.97,\n" +
                "    \"currency\": \"USD\"\n" +
                "  },\n" +
                "  \"shipping\": {\n" +
                "    \"method\": \"standard\",\n" +
                "    \"cost\": 5.99,\n" +
                "    \"estimated_delivery\": \"2024-11-15\"\n" +
                "  },\n" +
                "  \"order_status\": \"processing\",\n" +
                "  \"created_at\": \"2024-11-07T12:00:00Z\"\n" +
                "}";
    }
}