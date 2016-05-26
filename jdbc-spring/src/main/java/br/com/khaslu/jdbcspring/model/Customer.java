package br.com.khaslu.jdbcspring.model;

/**
 * The Class Customer.
 *
 * @author Lucas Mota Vieira
 * @since 26/05/2016
 */
public class Customer {

	/** The id. */
	private Long id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param id
	 *           the id
	 * @param firstName
	 *           the first name
	 * @param lastName
	 *           the last name
	 */
	public Customer(final Long id, final String firstName, final String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *           the new first name
	 */
	public void setFirstName(final String firstName) {

		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *           the new last name
	 */
	public void setLastName(final String lastName) {

		this.lastName = lastName;
	}

	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(this.id);
		builder.append(", firstName=");
		builder.append(this.firstName);
		builder.append(", lastName=");
		builder.append(this.lastName);
		builder.append("]");
		return builder.toString();
	}
}
