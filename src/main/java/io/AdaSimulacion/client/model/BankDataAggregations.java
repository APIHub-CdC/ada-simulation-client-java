package io.AdaSimulacion.client.model;

import java.util.ArrayList;
import java.util.Objects;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "A list of bank data aggregation processes.")

public class BankDataAggregations extends ArrayList<BankDataAggregation> {

	private static final long serialVersionUID = -1944498140089189651L;

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BankDataAggregations {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
