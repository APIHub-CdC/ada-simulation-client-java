package io.AdaSimulacion.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")

public class ConfigurationRequestPrincipal {
	@SerializedName("user_name")
	private String userName = null;
	@SerializedName("authorization_statement")
	private String authorizationStatement = null;
	@SerializedName("user_logo")
	private String userLogo = null;
	@SerializedName("primary_color")
	private String primaryColor = null;
	@SerializedName("secondary_color")
	private String secondaryColor = null;

	public ConfigurationRequestPrincipal userName(String userName) {
		this.userName = userName;
		return this;
	}

	@ApiModelProperty(example = "Círculo de Crédito", value = "Commercial name that will be display below the card title.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ConfigurationRequestPrincipal authorizationStatement(String authorizationStatement) {
		this.authorizationStatement = authorizationStatement;
		return this;
	}

	@ApiModelProperty(example = "INT (CIF: ) solicita su permiso para realizar las siguientes acciones:", value = "Text shown next to the commercial name.")
	public String getAuthorizationStatement() {
		return authorizationStatement;
	}

	public void setAuthorizationStatement(String authorizationStatement) {
		this.authorizationStatement = authorizationStatement;
	}

	public ConfigurationRequestPrincipal userLogo(String userLogo) {
		this.userLogo = userLogo;
		return this;
	}

	@ApiModelProperty(example = "data:image/png;base64,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", value = "Contains the base64 value of the logo, it is necessary begin with \"data:image/png;base64, \"")
	public String getUserLogo() {
		return userLogo;
	}

	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}

	public ConfigurationRequestPrincipal primaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
		return this;
	}

	@ApiModelProperty(example = "#0E1D36", value = "An hexadecimal value that contains the primary colour of th page.")
	public String getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}

	public ConfigurationRequestPrincipal secondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
		return this;
	}

	@ApiModelProperty(example = "#ECB330", value = "An hexadecimal value that contains the secondary colour of th page.")
	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConfigurationRequestPrincipal configurationRequestPrincipal = (ConfigurationRequestPrincipal) o;
		return Objects.equals(this.userName, configurationRequestPrincipal.userName)
				&& Objects.equals(this.authorizationStatement, configurationRequestPrincipal.authorizationStatement)
				&& Objects.equals(this.userLogo, configurationRequestPrincipal.userLogo)
				&& Objects.equals(this.primaryColor, configurationRequestPrincipal.primaryColor)
				&& Objects.equals(this.secondaryColor, configurationRequestPrincipal.secondaryColor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, authorizationStatement, userLogo, primaryColor, secondaryColor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ConfigurationRequestPrincipal {\n");

		sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
		sb.append("    authorizationStatement: ").append(toIndentedString(authorizationStatement)).append("\n");
		sb.append("    userLogo: ").append(toIndentedString(userLogo)).append("\n");
		sb.append("    primaryColor: ").append(toIndentedString(primaryColor)).append("\n");
		sb.append("    secondaryColor: ").append(toIndentedString(secondaryColor)).append("\n");
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
