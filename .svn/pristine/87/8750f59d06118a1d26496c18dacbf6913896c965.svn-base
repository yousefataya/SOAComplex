package com.dimensions.mw.utils.errorManagement.Helper;

import com.dimensions.mw.utils.OFMException;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProvParserLogic {
    public static String parseProvResponse(String xmlResponse) {
        String msg = "";
        String responseXPath = "//ns3:serviceOrderResponse/ns3:Response";
        String soc = "";
        String sot = "";
        String actionResponseXPath = "//ns3:serviceOrderResponse/ns3:Response/ns3:ActionResponse";
        String actCode = "";
        String actText = "";
        String actTag = "";
        String actOp = "";
        Document doc = ProvParserLogic.generateDoc(xmlResponse);
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            xpath.setNamespaceContext(new UniversalNamespaceCache(doc, false));
            Node resultNode = (Node)xpath.evaluate(responseXPath, doc, XPathConstants.NODE);
            soc = resultNode.getAttributes().getNamedItem("ResultCode") != null ? resultNode.getAttributes().getNamedItem("ResultCode").getTextContent() : null;
            sot = resultNode.getAttributes().getNamedItem("ResultText") != null ? resultNode.getAttributes().getNamedItem("ResultText").getTextContent() : null;
            msg = "ServiceOrderCode = " + soc + ", ServiceOrderText = " + sot + ",";
            resultNode = (Node)xpath.evaluate(actionResponseXPath, doc, XPathConstants.NODE);
            Element actionElm = (Element)resultNode;
            NodeList actions = actionElm.getElementsByTagName("Action");
            msg = msg + " Actions: ";
            for (int i = 0; i < actions.getLength(); ++i) {
                String info;
                actCode = actions.item(i).getAttributes().getNamedItem("ResultCode") != null ? actions.item(i).getAttributes().getNamedItem("ResultCode").getTextContent() : null;
                actText = actions.item(i).getAttributes().getNamedItem("ResultText") != null ? actions.item(i).getAttributes().getNamedItem("ResultText").getTextContent() : null;
                String string = info = actions.item(i).getAttributes().getNamedItem("Info") != null ? actions.item(i).getAttributes().getNamedItem("Info").getTextContent() : null;
                if (info != null) {
                    actText = actText + info;
                }
                actTag = actions.item(i).getAttributes().getNamedItem("ActionTag") != null ? actions.item(i).getAttributes().getNamedItem("ActionTag").getTextContent() : null;
                actOp = actions.item(i).getAttributes().getNamedItem("Operation") != null ? actions.item(i).getAttributes().getNamedItem("Operation").getTextContent() : null;
                String seq = actions.item(i).getAttributes().getNamedItem("SequenceNumber") != null ? actions.item(i).getAttributes().getNamedItem("SequenceNumber").getTextContent() : null;
                msg = msg + "[ActionCode = " + actCode + ", ActionText = " + actText + ", SequenceNumber = " + seq + ", ActionTag = " + actTag + ", Operation = " + actOp;
                NodeList eptElm = ((Element)actions.item(i)).getElementsByTagName("Ept");
                String eptCode = "";
                String eptText = "";
                String eptNum = "";
                msg = msg + " Epts: ";
                for (int j = 0; j < eptElm.getLength(); ++j) {
                    eptCode = eptElm.item(j).getAttributes().getNamedItem("ResultCode") != null ? eptElm.item(j).getAttributes().getNamedItem("ResultCode").getTextContent() : null;
                    eptText = eptElm.item(j).getAttributes().getNamedItem("ResultText") != null ? eptElm.item(j).getAttributes().getNamedItem("ResultText").getTextContent() : null;
                    eptNum = eptElm.item(j).getAttributes().getNamedItem("Number") != null ? eptElm.item(j).getAttributes().getNamedItem("Number").getTextContent() : null;
                    msg = msg + "(EptCode = " + eptCode + ", EptText = " + eptText;
                    NodeList neResponseElm = ((Element)eptElm.item(j)).getElementsByTagName("neResponse");
                    String neResponseText = "";
                    msg = msg + " NEResponse: ";
                    for (int k = 0; k < neResponseElm.getLength(); ++k) {
                        neResponseText = neResponseElm.item(k) != null ? neResponseElm.item(k).getTextContent() : null;
                        msg = msg + "{" + neResponseText + " }";
                    }
                    msg = msg + ")";
                }
                msg = msg + "]";
            }
        }
        catch (Exception e) {
            OFMException ex = new OFMException("OFM RunTime : Unable to parse Prov Response", e);
            msg = ex.getTechMessage() + " | " + xmlResponse;
        }
        return msg;
    }

    public static String parseResponse(String xmlResponse) {
        String msg = "";
        String responseXPath = "ns3:serviceOrderResponse/ns3:Response";
        String soc = "";
        String sot = "";
        String actionResponseXPath = "ns3:serviceOrderResponse/ns3:Response/ns3:ActionResponse";
        String actCode = "";
        String actText = "";
        Document doc = ProvParserLogic.generateDoc(xmlResponse);
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            xpath.setNamespaceContext(new UniversalNamespaceCache(doc, false));
            Node resultNode = (Node)xpath.evaluate(responseXPath, doc, XPathConstants.NODE);
            soc = resultNode.getAttributes().getNamedItem("ResultCode") != null ? resultNode.getAttributes().getNamedItem("ResultCode").getTextContent() : null;
            sot = resultNode.getAttributes().getNamedItem("ResultText") != null ? resultNode.getAttributes().getNamedItem("ResultText").getTextContent() : null;
            msg = "ServiceOrderCode = " + soc + ", ServiceOrderText = " + sot + ",";
            resultNode = (Node)xpath.evaluate(actionResponseXPath, doc, XPathConstants.NODE);
            Element actionElm = (Element)resultNode;
            NodeList actions = actionElm.getElementsByTagName("Action");
            msg = msg + " Actions: ";
            for (int i = 0; i < actions.getLength(); ++i) {
                String info;
                actCode = actions.item(i).getAttributes().getNamedItem("ResultCode") != null ? actions.item(i).getAttributes().getNamedItem("ResultCode").getTextContent() : null;
                actText = actions.item(i).getAttributes().getNamedItem("ResultText") != null ? actions.item(i).getAttributes().getNamedItem("ResultText").getTextContent() : null;
                String string = info = actions.item(i).getAttributes().getNamedItem("Info") != null ? actions.item(i).getAttributes().getNamedItem("Info").getTextContent() : null;
                if (info != null) {
                    actText = actText + info;
                }
                if (actCode.equals("0")) continue;
                msg = msg + "[ActionCode = " + actCode + ", ActionText = " + actText + ",";
                NodeList eptElm = ((Element)actions.item(i)).getElementsByTagName("Ept");
                String eptCode = "";
                String eptText = "";
                String eptNum = "";
                msg = msg + " Epts: ";
                for (int j = 0; j < eptElm.getLength(); ++j) {
                    eptCode = eptElm.item(j).getAttributes().getNamedItem("ResultCode") != null ? eptElm.item(j).getAttributes().getNamedItem("ResultCode").getTextContent() : null;
                    eptText = eptElm.item(j).getAttributes().getNamedItem("ResultText") != null ? eptElm.item(j).getAttributes().getNamedItem("ResultText").getTextContent() : null;
                    eptNum = eptElm.item(j).getAttributes().getNamedItem("Number") != null ? eptElm.item(j).getAttributes().getNamedItem("Number").getTextContent() : null;
                    msg = msg + "(EptCode = " + eptCode + ", EptText = " + eptText;
                    NodeList neResponseElm = ((Element)eptElm.item(j)).getElementsByTagName("neResponse");
                    String neResponseText = "";
                    msg = msg + " NEResponse: ";
                    for (int k = 0; k < neResponseElm.getLength(); ++k) {
                        neResponseText = neResponseElm.item(k) != null ? neResponseElm.item(k).getTextContent() : null;
                        msg = msg + "{" + neResponseText + " }";
                    }
                    msg = msg + ")";
                }
                msg = msg + "]";
            }
        }
        catch (Exception e) {
            OFMException ex = new OFMException("OFM RunTime : Unable to parse Prov Response", e);
            msg = ex.getTechMessage();
        }
        return msg;
    }

    private static Document generateDoc(String response) {
        Document generatedDoc = null;
        try {
            MessageFactory msgFactory = MessageFactory.newInstance();
            SOAPMessage message = msgFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            byte[] buffer = response.getBytes();
            ByteArrayInputStream stream = new ByteArrayInputStream(buffer);
            StreamSource source = new StreamSource(stream);
            soapPart.setContent(source);
            Source src = message.getSOAPPart().getContent();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMResult resultDom = new DOMResult();
            transformer.transform(src, resultDom);
            generatedDoc = (Document)resultDom.getNode();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return generatedDoc;
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n\t<soap:Body>\n\t\t<ns3:submitServiceOrderResponse xmlns:ns2=\"http://www.w3.org/2005/08/addressing\" xmlns:ns3=\"http://www.evolving.com/tsa\" xmlns:ns4=\"http://www.evolving.com/aardschok/soagent/ws/fault\">\n\t\t\t<ns3:serviceOrderResponse>\n\t\t\t\t<ns3:Result>failure</ns3:Result>\n\t\t\t\t<ns3:TransactionId>P-a2a1-3539c262eee01434290428286</ns3:TransactionId>\n\t\t\t\t<ns3:ResultCode>108</ns3:ResultCode>\n\t\t\t\t<ns3:Response TransactionId=\"P-a2a1-3539c262eee01434290428286\" OrderType=\"ADD_SUB\" ResultText=\"SubAlreadyExists\" ResultCode=\"108\">\n\t\t\t\t\t<ns3:ActionResponse>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"KEYS\" Operation=\"\" ResultText=\"Success\" ResultCode=\"0\" SequenceNumber=\"0\"/>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"HLRSUB\" Operation=\"ADD\" ResultText=\"DeniedExecution\" ResultCode=\"202\" SequenceNumber=\"1\">\n\t\t\t\t\t\t\t<ns3:Epts NumberOfEpts=\"0\">\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"1\" Type=\"ADD_HLR_SUB\" ResultText=\"AlreadyExists\" ResultCode=\"808\" Label=\"ADD_SUB.ADD_HLR_SUB.PROVISION\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR1\">\n\t\t\t\t\t\t\t\t\t<ns3:neResponse> \n  MSISDN ALREADY DEFINED   \n\t\t\t\t\t\t\t\t\t</ns3:neResponse>\n\t\t\t\t\t\t\t\t</ns3:Ept>\n\t\t\t\t\t\t\t</ns3:Epts>\n\t\t\t\t\t\t</ns3:Action>\n\t\t\t\t\t</ns3:ActionResponse>\n\t\t\t\t</ns3:Response>\n\t\t\t</ns3:serviceOrderResponse>\n\t\t</ns3:submitServiceOrderResponse>\n\t</soap:Body>\n</soap:Envelope> ";
        xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n\t<soap:Body>\n\t\t<ns3:submitServiceOrderResponse xmlns:ns2=\"http://www.w3.org/2005/08/addressing\" xmlns:ns3=\"http://www.evolving.com/tsa\" xmlns:ns4=\"http://www.evolving.com/aardschok/soagent/ws/fault\">\n\t\t\t<ns3:serviceOrderResponse>\n\t\t\t\t<ns3:Result>failure</ns3:Result>\n\t\t\t\t<ns3:TransactionId>P-a204-681d9d1fafd91434550610704</ns3:TransactionId>\n\t\t\t\t<ns3:ResultCode>105</ns3:ResultCode>\n\t\t\t\t<ns3:Response TransactionId=\"P-a204-681d9d1fafd91434550610704\" OrderType=\"MOD_SUB\" ResultText=\"FailedByNE\" ResultCode=\"105\">\n\t\t\t\t\t<ns3:ActionResponse>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"KEYS\" Operation=\"\" ResultText=\"Success\" ResultCode=\"0\" SequenceNumber=\"0\"/>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"GPRS\" Operation=\"ADD\" ResultText=\"Success\" ResultCode=\"0\" SequenceNumber=\"1\">\n\t\t\t\t\t\t\t<ns3:Epts NumberOfEpts=\"0\">\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"1\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR1\"/>\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"2\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION.SECONDARY\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR2\"/>\n\t\t\t\t\t\t\t</ns3:Epts>\n\t\t\t\t\t\t</ns3:Action>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"ACCESS_MODE\" Operation=\"SET\" ResultText=\"Success\" ResultCode=\"0\" SequenceNumber=\"2\">\n\t\t\t\t\t\t\t<ns3:Epts NumberOfEpts=\"0\">\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"1\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR1\"/>\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"2\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION.SECONDARY\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR2\"/>\n\t\t\t\t\t\t\t</ns3:Epts>\n\t\t\t\t\t\t</ns3:Action>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"RBT\" Operation=\"ADD\" ResultText=\"DeniedExecution\" ResultCode=\"202\" SequenceNumber=\"3\">\n\t\t\t\t\t\t\t<ns3:Epts NumberOfEpts=\"0\">\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"1\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR1\"/>\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"2\" Type=\"MOD_HLR_SUB\" ResultText=\"Success\" ResultCode=\"0\" Label=\"MOD_SUB.MOD_HLR_SUB.PROVISION.SECONDARY\" NeType=\"EricssonGSMHLR\" NeId=\"EricssonGSMHLR2\"/>\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"3\" Type=\"ADD_RBT_SUB\" ResultText=\"NEFailureFATAL\" ResultCode=\"811\" Label=\"MOD_SUB.ADD_RBT_SUB.PROVISION\" NeType=\"SilatRBT\" NeId=\"SilatRBT1\">\n\t\t\t\t\t\t\t\t\t<ns3:neResponse> \n  {&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n\n&lt;xml_gate&gt;\n &lt;auth&gt;\n  &lt;session_id&gt;53BAC9B66E9A29248206A6A92D570FEA.0000014DE182C929&lt;/session_id&gt;\n  &lt;session_key&gt;759150b475abb800&lt;/session_key&gt;\n &lt;/auth&gt;\n &lt;status&gt;ERROR&lt;/status&gt;\n &lt;code&gt;104&lt;/code&gt;\n &lt;description&gt;Internal billing system error: %s&lt;/description&gt;\n&lt;/xml_gate&gt;\n}  \n\t\t\t\t\t\t\t\t\t</ns3:neResponse>\n\t\t\t\t\t\t\t\t</ns3:Ept>\n\t\t\t\t\t\t\t\t<ns3:Ept Number=\"4\" Type=\"DEL_RBT_SUB\" ResultText=\"NEFailureFATAL\" ResultCode=\"811\" Label=\"MOD_SUB.DEL_RBT_SUB.ROLLBACK\" NeType=\"SilatRBT\" NeId=\"SilatRBT1\">\n\t\t\t\t\t\t\t\t\t<ns3:neResponse> \n  {&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n\n&lt;xml_gate&gt;\n &lt;auth&gt;\n  &lt;session_id&gt;53BAC9B66E9A29248206A6A92D570FEA.0000014DE182C929&lt;/session_id&gt;\n  &lt;session_key&gt;759150b475abb800&lt;/session_key&gt;\n &lt;/auth&gt;\n &lt;status&gt;ERROR&lt;/status&gt;\n &lt;code&gt;403&lt;/code&gt;\n &lt;description&gt;Database error: not exists&lt;/description&gt;\n&lt;/xml_gate&gt;\n}  \n\t\t\t\t\t\t\t\t\t</ns3:neResponse>\n\t\t\t\t\t\t\t\t</ns3:Ept>\n\t\t\t\t\t\t\t</ns3:Epts>\n\t\t\t\t\t\t</ns3:Action>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"GPRS\" Operation=\"ADD\" ResultText=\"Unprocessed\" ResultCode=\"203\" SequenceNumber=\"4\"/>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"ACCESS_MODE\" Operation=\"SET\" ResultText=\"Unprocessed\" ResultCode=\"203\" SequenceNumber=\"5\"/>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"ACCESS_MODE\" Operation=\"SET\" ResultText=\"Unprocessed\" ResultCode=\"203\" SequenceNumber=\"6\"/>\n\t\t\t\t\t\t<ns3:Action ActionTag=\"GPRS\" Operation=\"ADD\" ResultText=\"Unprocessed\" ResultCode=\"203\" SequenceNumber=\"7\"/>\n\t\t\t\t\t</ns3:ActionResponse>\n\t\t\t\t</ns3:Response>\n\t\t\t</ns3:serviceOrderResponse>\n\t\t</ns3:submitServiceOrderResponse>\n\t</soap:Body>\n</soap:Envelope>";
        String res = ProvParserLogic.parseProvResponse(xml);
    }

    public static class UniversalNamespaceCache
    implements NamespaceContext {
        private static final String DEFAULT_NS = "DEFAULT";
        private Map<String, String> prefix2Uri = new HashMap<String, String>();
        private Map<String, String> uri2Prefix = new HashMap<String, String>();

        public UniversalNamespaceCache(Document document, boolean toplevelOnly) {
            this.examineNode(document.getFirstChild(), toplevelOnly);
        }

        private void examineNode(Node node, boolean attributesOnly) {
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); ++i) {
                Node attribute = attributes.item(i);
                this.storeAttribute((Attr)attribute);
            }
            if (!attributesOnly) {
                NodeList chields = node.getChildNodes();
                for (int i = 0; i < chields.getLength(); ++i) {
                    Node chield = chields.item(i);
                    if (chield.getNodeType() != 1) continue;
                    this.examineNode(chield, false);
                }
            }
        }

        private void storeAttribute(Attr attribute) {
            if (attribute.getNamespaceURI() != null && attribute.getNamespaceURI().equals("http://www.w3.org/2000/xmlns/")) {
                if (attribute.getNodeName().equals("xmlns")) {
                    this.putInCache(DEFAULT_NS, attribute.getNodeValue());
                } else {
                    this.putInCache(attribute.getLocalName(), attribute.getNodeValue());
                }
            }
        }

        private void putInCache(String prefix, String uri) {
            this.prefix2Uri.put(prefix, uri);
            this.uri2Prefix.put(uri, prefix);
        }

        @Override
        public String getNamespaceURI(String prefix) {
            if (prefix == null || prefix.equals("")) {
                return this.prefix2Uri.get(DEFAULT_NS);
            }
            return this.prefix2Uri.get(prefix);
        }

        @Override
        public String getPrefix(String namespaceURI) {
            return this.uri2Prefix.get(namespaceURI);
        }

        @Override
        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }
    }

}

