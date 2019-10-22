
package service.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EditMessage_QNAME = new QName("http://ws.service/", "editMessage");
    private final static QName _ApplicationException_QNAME = new QName("http://ws.service/", "ApplicationException");
    private final static QName _DeleteMessageResponse_QNAME = new QName("http://ws.service/", "deleteMessageResponse");
    private final static QName _AddMessage_QNAME = new QName("http://ws.service/", "addMessage");
    private final static QName _AddMessageResponse_QNAME = new QName("http://ws.service/", "addMessageResponse");
    private final static QName _GetMessages_QNAME = new QName("http://ws.service/", "getMessages");
    private final static QName _GetMessagesResponse_QNAME = new QName("http://ws.service/", "getMessagesResponse");
    private final static QName _DeleteMessage_QNAME = new QName("http://ws.service/", "deleteMessage");
    private final static QName _EditMessageResponse_QNAME = new QName("http://ws.service/", "editMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteMessageResponse }
     * 
     */
    public DeleteMessageResponse createDeleteMessageResponse() {
        return new DeleteMessageResponse();
    }

    /**
     * Create an instance of {@link ApplicationException }
     * 
     */
    public ApplicationException createApplicationException() {
        return new ApplicationException();
    }

    /**
     * Create an instance of {@link EditMessage }
     * 
     */
    public EditMessage createEditMessage() {
        return new EditMessage();
    }

    /**
     * Create an instance of {@link EditMessageResponse }
     * 
     */
    public EditMessageResponse createEditMessageResponse() {
        return new EditMessageResponse();
    }

    /**
     * Create an instance of {@link DeleteMessage }
     * 
     */
    public DeleteMessage createDeleteMessage() {
        return new DeleteMessage();
    }

    /**
     * Create an instance of {@link AddMessageResponse }
     * 
     */
    public AddMessageResponse createAddMessageResponse() {
        return new AddMessageResponse();
    }

    /**
     * Create an instance of {@link GetMessages }
     * 
     */
    public GetMessages createGetMessages() {
        return new GetMessages();
    }

    /**
     * Create an instance of {@link GetMessagesResponse }
     * 
     */
    public GetMessagesResponse createGetMessagesResponse() {
        return new GetMessagesResponse();
    }

    /**
     * Create an instance of {@link AddMessage }
     * 
     */
    public AddMessage createAddMessage() {
        return new AddMessage();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "editMessage")
    public JAXBElement<EditMessage> createEditMessage(EditMessage value) {
        return new JAXBElement<EditMessage>(_EditMessage_QNAME, EditMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "ApplicationException")
    public JAXBElement<ApplicationException> createApplicationException(ApplicationException value) {
        return new JAXBElement<ApplicationException>(_ApplicationException_QNAME, ApplicationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "deleteMessageResponse")
    public JAXBElement<DeleteMessageResponse> createDeleteMessageResponse(DeleteMessageResponse value) {
        return new JAXBElement<DeleteMessageResponse>(_DeleteMessageResponse_QNAME, DeleteMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "addMessage")
    public JAXBElement<AddMessage> createAddMessage(AddMessage value) {
        return new JAXBElement<AddMessage>(_AddMessage_QNAME, AddMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "addMessageResponse")
    public JAXBElement<AddMessageResponse> createAddMessageResponse(AddMessageResponse value) {
        return new JAXBElement<AddMessageResponse>(_AddMessageResponse_QNAME, AddMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "getMessages")
    public JAXBElement<GetMessages> createGetMessages(GetMessages value) {
        return new JAXBElement<GetMessages>(_GetMessages_QNAME, GetMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "getMessagesResponse")
    public JAXBElement<GetMessagesResponse> createGetMessagesResponse(GetMessagesResponse value) {
        return new JAXBElement<GetMessagesResponse>(_GetMessagesResponse_QNAME, GetMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "deleteMessage")
    public JAXBElement<DeleteMessage> createDeleteMessage(DeleteMessage value) {
        return new JAXBElement<DeleteMessage>(_DeleteMessage_QNAME, DeleteMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service/", name = "editMessageResponse")
    public JAXBElement<EditMessageResponse> createEditMessageResponse(EditMessageResponse value) {
        return new JAXBElement<EditMessageResponse>(_EditMessageResponse_QNAME, EditMessageResponse.class, null, value);
    }

}
