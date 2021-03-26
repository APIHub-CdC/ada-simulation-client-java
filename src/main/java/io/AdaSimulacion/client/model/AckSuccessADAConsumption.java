package io.AdaSimulacion.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Acknowledge of a successful bank data aggregation process.")

public class AckSuccessADAConsumption extends AckBankDataAggregation {
	@SerializedName("bankDataAggregation")
	private SuccessADAConsumption bankDataAggregation = null;
	@SerializedName("errors")
	private List<Error> errors = null;

	public AckSuccessADAConsumption bankDataAggregation(SuccessADAConsumption bankDataAggregation) {
		this.bankDataAggregation = bankDataAggregation;
		return this;
	}

	@ApiModelProperty(value = "")
	public SuccessADAConsumption getBankDataAggregation() {
		return bankDataAggregation;
	}

	public void setBankDataAggregation(SuccessADAConsumption bankDataAggregation) {
		this.bankDataAggregation = bankDataAggregation;
	}

	public AckSuccessADAConsumption errors(List<Error> errors) {
		this.errors = errors;
		return this;
	}

	public AckSuccessADAConsumption addErrorsItem(Error errorsItem) {
		if (this.errors == null) {
			this.errors = new ArrayList<Error>();
		}
		this.errors.add(errorsItem);
		return this;
	}

	@ApiModelProperty(value = "List of errors.")
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AckSuccessADAConsumption ackSuccessADAConsumption = (AckSuccessADAConsumption) o;
		return Objects.equals(this.bankDataAggregation, ackSuccessADAConsumption.bankDataAggregation)
				&& Objects.equals(this.errors, ackSuccessADAConsumption.errors) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankDataAggregation, errors, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AckSuccessADAConsumption {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    bankDataAggregation: ").append(toIndentedString(bankDataAggregation)).append("\n");
		sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
