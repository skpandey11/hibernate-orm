package org.hibernate.envers.test.integration.onetoone.bidirectional.primarykeyjoincolumn;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Proxy;

/**
 * @author Lukasz Antoniak (lukasz dot antoniak at gmail dot com)
 */
@Entity
@Proxy(lazy = true)
public class NotAuditedProxyPerson implements Serializable {
	@Id
	@Column(name = "PERSON_ID")
	@GeneratedValue(generator = "NotAuditedProxyKeyGenerator")
	@GenericGenerator(name = "NotAuditedProxyKeyGenerator", strategy = "foreign",
					  parameters = {@Parameter(name = "property", value = "account")})
	private Long personId;

	private String name;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "PERSON_ID", referencedColumnName = "ACCOUNT_ID")
	private AccountNotAuditedOwners account;

	public NotAuditedProxyPerson() {
	}

	public NotAuditedProxyPerson(String name) {
		this.name = name;
	}

	public NotAuditedProxyPerson(Long personId, String name) {
		this.personId = personId;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !(o instanceof NotAuditedProxyPerson) ) {
			return false;
		}

		NotAuditedProxyPerson person = (NotAuditedProxyPerson) o;

		if ( personId != null ? !personId.equals( person.personId ) : person.personId != null ) {
			return false;
		}
		if ( name != null ? !name.equals( person.name ) : person.name != null ) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = personId != null ? personId.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "NotAuditedProxyPerson(personId = " + personId + ", name = " + name + ")";
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountNotAuditedOwners getAccount() {
		return account;
	}

	public void setAccount(AccountNotAuditedOwners account) {
		this.account = account;
	}
}
