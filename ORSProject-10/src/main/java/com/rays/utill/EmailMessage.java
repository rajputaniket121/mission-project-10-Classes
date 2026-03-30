package com.rays.utill;

import org.springframework.stereotype.Component;

/**
 * EmailMessage is a DTO class that contains email configuration and content.
 * Holds email addresses, subject, message body, and message type.
 * 
 * @author Aniket Rajput
 */
@Component
public class EmailMessage {
	
	/**
     * Contains comma separated TO addresses
     */
    private String to = null;

    /**
     * Sender addresses
     */
    private String from = null;

    /**
     * Contains comma separated CC addresses
     */
    private String cc = null;

    /**
     * Contains comma separated BCC addresses
     */
    private String bcc = null;

    /**
     * Contains message subject
     */
    private String subject = null;

    /**
     * Contains message body
     */
    private String message = null;

    /**
     * HTML message constant
     */
    public static final int HTML_MSG = 1;

    /**
     * Text message constant
     */
    public static final int TEXT_MSG = 2;

    /**
     * Message type (HTML/text), default type is text
     */
    private int messageType = TEXT_MSG;

    /**
     * Gets the TO email addresses.
     * 
     * @return comma separated TO addresses
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the TO email addresses.
     * 
     * @param to comma separated TO addresses to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the FROM email address.
     * 
     * @return the FROM address
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the FROM email address.
     * 
     * @param from the FROM address to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the CC email addresses.
     * 
     * @return comma separated CC addresses
     */
    public String getCc() {
        return cc;
    }

    /**
     * Sets the CC email addresses.
     * 
     * @param cc comma separated CC addresses to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Gets the BCC email addresses.
     * 
     * @return comma separated BCC addresses
     */
    public String getBcc() {
        return bcc;
    }

    /**
     * Sets the BCC email addresses.
     * 
     * @param bcc comma separated BCC addresses to set
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * Gets the email subject.
     * 
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the email subject.
     * 
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the email message body.
     * 
     * @return the message body
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the email message body.
     * 
     * @param message the message body to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the message type (HTML or Text).
     * 
     * @return the message type
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * Sets the message type (HTML or Text).
     * 
     * @param messageType the message type to set (HTML_MSG or TEXT_MSG)
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}