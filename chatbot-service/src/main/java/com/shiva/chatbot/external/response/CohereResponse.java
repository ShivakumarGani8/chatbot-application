package com.shiva.chatbot.external.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CohereResponse {
    private String id;
    private List<Generations> generations;
    private String prompt;
    private Meta meta;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class Generations{
        private String id;
        private String text;
        private String finish_reason;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class Meta{
        private ApiVersion api_version;
        private BilledUnits billed_units;

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @ToString
        public static class ApiVersion{
            private String version;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @ToString
        public static class BilledUnits{
            private int input_tokens;
            private int output_tokens;
        }
    }

}
