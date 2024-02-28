import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);

            StringBuilder jsonOutput = new StringBuilder("[\n"); // Start JSON array

            // Reading and including the header in JSON output
            String line = in.readLine(); // Read the first line as header
            String[] headers = line.split(",");
            jsonOutput.append("\n  [");
            for (int i = 0; i < headers.length; i++) {
                jsonOutput.append("\"").append(headers[i]);
                if (i < headers.length - 1) {
                    jsonOutput.append(", ");
                }
            }
            jsonOutput.append("\n]"); //

            // Processing the data lines
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                jsonOutput.append(",\n  [");
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    jsonOutput.append("\"").append(values[i]).append("\"");
                    if (i < values.length - 1) {
                        jsonOutput.append(", ");
                    }
                }
                jsonOutput.append("]");
            }
            jsonOutput.append("\n]"); // End JSON array
            System.out.println(jsonOutput.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
