package com.hengyunsoft.sso.webflow;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AbstractDefaultAttributePersonAttributeDao;

public class QueryPersonAttribute extends AbstractDefaultAttributePersonAttributeDao {

	@Override
	public Set<IPersonAttributes> getPeopleWithMultivaluedAttributes(
			Map<String, List<Object>> query) {
		return Collections.EMPTY_SET;
	}

	@Override
	public Set<String> getPossibleUserAttributeNames() {
		return Collections.EMPTY_SET;
	}

	@Override
	public Set<String> getAvailableQueryAttributes() {
		return Collections.EMPTY_SET;
	}

}
