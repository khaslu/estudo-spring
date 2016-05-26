package br.com.khaslu.restfulws.model;

/**
 * The Class Greeting.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
public class Greeting {

	/** The id. */
	private Long id;

	/** The content. */
	private String content;

	/**
	 * Instantiates a new greeting.
	 *
	 * @param id
	 *           the id
	 * @param content
	 *           the content
	 */
	public Greeting(final Long id, final String content) {
		super();
		this.id = id;
		this.content = content;
	}

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
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {

		return this.content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content
	 *           the new content
	 */
	public void setContent(final String content) {

		this.content = content;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("Greeting [id=");
		builder.append(this.id);
		builder.append(", content=");
		builder.append(this.content);
		builder.append("]");
		return builder.toString();
	}
}
