package io.AdaSimulacion.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.threeten.bp.LocalDate;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class Account {
	@SerializedName("startDate")
	private LocalDate startDate = null;
	@SerializedName("endDate")
	private LocalDate endDate = null;
	@SerializedName("allAccounts")
	private List<AllAccounts> allAccounts = null;

	public Account startDate(LocalDate startDate) {
		this.startDate = startDate;
		return this;
	}

	@ApiModelProperty(example = "2020-11-24", value = "Format based on the internet standard, RFC3339 - 5.6")
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Account endDate(LocalDate endDate) {
		this.endDate = endDate;
		return this;
	}

	@ApiModelProperty(example = "2021-2-19", value = "Format based on the internet standard, RFC3339 - 5.6")
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Account allAccounts(List<AllAccounts> allAccounts) {
		this.allAccounts = allAccounts;
		return this;
	}

	public Account addAllAccountsItem(AllAccounts allAccountsItem) {
		if (this.allAccounts == null) {
			this.allAccounts = new ArrayList<AllAccounts>();
		}
		this.allAccounts.add(allAccountsItem);
		return this;
	}

	@ApiModelProperty(value = "")
	public List<AllAccounts> getAllAccounts() {
		return allAccounts;
	}

	public void setAllAccounts(List<AllAccounts> allAccounts) {
		this.allAccounts = allAccounts;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(this.startDate, account.startDate) && Objects.equals(this.endDate, account.endDate)
				&& Objects.equals(this.allAccounts, account.allAccounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startDate, endDate, allAccounts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Account {\n");

		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    allAccounts: ").append(toIndentedString(allAccounts)).append("\n");
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
