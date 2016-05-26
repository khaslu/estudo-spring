package br.com.khaslu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Value.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

	/** The id. */
	private Long id;

	/** The quote. */
	private String quote;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *           the new id
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * Gets the quote.
	 *
	 * @return the quote
	 */
	public String getQuote() {

		return this.quote;
	}

	/**
	 * Sets the quote.
	 *
	 * @param quote
	 *           the new quote
	 */
	public void setQuote(final String quote) {

		this.quote = quote;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("Value [id=");
		builder.append(this.id);
		builder.append(", quote=");
		builder.append(this.quote);
		builder.append("]");
		return builder.toString();
	}
}
