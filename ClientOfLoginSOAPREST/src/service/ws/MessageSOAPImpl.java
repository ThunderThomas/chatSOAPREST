
package service.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MessageSOAPImpl", targetNamespace = "http://ws.service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MessageSOAPImpl {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws ApplicationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editMessage", targetNamespace = "http://ws.service/", className = "service.ws.EditMessage")
    @ResponseWrapper(localName = "editMessageResponse", targetNamespace = "http://ws.service/", className = "service.ws.EditMessageResponse")
    @Action(input = "http://ws.service/MessageSOAPImpl/editMessageRequest", output = "http://ws.service/MessageSOAPImpl/editMessageResponse", fault = {
        @FaultAction(className = ApplicationException_Exception.class, value = "http://ws.service/MessageSOAPImpl/editMessage/Fault/ApplicationException")
    })
    public boolean editMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws ApplicationException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<service.ws.Message>
     * @throws ApplicationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMessages", targetNamespace = "http://ws.service/", className = "service.ws.GetMessages")
    @ResponseWrapper(localName = "getMessagesResponse", targetNamespace = "http://ws.service/", className = "service.ws.GetMessagesResponse")
    @Action(input = "http://ws.service/MessageSOAPImpl/getMessagesRequest", output = "http://ws.service/MessageSOAPImpl/getMessagesResponse", fault = {
        @FaultAction(className = ApplicationException_Exception.class, value = "http://ws.service/MessageSOAPImpl/getMessages/Fault/ApplicationException")
    })
    public List<Message> getMessages(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws ApplicationException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws ApplicationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteMessage", targetNamespace = "http://ws.service/", className = "service.ws.DeleteMessage")
    @ResponseWrapper(localName = "deleteMessageResponse", targetNamespace = "http://ws.service/", className = "service.ws.DeleteMessageResponse")
    @Action(input = "http://ws.service/MessageSOAPImpl/deleteMessageRequest", output = "http://ws.service/MessageSOAPImpl/deleteMessageResponse", fault = {
        @FaultAction(className = ApplicationException_Exception.class, value = "http://ws.service/MessageSOAPImpl/deleteMessage/Fault/ApplicationException")
    })
    public boolean deleteMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ApplicationException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws ApplicationException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addMessage", targetNamespace = "http://ws.service/", className = "service.ws.AddMessage")
    @ResponseWrapper(localName = "addMessageResponse", targetNamespace = "http://ws.service/", className = "service.ws.AddMessageResponse")
    @Action(input = "http://ws.service/MessageSOAPImpl/addMessageRequest", output = "http://ws.service/MessageSOAPImpl/addMessageResponse", fault = {
        @FaultAction(className = ApplicationException_Exception.class, value = "http://ws.service/MessageSOAPImpl/addMessage/Fault/ApplicationException")
    })
    public boolean addMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws ApplicationException_Exception
    ;

}
