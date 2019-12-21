<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction" xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator" xmlns:tns="http://employee.fact" xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ns0="http://xmlns.oracle.com/pcbpel/adapter/db/sp/getEmailRestrictionUsersReference" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes=" xsd oracle-xsl-mapper xsi xsl ns0 tns mhdr oraext xp20 xref socket dvm oraxsl"
                xmlns:ns1="http://xmlns.oracle.com/pcbpel/adapter/db/HR/EmployeeService/getEmailRestrictionUsersReference"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:jca="http://xmlns.oracle.com/pcbpel/wsdl/jca/"
                xmlns:ax211="http://employeeFinancial.bean.fact/xsd"
                xmlns:ax230="http://WorkFlowStructure.bean.fact/xsd"
                xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl" xmlns:ns2="http://org.apache.axis2/xsd"
                xmlns:ax28="http://evaluation.bean.fact/xsd" xmlns:ax214="http://employeeInfoDetails.bean.fact/xsd"
                xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:ax227="http://salarySlip.bean.fact/xsd"
                xmlns:ax217="http://leave.bean.fact/xsd" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/"
                xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:ax224="http://employment.bean.fact/xsd"
                xmlns:ax238="http://dao.fact/xsd" xmlns:ax233="http://utility.bean.fact/xsd"
                xmlns:ax225="http://common.bean.fact/xsd" xmlns:ax221="http://employee.bean.fact/xsd"
                xmlns:ax21="http://vacation.bean.fact/xsd" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/"
                xmlns:ax236="http://email.bean.fact/xsd" xmlns:ax25="http://overTime.bean.fact/xsd">
   <oracle-xsl-mapper:schema>
      <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
      <oracle-xsl-mapper:mapSources>
         <oracle-xsl-mapper:source type="WSDL">
            <oracle-xsl-mapper:schema location="../WSDLs/getEmailRestrictionUsersReference.wsdl"/>
            <oracle-xsl-mapper:rootElement name="OutputParameters" namespace="http://xmlns.oracle.com/pcbpel/adapter/db/sp/getEmailRestrictionUsersReference"/>
         </oracle-xsl-mapper:source>
      </oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:mapTargets>
         <oracle-xsl-mapper:target type="WSDL">
            <oracle-xsl-mapper:schema location="../WSDLs/EmployeeService.wsdl"/>
            <oracle-xsl-mapper:rootElement name="getEmailRestrictionUsersResponse" namespace="http://employee.fact"/>
         </oracle-xsl-mapper:target>
      </oracle-xsl-mapper:mapTargets>
      <!--GENERATED BY ORACLE XSL MAPPER 12.2.1.1.0(XSLT Build 160608.1900.0023) AT [THU DEC 28 10:37:03 IST 2017].-->
   </oracle-xsl-mapper:schema>
   <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
   <xsl:template match="/">
      <tns:getEmailRestrictionUsersResponse>
         <tns:return>
            <xsl:for-each select="/ns0:OutputParameters/ns0:OUT_EMP_WITH_CC/ns0:OUT_EMP_WITH_CC_Row">
               <ax236:arrEmailListIn>
                  <xsl:if test="ns0:EMP_NAME_A">
                     <ax236:strEmployeeName>
                        <xsl:value-of select="ns0:EMP_NAME_A"/>
                     </ax236:strEmployeeName>
                  </xsl:if>
                  <xsl:if test="ns0:EMP_ACNT_NO">
                     <ax236:strEmployeeNumber>
                        <xsl:value-of select="ns0:EMP_ACNT_NO"/>
                     </ax236:strEmployeeNumber>
                  </xsl:if>
               </ax236:arrEmailListIn>
            </xsl:for-each>
            <xsl:for-each select="/ns0:OutputParameters/ns0:OUT_EMP_WITHOUT_CC/ns0:OUT_EMP_WITHOUT_CC_Row">
               <ax236:arrEmailListOut>
                  <xsl:if test="ns0:EMP_NAME_A">
                     <ax236:strEmployeeName>
                        <xsl:value-of select="ns0:EMP_NAME_A"/>
                     </ax236:strEmployeeName>
                  </xsl:if>
                  <xsl:if test="ns0:EMP_ACNT_NO">
                     <ax236:strEmployeeNumber>
                        <xsl:value-of select="ns0:EMP_ACNT_NO"/>
                     </ax236:strEmployeeNumber>
                  </xsl:if>
               </ax236:arrEmailListOut>
            </xsl:for-each>
         </tns:return>
      </tns:getEmailRestrictionUsersResponse>
   </xsl:template>
</xsl:stylesheet>