<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction" xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/db/top/InsertJobsDbReference" xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator" xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns0="http://TargetNamespace.com/HCMJobsRestRef_GetJobs_response" exclude-result-prefixes=" xsd oracle-xsl-mapper xsi xsl ns0 tns mhdr oraext xp20 xref socket dvm oraxsl"
                xmlns:plnk="http://docs.oasis-open.org/wsbpel/2.0/plnktype"
                xmlns:ns1="http://xmlns.oracle.com/HCMCloudServices/HCMJobs/HCMJobsRestRef"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ns2="http://xmlns.oracle.com/pcbpel/adapter/db/HCMCloudServices/HCMJobs/InsertJobsDbReference"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:jca="http://xmlns.oracle.com/pcbpel/wsdl/jca/">
   <oracle-xsl-mapper:schema>
      <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
      <oracle-xsl-mapper:mapSources>
         <oracle-xsl-mapper:source type="WSDL">
            <oracle-xsl-mapper:schema location="../WSDLs/HCMJobsRestRef.wsdl"/>
            <oracle-xsl-mapper:rootElement name="Root-Element" namespace="http://TargetNamespace.com/HCMJobsRestRef_GetJobs_response"/>
         </oracle-xsl-mapper:source>
      </oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:mapTargets>
         <oracle-xsl-mapper:target type="WSDL">
            <oracle-xsl-mapper:schema location="../WSDLs/InsertJobsDbReference.wsdl"/>
            <oracle-xsl-mapper:rootElement name="HcmJobMCollection" namespace="http://xmlns.oracle.com/pcbpel/adapter/db/top/InsertJobsDbReference"/>
         </oracle-xsl-mapper:target>
      </oracle-xsl-mapper:mapTargets>
      <!--GENERATED BY ORACLE XSL MAPPER 12.2.1.1.0(XSLT Build 160608.1900.0023) AT [TUE MAR 06 14:37:41 EET 2018].-->
   </oracle-xsl-mapper:schema>
   <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
   <xsl:template match="/">
      <tns:HcmJobMCollection>
         <xsl:for-each select="/ns0:Root-Element/ns0:items">
            <tns:HcmJobM>
               <tns:code>
                  <xsl:value-of select="ns0:JobCode"/>
               </tns:code>
               <tns:jobDesc>
                  <xsl:value-of select="ns0:Name"/>
               </tns:jobDesc>
               <tns:status>1</tns:status>
               <tns:dateCreated>
                  <xsl:value-of select="ns0:CreationDate"/>
               </tns:dateCreated>
               <tns:dateModified>
                  <xsl:value-of select="ns0:LastUpdateDate"/>
               </tns:dateModified>
               <tns:jobId>
                  <xsl:value-of select="ns0:JobId"/>
               </tns:jobId>
            </tns:HcmJobM>
         </xsl:for-each>
      </tns:HcmJobMCollection>
   </xsl:template>
</xsl:stylesheet>
