package io.AdaSimulacion.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Acknowledge of an unsuccessful bank data aggregation process.")

public class AckFailureADAConsumption extends AckBankDataAggregation {
	@SerializedName("bankDataAggregation")
	private FailureADAConsumption bankDataAggregation = null;

	public AckFailureADAConsumption bankDataAggregation(FailureADAConsumption bankDataAggregation) {
		this.bankDataAggregation = bankDataAggregation;
		return this;
	}

	@ApiModelProperty(value = "")
	public FailureADAConsumption getBankDataAggregation() {
		return bankDataAggregation;
	}

	public void setBankDataAggregation(FailureADAConsumption bankDataAggregation) {
		this.bankDataAggregation = bankDataAggregation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AckFailureADAConsumption ackFailureADAConsumption = (AckFailureADAConsumption) o;
		return Objects.equals(this.bankDataAggregation, ackFailureADAConsumption.bankDataAggregation)
				&& super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankDataAggregation, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AckFailureADAConsumption {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    bankDataAggregation: ").append(toIndentedString(bankDataAggregation)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
