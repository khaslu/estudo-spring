package br.com.khaslu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Quote.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	/** The type. */
	private String type;

	/** The value. */
	private Value value;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {

		return this.type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *           the new type
	 */
	public void setType(final String type) {

		this.type = type;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Value getValue() {

		return this.value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *           the new value
	 */
	public void setValue(final Value value) {

		this.value = value;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("Quote [type=");
		builder.append(this.type);
		builder.append(", value=");
		builder.append(this.value);
		builder.append("]");
		return builder.toString();
	}
}
