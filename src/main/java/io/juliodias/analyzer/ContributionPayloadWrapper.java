package io.juliodias.analyzer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.gson.Gson;
import java.util.Set;

public final class ContributionPayloadWrapper {

    private final Set<ContributionsDTO> contributionsDTO;

    @JsonCreator
    public ContributionPayloadWrapper(@JsonProperty("nodes") Set<ContributionsDTO> contributionsDTO) {
        this.contributionsDTO = contributionsDTO;
    }

    public Set<ContributionsDTO> getContributionsDTO() {
        return contributionsDTO;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("contributionsDTO", contributionsDTO)
                .toString();
    }

    public static class ContributionsDTO {

        private final ContributionDTO contributionDTO;

        @JsonCreator
        public ContributionsDTO(@JsonProperty("node") ContributionDTO contributionDTO) {
            this.contributionDTO = contributionDTO;
        }

        public ContributionDTO getContributionDTO() {
            return contributionDTO;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("contributionDTO", contributionDTO)
                    .toString();
        }

        public static class ContributionDTO {

            private final String year;
            private final String type;
            private final String gender;
            private final String customerType;
            private final String vlrBenefits;
            private final String totalOfBenefits;
            private final String workServicePeriod;

            @JsonCreator
            public ContributionDTO(@JsonProperty("Ano") String year,
                                   @JsonProperty("Espécie") String type,
                                   @JsonProperty("Anos de Serviço do Segurado") String workServicePeriod,
                                   @JsonProperty("Sexo") String gender,
                                   @JsonProperty("Clientela") String customerType,
                                   @JsonProperty("Qtde Benefícios Concedidos") String totalOfBenefits,
                                   @JsonProperty("Vlr Benefícios Concedidos (R$)") String vlrBenefits) {
                this.year = year;
                this.type = type;
                this.gender = gender;
                this.vlrBenefits = vlrBenefits;
                this.customerType = customerType;
                this.totalOfBenefits = totalOfBenefits;
                this.workServicePeriod = workServicePeriod;
            }

            public String getYear() {
                return year;
            }

            public String getType() {
                return type;
            }

            public String getWorkServicePeriod() {
                return workServicePeriod;
            }

            public String getGender() {
                return gender;
            }

            public String getCustomerType() {
                return customerType;
            }

            public String getTotalOfBenefits() {
                return totalOfBenefits;
            }

            public String getVlrBenefits() {
                return vlrBenefits;
            }

            @Override
            public String toString() {
                return new Gson().toJson(this);
            }
        }
    }
}
