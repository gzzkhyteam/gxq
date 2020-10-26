package com.hengyunsoft.sso.webflow;

import javax.validation.constraints.NotNull;

import org.jasig.cas.ticket.UniqueTicketIdGenerator;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;


@Component("generateRemoteLoginTicketAction")
public class GenerateRemoteLoginTicketAction {
	
    private static final String PREFIX = "LT";

    /** Logger instance. */
    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    @NotNull
    private UniqueTicketIdGenerator ticketIdGenerator;

    /**
     * Generate the login ticket.
     *
     * @param context the context
     * @return {@code "generated"}
     */
    public final String generate(final RequestContext context) {
        final String loginTicket = this.ticketIdGenerator.getNewTicketId(PREFIX);
        logger.debug("Generated login ticket {}", loginTicket);
        WebUtils.putLoginTicket(context, loginTicket);
        
        return "generated";
    }

    @Autowired
    public void setTicketIdGenerator(@Qualifier("loginTicketUniqueIdGenerator") final UniqueTicketIdGenerator generator) {
        this.ticketIdGenerator = generator;
    }
}
